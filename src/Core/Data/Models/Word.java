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
    private long date_added;
    /************* Constructors *************/
    public Word() {
        date_added = LocalDate.now().toEpochDay();
    }
    public Word(String word,int mark,int times_tested, int times_succeeded){
        this.word=word;
        this.mark=mark;
        this.times_succeeded=times_succeeded;
        this.times_tested=times_tested;
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
    public long getDate_added() {
        return date_added;
    }
    /************* Setters *************/
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

}
