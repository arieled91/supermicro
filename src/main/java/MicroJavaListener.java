import org.antlr.v4.runtime.tree.TerminalNode;
import org.jetbrains.annotations.NotNull;
import utils.IMessage;

import java.util.HashSet;
import java.util.Set;

public class MicroJavaListener extends MicroBaseListener implements IMessage{

    private final StringBuilder code = new StringBuilder();

    final Set<String> declaredId = new HashSet<>();
    final Set<String> calledId = new HashSet<>();

    private final String className;

    public MicroJavaListener(String className) {
        this.className = className;
    }

    @Override public void enterProgram(MicroParser.ProgramContext ctx) {
        code.append("import java.util.Scanner;\n");
        code.append(String.format("public class %s {", className));
        code.append("public static void main(String[] args) {");
        code.append("Scanner read = new Scanner(System.in);");
    }

    @Override public void exitProgram(MicroParser.ProgramContext ctx) {
        code.append("}}");
        checkIdDeclared();
        //FileUtil.write("Test"+".java",code.toString());
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
        code.append(String.format("if(%s){",comparisson));
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
        code.append("}");
    }

    public void assignStatement(TerminalNode identifier, MicroParser.ExpressionContext expression){

        final String id = identifier.toString();

        String line =  "";

        if(!declaredId.contains(id)){
            line+="double ";
            declaredId.add(id);
        }

        line+=id+" = "+expressionToJava(expression)+";";
        code.append(line);
    }

    public void readStatement(MicroParser.ListOfIdentifierContext listOfIdentifier){
        for (final TerminalNode id : listOfIdentifier.Identifier()) {
            final String declare = declaredId.contains(id.toString()) ? "" : "double ";
            code.append(String.format("System.out.println(\"Ingrese %s: \");", id.toString()));
            code.append(String.format(""+declare+"%s = read.nextDouble();", id.toString()));
            declaredId.add(id.toString());
        }
    }

    public void writeStatement(MicroParser.ListOfExpressionContext listOfExpression){
        final String expressions = listOfExpressionToJava(listOfExpression);
        code.append(String.format("System.out.println(%s);",expressions));
    }


    @NotNull private String comparissonToJava(MicroParser.ComparisonContext comparison, Iterable<MicroParser.RightComparisonContext> rightComparisons){
        final StringBuilder buffer = new StringBuilder(leftComparissonToJava(comparison));

        for (final MicroParser.RightComparisonContext rightComparison : rightComparisons) {
            buffer.append(" ");
            buffer.append(logicalToJava(rightComparison.LogicalOperator()));
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

    public String logicalToJava(TerminalNode logicalOperator){
        final char logicalChar = logicalOperator.getText().charAt(0);
        switch (logicalChar){
            case '&': return "&&";
            case '|': return "||";
        }

        return "";

        //if(logicalOperator.)
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
            calledId.add(id.toString());
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

    private void checkIdDeclared(){
        for (final String id : calledId) {
            if(id!=null && !declaredId.contains(id)){
                System.err.printf(ID_NOT_DECLARED_ERROR, id);
                System.exit(1);
            }
        }
    }



    public String getCode(){
        return code.toString();
    }

}
