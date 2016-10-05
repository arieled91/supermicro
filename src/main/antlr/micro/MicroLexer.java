package micro;// Generated from Micro.g4 by ANTLR 4.5.3
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MicroLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5.3", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Letter=1, Digit=2, Constant=3, Identifier=4, AddOp=5, SubOp=6, Operator=7, 
		Comma=8, RightParen=9, LeftParen=10, Assign=11, Semicolon=12, Begin=13, 
		End=14, Read=15, Write=16, Ignore=17;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Letter", "Digit", "Constant", "Identifier", "AddOp", "SubOp", "Operator", 
		"Comma", "RightParen", "LeftParen", "Assign", "Semicolon", "Begin", "End", 
		"Read", "Write", "Ignore"
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


	public MicroLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Micro.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\23f\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\3\3\3\3\3\4\6\4,\n\4\r\4\16\4-\3\5\6\5\61\n\5\r\5\16\5\62"+
		"\3\5\7\5\66\n\5\f\5\16\59\13\5\3\6\3\6\3\7\3\7\3\b\3\b\5\bA\n\b\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\2\2\23\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23"+
		"\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23\3\2\3\5\2\13\f\17\17\"\""+
		"i\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\3%\3\2\2\2\5(\3\2\2\2\7+\3\2\2\2\t\60\3\2\2\2\13:\3\2\2\2\r<\3\2"+
		"\2\2\17@\3\2\2\2\21B\3\2\2\2\23D\3\2\2\2\25F\3\2\2\2\27H\3\2\2\2\31K\3"+
		"\2\2\2\33M\3\2\2\2\35S\3\2\2\2\37W\3\2\2\2!\\\3\2\2\2#b\3\2\2\2%&\4c|"+
		"\2&\'\4C\\\2\'\4\3\2\2\2()\4\62;\2)\6\3\2\2\2*,\5\5\3\2+*\3\2\2\2,-\3"+
		"\2\2\2-+\3\2\2\2-.\3\2\2\2.\b\3\2\2\2/\61\5\3\2\2\60/\3\2\2\2\61\62\3"+
		"\2\2\2\62\60\3\2\2\2\62\63\3\2\2\2\63\67\3\2\2\2\64\66\5\5\3\2\65\64\3"+
		"\2\2\2\669\3\2\2\2\67\65\3\2\2\2\678\3\2\2\28\n\3\2\2\29\67\3\2\2\2:;"+
		"\7-\2\2;\f\3\2\2\2<=\7/\2\2=\16\3\2\2\2>A\5\13\6\2?A\5\r\7\2@>\3\2\2\2"+
		"@?\3\2\2\2A\20\3\2\2\2BC\7.\2\2C\22\3\2\2\2DE\7*\2\2E\24\3\2\2\2FG\7+"+
		"\2\2G\26\3\2\2\2HI\7<\2\2IJ\7?\2\2J\30\3\2\2\2KL\7=\2\2L\32\3\2\2\2MN"+
		"\7d\2\2NO\7g\2\2OP\7i\2\2PQ\7k\2\2QR\7p\2\2R\34\3\2\2\2ST\7g\2\2TU\7p"+
		"\2\2UV\7f\2\2V\36\3\2\2\2WX\7t\2\2XY\7g\2\2YZ\7c\2\2Z[\7f\2\2[ \3\2\2"+
		"\2\\]\7y\2\2]^\7t\2\2^_\7k\2\2_`\7v\2\2`a\7g\2\2a\"\3\2\2\2bc\t\2\2\2"+
		"cd\3\2\2\2de\b\22\2\2e$\3\2\2\2\7\2-\62\67@\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}