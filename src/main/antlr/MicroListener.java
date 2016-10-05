// Generated from Micro.g4 by ANTLR 4.5.3
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
	 * Enter a parse tree produced by {@link MicroParser#sentenceList}.
	 * @param ctx the parse tree
	 */
	void enterSentenceList(MicroParser.SentenceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#sentenceList}.
	 * @param ctx the parse tree
	 */
	void exitSentenceList(MicroParser.SentenceListContext ctx);
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
	 * Enter a parse tree produced by {@link MicroParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierList(MicroParser.IdentifierListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#identifierList}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierList(MicroParser.IdentifierListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MicroParser#expessionList}.
	 * @param ctx the parse tree
	 */
	void enterExpessionList(MicroParser.ExpessionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MicroParser#expessionList}.
	 * @param ctx the parse tree
	 */
	void exitExpessionList(MicroParser.ExpessionListContext ctx);
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