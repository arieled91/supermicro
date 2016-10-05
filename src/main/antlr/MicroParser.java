// Generated from Micro.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Letter=1, Digit=2, Constant=3, Identifier=4, AddOp=5, SubOp=6, Operator=7, 
		Comma=8, RightParen=9, LeftParen=10, Assign=11, Semicolon=12, Begin=13, 
		End=14, Read=15, Write=16, Ignore=17;
	public static final int
		RULE_program = 0, RULE_sentenceList = 1, RULE_sentence = 2, RULE_identifierList = 3, 
		RULE_expessionList = 4, RULE_expression = 5, RULE_primary = 6;
	public static final String[] ruleNames = {
		"program", "sentenceList", "sentence", "identifierList", "expessionList", 
		"expression", "primary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, null, null, null, "'+'", "'-'", null, "','", "'('", "')'", 
		"':='", "';'", "'begin'", "'end'", "'read'", "'write'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Letter", "Digit", "Constant", "Identifier", "AddOp", "SubOp", "Operator", 
		"Comma", "RightParen", "LeftParen", "Assign", "Semicolon", "Begin", "End", 
		"Read", "Write", "Ignore"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MicroParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode Begin() { return getToken(MicroParser.Begin, 0); }
		public SentenceListContext sentenceList() {
			return getRuleContext(SentenceListContext.class,0);
		}
		public TerminalNode End() { return getToken(MicroParser.End, 0); }
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitProgram(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			match(Begin);
			setState(15);
			sentenceList();
			setState(16);
			match(End);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceListContext extends ParserRuleContext {
		public SentenceContext sentence() {
			return getRuleContext(SentenceContext.class,0);
		}
		public SentenceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentenceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterSentenceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitSentenceList(this);
		}
	}

	public final SentenceListContext sentenceList() throws RecognitionException {
		SentenceListContext _localctx = new SentenceListContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sentenceList);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(18);
			sentence();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class SentenceContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MicroParser.Identifier, 0); }
		public TerminalNode Assign() { return getToken(MicroParser.Assign, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Semicolon() { return getToken(MicroParser.Semicolon, 0); }
		public TerminalNode Read() { return getToken(MicroParser.Read, 0); }
		public TerminalNode RightParen() { return getToken(MicroParser.RightParen, 0); }
		public IdentifierListContext identifierList() {
			return getRuleContext(IdentifierListContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MicroParser.LeftParen, 0); }
		public TerminalNode Write() { return getToken(MicroParser.Write, 0); }
		public ExpessionListContext expessionList() {
			return getRuleContext(ExpessionListContext.class,0);
		}
		public SentenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterSentence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitSentence(this);
		}
	}

	public final SentenceContext sentence() throws RecognitionException {
		SentenceContext _localctx = new SentenceContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sentence);
		try {
			setState(35);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(20);
				match(Identifier);
				setState(21);
				match(Assign);
				setState(22);
				expression();
				setState(23);
				match(Semicolon);
				}
				break;
			case Read:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				match(Read);
				setState(26);
				match(RightParen);
				setState(27);
				identifierList();
				setState(28);
				match(LeftParen);
				}
				break;
			case Write:
				enterOuterAlt(_localctx, 3);
				{
				setState(30);
				match(Write);
				setState(31);
				match(RightParen);
				setState(32);
				expessionList();
				setState(33);
				match(LeftParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierListContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(MicroParser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(MicroParser.Identifier, i);
		}
		public List<TerminalNode> Comma() { return getTokens(MicroParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MicroParser.Comma, i);
		}
		public IdentifierListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterIdentifierList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitIdentifierList(this);
		}
	}

	public final IdentifierListContext identifierList() throws RecognitionException {
		IdentifierListContext _localctx = new IdentifierListContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_identifierList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37);
			match(Identifier);
			setState(42);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(38);
				match(Comma);
				setState(39);
				match(Identifier);
				}
				}
				setState(44);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpessionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(MicroParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(MicroParser.Comma, i);
		}
		public ExpessionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expessionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpessionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpessionList(this);
		}
	}

	public final ExpessionListContext expessionList() throws RecognitionException {
		ExpessionListContext _localctx = new ExpessionListContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expessionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			expression();
			setState(50);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(46);
				match(Comma);
				setState(47);
				expression();
				}
				}
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public List<PrimaryContext> primary() {
			return getRuleContexts(PrimaryContext.class);
		}
		public PrimaryContext primary(int i) {
			return getRuleContext(PrimaryContext.class,i);
		}
		public List<TerminalNode> Operator() { return getTokens(MicroParser.Operator); }
		public TerminalNode Operator(int i) {
			return getToken(MicroParser.Operator, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			primary();
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Operator) {
				{
				{
				setState(54);
				match(Operator);
				setState(55);
				primary();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(MicroParser.Identifier, 0); }
		public TerminalNode Constant() { return getToken(MicroParser.Constant, 0); }
		public TerminalNode RightParen() { return getToken(MicroParser.RightParen, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode LeftParen() { return getToken(MicroParser.LeftParen, 0); }
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MicroListener ) ((MicroListener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_primary);
		try {
			setState(67);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				match(Identifier);
				}
				break;
			case Constant:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				match(Constant);
				}
				break;
			case RightParen:
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				match(RightParen);
				setState(64);
				expression();
				setState(65);
				match(LeftParen);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\23H\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3\2\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4&\n\4\3\5"+
		"\3\5\3\5\7\5+\n\5\f\5\16\5.\13\5\3\6\3\6\3\6\7\6\63\n\6\f\6\16\6\66\13"+
		"\6\3\7\3\7\3\7\7\7;\n\7\f\7\16\7>\13\7\3\b\3\b\3\b\3\b\3\b\3\b\5\bF\n"+
		"\b\3\b\2\2\t\2\4\6\b\n\f\16\2\2G\2\20\3\2\2\2\4\24\3\2\2\2\6%\3\2\2\2"+
		"\b\'\3\2\2\2\n/\3\2\2\2\f\67\3\2\2\2\16E\3\2\2\2\20\21\7\17\2\2\21\22"+
		"\5\4\3\2\22\23\7\20\2\2\23\3\3\2\2\2\24\25\5\6\4\2\25\5\3\2\2\2\26\27"+
		"\7\6\2\2\27\30\7\r\2\2\30\31\5\f\7\2\31\32\7\16\2\2\32&\3\2\2\2\33\34"+
		"\7\21\2\2\34\35\7\13\2\2\35\36\5\b\5\2\36\37\7\f\2\2\37&\3\2\2\2 !\7\22"+
		"\2\2!\"\7\13\2\2\"#\5\n\6\2#$\7\f\2\2$&\3\2\2\2%\26\3\2\2\2%\33\3\2\2"+
		"\2% \3\2\2\2&\7\3\2\2\2\',\7\6\2\2()\7\n\2\2)+\7\6\2\2*(\3\2\2\2+.\3\2"+
		"\2\2,*\3\2\2\2,-\3\2\2\2-\t\3\2\2\2.,\3\2\2\2/\64\5\f\7\2\60\61\7\n\2"+
		"\2\61\63\5\f\7\2\62\60\3\2\2\2\63\66\3\2\2\2\64\62\3\2\2\2\64\65\3\2\2"+
		"\2\65\13\3\2\2\2\66\64\3\2\2\2\67<\5\16\b\289\7\t\2\29;\5\16\b\2:8\3\2"+
		"\2\2;>\3\2\2\2<:\3\2\2\2<=\3\2\2\2=\r\3\2\2\2><\3\2\2\2?F\7\6\2\2@F\7"+
		"\5\2\2AB\7\13\2\2BC\5\f\7\2CD\7\f\2\2DF\3\2\2\2E?\3\2\2\2E@\3\2\2\2EA"+
		"\3\2\2\2F\17\3\2\2\2\7%,\64<E";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}