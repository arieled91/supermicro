package micro;// Generated from Micro.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MicroParser}.
 */
public interface MicroListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MicroParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MicroParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MicroParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#listOfSentence}.
	 * @param ctx the parse tree
	 */
	void enterListOfSentence(MicroParser.ListOfSentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#listOfSentence}.
	 * @param ctx the parse tree
	 */
	void exitListOfSentence(MicroParser.ListOfSentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#sentence}.
	 * @param ctx the parse tree
	 */
	void enterSentence(MicroParser.SentenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#sentence}.
	 * @param ctx the parse tree
	 */
	void exitSentence(MicroParser.SentenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#listOfIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterListOfIdentifier(MicroParser.ListOfIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#listOfIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitListOfIdentifier(MicroParser.ListOfIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#listOfExpression}.
	 * @param ctx the parse tree
	 */
	void enterListOfExpression(MicroParser.ListOfExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#listOfExpression}.
	 * @param ctx the parse tree
	 */
	void exitListOfExpression(MicroParser.ListOfExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MicroParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MicroParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(MicroParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(MicroParser.PrimaryContext ctx);
}