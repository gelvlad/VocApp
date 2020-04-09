package Core;
import Core.DataModel.DBMethods;
import Core.DataModel.Definition;
import Core.DataModel.Word;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        String databaseUrl = "jdbc:sqlite:vocappulary.db";

        String a = " `\\sasf\"fsf 'f' ";
        String b = DBMethods.escapeString(a);
        // basically opens a file, throws both SQL and IO exceptions
        ConnectionSource connectionSource = new JdbcConnectionSource(databaseUrl);

        TableUtils.createTableIfNotExists(connectionSource, Word.class);
        TableUtils.createTableIfNotExists(connectionSource, Definition.class);

        // DAO = Data Access Object, gives methods to create/read/update/delete rows
        // these can throw SQLException from their methods
        Dao<Word, Long> wordDao = DaoManager.createDao(connectionSource, Word.class);
        Dao<Definition, Long> definitionDao = DaoManager.createDao(connectionSource, Definition.class);

        // Create
        Word word = new Word();
        word.word = "Thing";
        word.mark = 5;
        word.times_tested = 1;
        word.times_succeeded = 0;
        wordDao.create(word);

        Definition definition = new Definition();
        definition.text = DBMethods.escapeString("asda\\`\"s'''''f");
        definition.context = "ksjnsdkfn asdasd";
        definition.word = word;
        definitionDao.create(definition);

        // Read
        Definition readDefinition = definitionDao.queryForId(1L);
        // doesn't query foreign tables, so readDefinition.word only has id value set

        // query by id into existing object:
        wordDao.refresh(readDefinition.word);
        Word readWord = readDefinition.word;

        // Update
        definition.text = "asdasdasd";
        definitionDao.update(definition);
        // or this:
        wordDao.createOrUpdate(word);

        // Delete
        wordDao.delete(word);
        // this orm is idiotic and I don't want to do anything about it:
        DeleteBuilder<Definition, Long> delet = definitionDao.deleteBuilder();
        delet.where().eq("word_id", word.id);
        delet.delete();

        connectionSource.close();
    }
}
