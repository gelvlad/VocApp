package Core.Data.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable
public class Definition {
    /************* Fields *************/
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String text;
    @DatabaseField
    private String context;
    @DatabaseField(canBeNull = false, foreign = true)
    private Word word;
    /************* Constructors *************/
    public Definition() {}
    public Definition(String text,String context,Word word){
        this.text=text;
        this.context=context;
        this.word=word;
    }
    public Definition(String text,Word word){
        this.text=text;
        this.word=word;
    }
    /************* Getters *************/
    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getContext() {
        return context;
    }

    public Word getWord() {
        return word;
    }
    /************* Setters *************/
    public void setWord(Word word) {
        this.word = word;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
