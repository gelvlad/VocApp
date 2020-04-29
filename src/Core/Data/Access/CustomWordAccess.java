package Core.Data.Access;

import Core.Data.Database;
import Core.Data.Models.Definition;
import Core.Data.Models.Word;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.support.ConnectionSource;

import java.sql.SQLException;

public class CustomWordAccess extends CustomAccess<Word,Long> {

    public CustomWordAccess(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Word.class);
    }

    @Override
    public void delete(Word query) throws SQLException{
        DeleteBuilder<Definition, Long> delet = Database.getDefinitionAccess().getDao().deleteBuilder();
        delet.where().eq("word_id", query.getId());
        delet.delete();
        super.getDao().delete(query);
    }
}
