import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class Application {
    private Application() {}

    public static void main(String... args) throws IOException {
        check(args);

        String filePath = args[0];

        final String inputFile = (args.length > 0) ? filePath : null;

        final InputStream inputStream = (inputFile == null) ? System.in : new FileInputStream(inputFile);
        final ANTLRInputStream input = new ANTLRInputStream(inputStream);
        final MicroLexer lexer = new MicroLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final MicroParser parser = new MicroParser(tokens);
        MicroParser.ProgramContext program = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        MicroJavaListener listener = new MicroJavaListener(filePath);
        walker.walk(listener, program);
    }

    private static void check(String... args){
        if(args.length==0) {
            System.err.println(FILE_PATH_ERROR);
            System.exit(1);
        }

        if(args.length>1) {
            System.err.println(PARAM_NUMBER_ERROR);
            System.exit(7);
        }

        final String filePath = args[0];

        if(!filePath.endsWith(".m")) {
            System.err.println(FILE_NAME_ERROR);
            System.exit(22);
        }

    }

    private static final String FILE_PATH_ERROR = "File path is needed to proceed";
    private static final String PARAM_NUMBER_ERROR = "Wrong number of parameters";
    private static final String FILE_NAME_ERROR = "File name must ent with '.m'";
}
