package Core.Data.Models;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;

@DatabaseTable
public class Word {
    /************* Fields *************/
    @DatabaseField(generatedId = true)
    private long id;
    @DatabaseField
    private String word;
    @DatabaseField
    private int mark;
    @DatabaseField
    private int times_tested;
    @DatabaseField
    private int times_succeeded;
    @DatabaseField
    private boolean ignored;
    @DatabaseField
    private long date_added;
    /************* Constructors *************/
    public Word() {
        this("", 0, 0, 0);
    }

    //for testing purposes
    public Word(String word, int mark) {
        this(word, mark, 0, 0);
    }

    public Word(String word,int mark,int times_tested, int times_succeeded){
        this.word=word;
        this.mark=mark;
        this.times_succeeded=times_succeeded;
        this.times_tested=times_tested;
        ignored=false;
        date_added = LocalDate.now().toEpochDay();
    }
    /************* Getters *************/
    public long getId() {
        return id;
    }
    public int getMark() {
        return mark;
    }
    public String getWord() {
        return word;
    }
    public int getTimes_succeeded() {
        return times_succeeded;
    }
    public int getTimes_tested() {
        return times_tested;
    }
    public boolean isIgnored() {
        return ignored;
    }
    public long getDate_added() {
        return date_added;
    }
    /************* Setters *************/
    public void setId(long id) {
        this.id = id;
    }
    public void setWord(String word) {
        this.word = word;
    }
    public void setMark(int mark) {
        this.mark = mark;
    }
    public void setTimes_tested(int times_tested) {
        this.times_tested = times_tested;
    }
    public void setTimes_succeeded(int times_succeeded) {
        this.times_succeeded = times_succeeded;
    }
    public void setIgnored(boolean ignored) {
        this.ignored = ignored;
    }
}
