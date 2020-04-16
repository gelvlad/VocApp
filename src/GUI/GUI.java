package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI extends JFrame{
    private JFrame frame = new JFrame("Frame");
    private JPanel menuPanel = new JPanel();
    private JPanel mainpanel = new JPanel();
    private JPanel eastPanel = new JPanel();
    private JPanel eastPanelnorth = new JPanel();
    private JPanel eastPanelsouth = new JPanel();
    private JPanel westPanel = new JPanel();
    private JPanel westPanelnorth = new JPanel();
    private JPanel westPanelsouth = new JPanel();
    private JPanel wordPanel = new JPanel();
    private JPanel definitonPanel = new JPanel();
    private JPanel contextPanel = new JPanel();
    private JPanel textareaPanel = new JPanel();
    private JPanel wordInfoPanel = new JPanel();
    private JPanel dictionaryPanel = new JPanel();
    private JPanel menu1Panel = new JPanel();
    private JPanel menu2Panel = new JPanel();
    private JPanel menu3Panel = new JPanel();
    private JPanel menu4Panel = new JPanel();
    private JPanel menu5Panel = new JPanel();

    private JLabel word = new JLabel("Word");
    private JLabel definiton = new JLabel("Definition");
    private JLabel context = new JLabel("Context");
    private JLabel textarea = new JLabel("Text area");
    private JLabel wordInfo = new JLabel("Word Info");
    private JLabel dictionary = new JLabel("Dictionary");
    private JLabel menu1 = new JLabel("Here");
    private JLabel menu2 = new JLabel("will");
    private JLabel menu3 = new JLabel("be");
    private JLabel menu4 = new JLabel("the");
    private JLabel menu5 = new JLabel("menu");


    public GUI(int x, int y, int width, int height) {
        super("VocApp");
        //int x = 380;
        //int y = 180;
        //int width = 1240;
        //int height = 720;

        //int x = 0;
        //int y = 0;
        //int width = 1920;
        //int height = 1080;

        this.setBounds(x, y, width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(menuPanel, BorderLayout.NORTH);
        container.add(mainpanel, BorderLayout.CENTER);

        mainpanel.setLayout(new BorderLayout());
        mainpanel.add(westPanel, BorderLayout.CENTER);
        mainpanel.add(eastPanel, BorderLayout.EAST);


        // Menu
        menuPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuPanel.setBackground(Color.darkGray);
        menuPanel.setPreferredSize(new Dimension(Integer.MAX_VALUE, 40));

        menuPanel.add(menu1Panel);
        menu1Panel.setBackground(Color.lightGray);
        menu1Panel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        menu1Panel.add(menu1);

        menuPanel.add(menu2Panel);
        menu2Panel.setBackground(Color.lightGray);
        menu2Panel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        menu2Panel.add(menu2);

        menuPanel.add(menu3Panel);
        menu3Panel.setBackground(Color.lightGray);
        menu3Panel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        menu3Panel.add(menu3);

        menuPanel.add(menu4Panel);
        menu4Panel.setBackground(Color.lightGray);
        menu4Panel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        menu4Panel.add(menu4);

        menuPanel.add(menu5Panel);
        menu5Panel.setBackground(Color.lightGray);
        menu5Panel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        menu5Panel.add(menu5);


        // Word info and dictionary
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        eastPanel.setBackground(Color.gray);
        eastPanel.setPreferredSize(new Dimension(width/4, Integer.MAX_VALUE));
        eastPanel.setBorder(new EmptyBorder(height/72, 0, height/72, width/128));
        eastPanel.add(eastPanelnorth);

        eastPanelnorth.setLayout(new BoxLayout(eastPanelnorth, BoxLayout.Y_AXIS));
        eastPanelnorth.setBackground(Color.lightGray);
        eastPanelnorth.setPreferredSize(new Dimension(Integer.MAX_VALUE, height/4));
        eastPanelnorth.setMaximumSize(new Dimension(Integer.MAX_VALUE, height/4));
        eastPanelnorth.setBorder(new EmptyBorder(height/72, width/128, height/72, width/128));
        eastPanelnorth.add(wordInfoPanel);

        wordInfoPanel.setLayout(new BorderLayout());
        wordInfoPanel.setBackground(Color.lightGray);
        wordInfoPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        wordInfoPanel.add(wordInfo, BorderLayout.WEST);

        wordInfo.setBorder(new EmptyBorder(height/144, width/192, height/144, width/192));
        wordInfo.setVerticalAlignment(SwingConstants.TOP);

        eastPanel.add(Box.createVerticalStrut(height/72));

        eastPanel.add(eastPanelsouth);

        eastPanelsouth.setLayout(new BoxLayout(eastPanelsouth, BoxLayout.Y_AXIS));
        eastPanelsouth.setBackground(Color.lightGray);
        //eastPanelsouth.setPreferredSize(new Dimension(Integer.MAX_VALUE, height/2 - 30));
        eastPanelsouth.setBorder(new EmptyBorder(height/72, width/128, height/72, width/128));
        eastPanelsouth.add(dictionaryPanel);

        dictionaryPanel.setLayout(new BorderLayout());
        dictionaryPanel.setBackground(Color.lightGray);
        dictionaryPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        dictionaryPanel.add(dictionary, BorderLayout.WEST);

        dictionary.setBorder(new EmptyBorder(height/144, width/192, height/144, width/192));
        dictionary.setVerticalAlignment(SwingConstants.TOP);


        // Word, defenition, context and text area
        westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
        westPanel.setBorder(new EmptyBorder(height/72, width/128, height/72, width/128));
        westPanel.setBackground(Color.gray);

        // Word, defenition and context
        westPanel.add(westPanelnorth);
        westPanelnorth.setLayout(new BoxLayout(westPanelnorth, BoxLayout.Y_AXIS));
        westPanelnorth.setBackground(Color.lightGray);
        westPanelnorth.setMaximumSize(new Dimension(Integer.MAX_VALUE, height/2));
        westPanelnorth.setPreferredSize(new Dimension(Integer.MAX_VALUE, 220));
        westPanelnorth.setBorder(new EmptyBorder(height/72, width/128, height/72, width/128));
        westPanelnorth.add(wordPanel);
        westPanelnorth.add(Box.createVerticalStrut(height/72));
        westPanelnorth.add(definitonPanel);
        westPanelnorth.add(Box.createVerticalStrut(height/72));
        westPanelnorth.add(contextPanel);

        wordPanel.setLayout(new BorderLayout());
        wordPanel.setBackground(Color.lightGray);
        wordPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        wordPanel.setPreferredSize(new Dimension(200, 30));
        wordPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        wordPanel.add(word, BorderLayout.WEST);

        word.setBorder(new EmptyBorder(0, width/192, 0, width/192));

        definitonPanel.setLayout(new BorderLayout());
        definitonPanel.setBackground(Color.lightGray);
        definitonPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        definitonPanel.setPreferredSize(new Dimension(200, 60));
        definitonPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 60));
        definitonPanel.add(definiton, BorderLayout.WEST);

        definiton.setBorder(new EmptyBorder(height/144, width/192, height/144, width/192));
        definiton.setVerticalAlignment(SwingConstants.TOP);

        contextPanel.setLayout(new BorderLayout());
        contextPanel.setBackground(Color.lightGray);
        contextPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        contextPanel.setPreferredSize(new Dimension(200, 110));
        contextPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 110));
        contextPanel.add(context, BorderLayout.WEST);

        context.setBorder(new EmptyBorder(height/144, width/192, height/144, width/192));
        context.setVerticalAlignment(SwingConstants.TOP);

        westPanel.add(Box.createVerticalStrut(height/72));


        // Text area
        westPanel.add(westPanelsouth);
        westPanelsouth.setLayout(new BoxLayout(westPanelsouth, BoxLayout.Y_AXIS));
        westPanelsouth.setBackground(Color.lightGray);
        //westPanelsouth.setPreferredSize(new Dimension(Integer.MAX_VALUE, height/2 - 30));
        westPanelsouth.setBorder(new EmptyBorder(height/72, width/128, height/72, width/128));
        westPanelsouth.add(textareaPanel);

        textareaPanel.setLayout(new BorderLayout());
        textareaPanel.setBackground(Color.lightGray);
        textareaPanel.setBorder(BorderFactory.createLineBorder(Color.darkGray));
        textareaPanel.add(textarea, BorderLayout.WEST);

        textarea.setBorder(new EmptyBorder(height/144, width/192, height/144, width/192));
        textarea.setVerticalAlignment(SwingConstants.TOP);

    }

    /*
    class ButtonEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            String message = "Button was pressed\n" +
                    "Text is " + input.getText() + "\n";
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
    */

}