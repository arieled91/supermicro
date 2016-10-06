import org.antlr.v4.runtime.misc.Nullable;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MicroJavaListener extends MicroBaseListener {

    private List<String> file = new ArrayList<>();
    final Set<String> identifiers = new HashSet<>();

    private String filePath;

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

    @Override public void exitReadOperation(MicroParser.ReadOperationContext ctx) {
        for (TerminalNode id : ctx.listOfIdentifier().Identifier()) {
            String declare = identifiers.contains(id.toString()) ? "" : "int ";
            file.add(String.format("\t\tSystem.out.println(\"Ingrese %s: \");", id.toString()));
            file.add(String.format("\t\t"+declare+"%s = read.nextInt();", id.toString()));
            identifiers.add(id.toString());
        }
    }

    @Override public void exitWriteOperation(MicroParser.WriteOperationContext ctx) {
        String listOfExpression = listOfExpressionToJava(ctx.listOfExpression());
        file.add(String.format("\t\tSystem.out.println(%s);",listOfExpression));
    }

    @Override public void exitAssignOperation(MicroParser.AssignOperationContext ctx) {
        String id = ctx.Identifier().toString();

        String line =  "\t\t";

        if(!identifiers.contains(id)){
            line+="int ";
            identifiers.add(id);
        }

        line+=id+" = "+expressionToJava(ctx.expression())+";";
        file.add(line);
    }


    private String listOfExpressionToJava(MicroParser.ListOfExpressionContext listOfExpression){
        StringBuilder buffer = new StringBuilder();

        for (MicroParser.ExpressionContext expression : listOfExpression.expression()) {
            String text = expressionToJava(expression);
            if(buffer.length()!=0 && !text.isEmpty()) buffer.append(" +\" \"+ ");
            buffer.append(expressionToJava(expression));
        }

        return buffer.toString();
    }

    private String primaryToJava(MicroParser.PrimaryContext primary){
        if(primary.Identifier()!=null){
            TerminalNode id = primary.Identifier();
            checkIsDeclared(id);
            return id.toString();
        }

        if(primary.Constant()!=null)
            return primary.Constant().toString();

        if(primary.expression()!=null)
            return "("+expressionToJava(primary.expression())+")";

        return "";
    }

    private String expressionToJava(MicroParser.ExpressionContext expression){
        StringBuilder buffer = new StringBuilder(primaryToJava(expression.primary()));

        for (MicroParser.RightPrimaryContext rightPrimary : expression.rightPrimary()) {
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

    /*private void checkIsNotDeclared(@Nullable TerminalNode id){
        if(id==null) return;
        if(identifiers.contains(id.toString())){
            System.err.printf(ID_NOT_DECLARED_ERROR, id.toString());
            System.exit(1);
        }else identifiers.add(id.toString());
    }*/


    public String buildClassName(String originPath, boolean fullPath){
        String[] pathSplit = originPath.split(File.separator);
        String file = pathSplit[pathSplit.length - 1];
        String name = file.replace(".m","");
        String camelcase = name.substring(0, 1).toUpperCase() + name.substring(1); //to camelcase
        if(fullPath){
            pathSplit[pathSplit.length - 1] = camelcase;
            return originPath.substring(0,originPath.length()-file.length())+camelcase+".java";
        }
        return camelcase;
    }


    private static final String ID_NOT_DECLARED_ERROR = "Identifier \"%s\" is not declared\n";

}
