import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import utils.ClassBuilder;
import utils.FileUtil;
import utils.IMessage;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Application implements IMessage {

    private Application() {}

    public static void main(String... args) throws IOException {
        check(args);

        final String filePath;
        Set<String> compilerArgs = new HashSet<>();

        if(args.length==1)
            filePath = args[0];
        else{
            compilerArgs =  buildArgSet(args);
            filePath = args[args.length-1];
        }

        final InputStream inputStream = FileUtil.read(filePath);
        final ANTLRInputStream input = new ANTLRInputStream(inputStream);

        final MicroLexer lexer = new MicroLexer(input);
        final CommonTokenStream tokens = new CommonTokenStream(lexer);
        final MicroParser parser = new MicroParser(tokens);

        final MicroParser.ProgramContext program = parser.program();
        final ParseTreeWalker walker = new ParseTreeWalker();

        final String className = buildClassName(filePath);
        final MicroJavaListener listener = new MicroJavaListener(className);
        walker.walk(listener, program);

        final ClassBuilder microClass = new ClassBuilder(className, buildFilePath(filePath), listener.getCode());

        if(compilerArgs.contains("jar"))
            microClass.compileJar();

        if (compilerArgs.contains("run"))
            microClass.run();

    }

    private static void check(String... args){
        if(args.length==0) {
            System.err.println(FILE_PATH_ERROR);
            System.exit(NOT_PERMITTED);
        }

        if(args.length>2) {
            System.err.println(PARAM_NUMBER_ERROR);
            System.exit(ARG_LIST_TOO_LONG);
        }

        final String filePath;
        if(args.length==1)
            filePath = args[0];
        else
            filePath = args[1];

        if(!filePath.endsWith(".m")) {
            System.err.println(FILE_NAME_ERROR);
            System.exit(INVALID_ARGUMENT);
        }

    }

    public static String buildClassName(String originPath){
        final String[] pathSplit = originPath.split(File.separator);
        final String fileName = pathSplit[pathSplit.length - 1];
        final String name = fileName.replace(".m","");
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public static String buildFilePath(String originPath){
        final int length = (buildClassName(originPath) + ".m").length();
        final String path = originPath.substring(0, originPath.length() - length);
        return path.isEmpty() ? "" : path+"/";
    }

    public static Set<String> buildArgSet(String... args){
//        final Set<String> set = Arrays.stream(args).collect(Collectors.toSet());
        final List<String> list = Arrays.asList(args).subList(0, args.length-1);
        return new HashSet<>(list);
    }

}
