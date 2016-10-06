import org.antlr.v4.runtime.misc.Nullable;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;
import utils.FileUtil;
import utils.IMessage;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MicroJavaListener extends MicroBaseListener implements IMessage{

    private final List<String> file = new ArrayList<>();
    final Set<String> identifiers = new HashSet<>();

    private final String filePath;

    public MicroJavaListener(String filePath) {
        this.filePath = filePath;
    }

    @Override public void enterProgram(MicroParser.ProgramContext ctx) {
        file.add("import java.util.Scanner;\n");
        file.add(String.format("public class %s {", buildClassName(filePath, false)));
        file.add("\tpublic static void main(String[] args) {");
        file.add("\t\tScanner read = new Scanner(System.in);");
    }

    @Override public void exitProgram(MicroParser.ProgramContext ctx) {
        file.add("\t}");
        file.add("}");
        FileUtil.write(buildClassName(filePath,true),file);
    }

    @Override public void exitReadStatement(MicroParser.ReadStatementContext ctx) {
        readStatement(ctx.listOfIdentifier());
    }

    @Override public void exitWriteStatement(MicroParser.WriteStatementContext ctx) {
        writeStatement(ctx.listOfExpression());
    }

    @Override public void exitAssignStatement(MicroParser.AssignStatementContext ctx) {
        assignStatement(ctx.Identifier(), ctx.expression());
    }


    @Override public void exitIfStatement(MicroParser.IfStatementContext ctx) {

        ifStatement(ctx.comparison(), ctx.rightComparison(), ctx.statement());
    }

    public void ifStatement(MicroParser.ComparisonContext coparisson, Iterable<MicroParser.RightComparisonContext> rightComparisons,  Iterable<MicroParser.StatementContext> statements){
        final String comparisson = comparissonToJava(coparisson, rightComparisons);
        file.add(String.format("\t\tif(%s){",comparisson));
        for (final MicroParser.StatementContext statement : statements) {
            if(statement.assignStatement()!=null)
                assignStatement(statement.assignStatement().Identifier(), statement.assignStatement().expression());
            else if(statement.ifStatement()!=null)
                ifStatement(statement.ifStatement().comparison(),rightComparisons, statement.ifStatement().statement());
            else if(statement.readStatement()!=null)
                readStatement(statement.readStatement().listOfIdentifier());
            else if(statement.writeStatement()!=null)
                writeStatement(statement.writeStatement().listOfExpression());
        }
        file.add("\t\t}");
    }

    public void assignStatement(TerminalNode identifier, MicroParser.ExpressionContext expression){

        final String id = identifier.toString();

        String line =  "\t\t";

        if(!identifiers.contains(id)){
            line+="double ";
            identifiers.add(id);
        }

        line+=id+" = "+expressionToJava(expression)+";";
        file.add(line);
    }

    public void readStatement(MicroParser.ListOfIdentifierContext listOfIdentifier){
        for (final TerminalNode id : listOfIdentifier.Identifier()) {
            final String declare = identifiers.contains(id.toString()) ? "" : "double ";
            file.add(String.format("\t\tSystem.out.println(\"Ingrese %s: \");", id.toString()));
            file.add(String.format("\t\t"+declare+"%s = read.nextDouble();", id.toString()));
            identifiers.add(id.toString());
        }
    }

    public void writeStatement(MicroParser.ListOfExpressionContext listOfExpression){
        final String expressions = listOfExpressionToJava(listOfExpression);
        file.add(String.format("\t\tSystem.out.println(%s);",expressions));
    }


    @NotNull private String comparissonToJava(MicroParser.ComparisonContext comparison, Iterable<MicroParser.RightComparisonContext> rightComparisons){
        final StringBuilder buffer = new StringBuilder(leftComparissonToJava(comparison));

        for (final MicroParser.RightComparisonContext rightComparison : rightComparisons) {
            buffer.append(" ");
            buffer.append(rightComparison.LogicalOperator().toString());
            buffer.append(" ");
            buffer.append(leftComparissonToJava(rightComparison.comparison()));
        }
        return buffer.toString();
    }

    public String leftComparissonToJava(MicroParser.ComparisonContext comparison){
        final String compare = comparison.Compare().toString();
        final String left = expressionToJava(comparison.expression(0));
        final String right = expressionToJava(comparison.expression(1));

        return left+" "+ compare+" "+right;
    }


    @NotNull private String listOfExpressionToJava(MicroParser.ListOfExpressionContext listOfExpression){
        final StringBuilder buffer = new StringBuilder();

        for (final MicroParser.ExpressionContext expression : listOfExpression.expression()) {
            final String text = expressionToJava(expression);
            if(buffer.length()!=0 && !text.isEmpty()) buffer.append(" +\" \"+ ");
            buffer.append(expressionToJava(expression));
        }

        return buffer.toString();
    }

    @NotNull private String primaryToJava(MicroParser.PrimaryContext primary){
        if(primary.Identifier()!=null){
            final TerminalNode id = primary.Identifier();
            checkIsDeclared(id);
            return id.toString();
        }

        if(primary.Constant()!=null)
            return primary.Constant().toString();

        if(primary.expression()!=null)
            return "("+expressionToJava(primary.expression())+")";

        return "";
    }

    @NotNull private String expressionToJava(MicroParser.ExpressionContext expression){
        final StringBuilder buffer = new StringBuilder(primaryToJava(expression.primary()));

        for (final MicroParser.RightPrimaryContext rightPrimary : expression.rightPrimary()) {
            buffer.append(rightPrimary.Operator().toString());
            buffer.append(primaryToJava(rightPrimary.primary()));
        }

        return buffer.toString();
    }

    private void checkIsDeclared(@Nullable TerminalNode id){
        if(id!=null && !identifiers.contains(id.toString())){
            System.err.printf(ID_NOT_DECLARED_ERROR, id.toString());
            System.exit(1);
        }
    }

    public String buildClassName(String originPath, boolean fullPath){
        final String[] pathSplit = originPath.split(File.separator);
        final String fileName = pathSplit[pathSplit.length - 1];
        final String name = fileName.replace(".m","");
        final String camelcase = name.substring(0, 1).toUpperCase() + name.substring(1); //to camelcase
        if(fullPath){
            pathSplit[pathSplit.length - 1] = camelcase;
            return originPath.substring(0,originPath.length()-fileName.length())+camelcase+".java";
        }
        return camelcase;
    }

}
