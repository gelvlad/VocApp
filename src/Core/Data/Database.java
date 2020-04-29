package Core.Data;

import Core.Data.Access.CustomAccess;
import Core.Data.Access.CustomDefinitionAccess;
import Core.Data.Access.CustomWordAccess;
import Core.Data.Models.Definition;
import Core.Data.Models.Word;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Database {
    /************* Fields *************/
    private static String dbUrl;
    private static ConnectionSource connectionSource;
    private static CustomAccess<Definition,Long> definitionAccess;
    private static CustomAccess<Word,Long> wordAccess;
    /************* Getters *************/
    public String getUrl() {
        return dbUrl;
    }
    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }
    public static CustomAccess<Definition,Long> getDefinitionAccess() {
        return definitionAccess;
    }
    public static CustomAccess<Word,Long> getWordAccess() {
        return wordAccess;
    }
    /************* Logic *************/
    public static void init(String url) throws SQLException {
        dbUrl = url;
        connectionSource = new JdbcConnectionSource(url);
        definitionAccess=new CustomDefinitionAccess(connectionSource);
        wordAccess=new CustomWordAccess(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, Word.class);
        TableUtils.createTableIfNotExists(connectionSource, Definition.class);
    }
    public static void close() throws IOException {
        DaoManager.clearCache();
        connectionSource.close();
    }
    public static void clear() throws SQLException {
        TableUtils.clearTable(connectionSource, Word.class);
        TableUtils.clearTable(connectionSource, Definition.class);
    }
}
