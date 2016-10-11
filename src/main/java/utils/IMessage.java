package utils;

public interface IMessage {
    String FILE_PATH_ERROR = "File path is needed to proceed";
    String PARAM_NUMBER_ERROR = "Wrong number of parameters";
    String FILE_NAME_ERROR = "File name must ent with '.m'";
    String ID_NOT_DECLARED_ERROR = "Line %s:%s - Identifier \"%s\" is not declared\n";
    String IO_ERROR = "I/O Error or file not found: \"%s\"";

    int INVALID_ARGUMENT = 22;
    int ARG_LIST_TOO_LONG = 7;
    int NOT_PERMITTED = 7;
}
