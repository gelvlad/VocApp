package Core;
import GUI.*;

import java.io.IOException;
import Core.Data.Database;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    private final static String DB_URL="jdbc:sqlite:vocappulary.db";
    public static void main(String[] args) throws SQLException, IOException {
        //Database.init(DB_URL);
        initInterface();
    }
    public static void initInterface(){
        final JFrame MainWindow=new MainWindow();
    }
}
