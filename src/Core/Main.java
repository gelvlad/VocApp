package Core;
import GUI.*;
import javax.swing.*;
import java.io.IOException;
import Core.Data.Database;
import Core.Data.Models.Definition;
import Core.Data.Models.Word;
import com.j256.ormlite.stmt.DeleteBuilder;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    private final static String DB_URL="jdbc:sqlite:vocappulary.db";
    public static void main(String[] args) throws SQLException, IOException {
        Database.init(DB_URL);
        Database.clear();
        Word word = new Word("light",5,1,0);
        Definition definition1 = new Definition("свет",word);
        Definition definition2 = new Definition("легкий",word);
        // Create
        Database.getWordAccess().save(word);
        Database.getDefinitionAccess().save(definition1);
        Database.getDefinitionAccess().save(definition2);
        System.out.println(Database.getDefinitionAccess().count());
        System.out.println(Database.getWordAccess().count());
        // Read
        Definition readDefinition = Database.getDefinitionAccess().getById(1L);
        // Update
        definition1.setText("shine");
        Database.getDefinitionAccess().update(definition1);
        // Delete
        Database.getWordAccess().delete(word);
        System.out.println(Database.getDefinitionAccess().count());
        System.out.println(Database.getWordAccess().count());
        Database.close();
    }

    public static void smallScreen() {
        GUI app = new GUI(320, 180, 1280, 720);
        app.setVisible(true);
    }

    public static void fullHD() {
        GUI app = new GUI(0, 0, 1920, 1080);
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setVisible(true);
    }

    public static void quadHD() {
        GUI app = new GUI(0, 0, 2560, 1440);
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setVisible(true);
    }

    public static void ultraHD() {
        GUI app = new GUI(0, 0, 3840, 2160);
        app.setExtendedState(JFrame.MAXIMIZED_BOTH);
        app.setVisible(true);
    }

}
