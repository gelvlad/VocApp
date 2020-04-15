package Core;
import GUI.*;
import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        smallScreen();
        //fullHD();
        //quadHD();
        //ultraHD();
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
