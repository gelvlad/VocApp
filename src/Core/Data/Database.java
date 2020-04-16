package Core.Data;

import Core.Data.Models.Definition;
import Core.Data.Models.Word;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Database implements AutoCloseable {
    // cause why not
    private String url;

    public String getUrl() {
        return url;
    }


    private ConnectionSource connectionSource;

    public ConnectionSource getConnectionSource() {
        return connectionSource;
    }

    public void createConnectionSource(String url) throws SQLException, IOException {
        // connection source uses external resources, so we need to properly close it first
        if (connectionSource != null)
            connectionSource.close();
        connectionSource = new JdbcConnectionSource(url);
        this.url = url;
    }


    public Database(String url) throws SQLException {
        this.connectionSource = new JdbcConnectionSource(url);
        this.url = url;
    }

    public void createTables() throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, Word.class);
        TableUtils.createTableIfNotExists(connectionSource, Definition.class);
    }

    public Dao<Definition, Long> getDefinitionDao() throws SQLException {
        // DaoManager will check if such DAO already exists and will not create a duplicate
        return DaoManager.createDao(connectionSource, Definition.class);
    }

    public Dao<Word, Long> getWordDao() throws SQLException {
        return DaoManager.createDao(connectionSource, Word.class);
    }

    @Override
    public void close() throws IOException {
        DaoManager.clearCache();
        connectionSource.close();
    }
}
