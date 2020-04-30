package Core;
import Core.Data.Access.CustomAccess;
import Core.Data.Models.Definition;
import Core.Data.Models.Word;
import GUI.*;

import java.io.IOException;
import Core.Data.Database;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    private final static String DB_URL="jdbc:sqlite:vocappulary.db";
    public static void main(String[] args) throws SQLException, IOException {
        Database.init(DB_URL);
        CustomAccess<Word, Long> wordDao = Database.getWordAccess();
//        wordDao.save(new Word("a", 0));
//        wordDao.save(new Word("d", 6));
//        wordDao.save(new Word("c", 10));
//        wordDao.save(new Word("b", 1));
//        Word word = new Word();
//        word.setId(1);
//        Database.getDefinitionAccess().save(new Definition("a word that is \"ab\"", "ab abab AB", word));
        initInterface();
    }
    public static void initInterface(){
        final JFrame MainWindow=new MainWindow();
    }
}
