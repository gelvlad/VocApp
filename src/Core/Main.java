package Core;
import Core.Data.Database;
import Core.Data.Models.Definition;
import Core.Data.Models.Word;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        // Creates and maintains a JDBC connection to a database, which in case of SQLite is basically an opened file
        //
        // Throws SQLException or IOException
        // both exceptions come from SQL, but ormlite's ConnectionSource implements older java.io.Closeable
        // which only allows it to throw IOException
        Database database = new Database("jdbc:sqlite:vocappulary.db");
        database.createTables();

        // Create
        Word word = new Word();
        word.word = "Thing";
        word.mark = 5;
        word.times_tested = 1;
        word.times_succeeded = 0;
        database.getWordDao().create(word);

        Definition definition = new Definition();
        definition.text = "afd` a'f\"af";
        definition.context = "ksjnsdkfn asdasd";
        definition.word = word;
        database.getDefinitionDao().create(definition);

        // Read
        Definition readDefinition = database.getDefinitionDao().queryForId(1L);
        // doesn't query foreign tables, so readDefinition.word only has id value set

        // query by id into existing object:
        database.getWordDao().refresh(readDefinition.word);
        Word readWord = readDefinition.word;

        // Update
        definition.text = "asdasdasd";
        database.getDefinitionDao().update(definition);
        // or this:
        database.getWordDao().createOrUpdate(word);

        // Delete
        database.getWordDao().delete(word);
        // this orm is idiotic and I don't want to do anything about it:
        DeleteBuilder<Definition, Long> delet = database.getDefinitionDao().deleteBuilder();
        delet.where().eq("word_id", word.id);
        delet.delete();

        // Release Connection, clear DAOs
        database.close();
    }
}
