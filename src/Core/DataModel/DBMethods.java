package Core.DataModel;

public class DBMethods {
    public static String escapeString(String value) {
        return String.format("'%s'", value.replaceAll("'", "''"));
    }
}
