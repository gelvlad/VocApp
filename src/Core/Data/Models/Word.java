package Core.Data.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;

@DatabaseTable
public class Word {
    @DatabaseField(generatedId = true)
    public long id;

    @DatabaseField
    public String word;
    @DatabaseField
    public int mark;
    @DatabaseField
    public int times_tested;
    @DatabaseField
    public int times_succeeded;

    @DatabaseField
    private long date_added;

    public Word() {
        date_added = LocalDate.now().toEpochDay();
    }
}
