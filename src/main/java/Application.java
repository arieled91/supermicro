import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import utils.FileUtil;
import utils.IMessage;

import java.io.IOException;
import java.io.InputStream;

public final class Application implements IMessage {

    private Application() {}

    public static void main(String... args) throws IOException {
        check(args);

        final String filePath = args[0];

        final InputStream inputStream = FileUtil.read(filePath);
        final ANTLRInputStream input = new ANTLRInputStream(inputStream);

        final MicroLexer lexer = new MicroLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final MicroParser parser = new MicroParser(tokens);

        final MicroParser.ProgramContext program = parser.program();
        final ParseTreeWalker walker = new ParseTreeWalker();
        final MicroJavaListener listener = new MicroJavaListener(filePath);
        walker.walk(listener, program);
    }

    private static void check(String... args){
        if(args.length==0) {
            System.err.println(FILE_PATH_ERROR);
            System.exit(NOT_PERMITTED);
        }

        if(args.length>1) {
            System.err.println(PARAM_NUMBER_ERROR);
            System.exit(ARG_LIST_TOO_LONG);
        }

        final String filePath = args[0];

        if(!filePath.endsWith(".m")) {
            System.err.println(FILE_NAME_ERROR);
            System.exit(INVALID_ARGUMENT);
        }

    }


}
