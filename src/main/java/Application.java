import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class Application {
    private Application() {}

    public static void main(String[] args) throws IOException {
        final String inputFile = (args.length > 0) ? args[0] : null;

        final InputStream inputStream = (inputFile == null) ? System.in : new FileInputStream(inputFile);
        final ANTLRInputStream input = new ANTLRInputStream(inputStream);
        final MicroLexer lexer = new MicroLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final MicroParser parser = new MicroParser(tokens);
        parser.program();
    }
}
