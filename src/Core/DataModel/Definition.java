package Core.DataModel;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Definition {
    @DatabaseField(generatedId = true)
    public long id;

    @DatabaseField
    public String text;
    @DatabaseField
    public String context;

    @DatabaseField(canBeNull = false, foreign = true)
    public Word word;

    public Definition() {}
}
