package HW4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chat extends JFrame {
    JPanel panel = new JPanel(new GridLayout());
    JPanel panelS = new JPanel(new GridLayout());

    JButton button = new JButton("Send");
    JTextArea ta = new JTextArea();
    JScrollPane scroll = new JScrollPane(ta);
    JTextField tf = new JTextField();

    JMenuBar mainMenu = new JMenuBar();
    JMenu menuFile = new JMenu("File");
    JMenu menuHelp = new JMenu("Help");
    JMenuItem exit = new JMenuItem("Exit");
    JMenuItem about = new JMenuItem("About");

    PrintWriter pw = new PrintWriter(new FileWriter("1.txt"));

    Chat() throws IOException {
        super("HW chat");
        setSize(400, 500);
        setMaximumSize(new Dimension(400, 500));

        ta.setLineWrap(true);
        ta.setEditable(false);

        //действие
        button.addActionListener(e -> {
            sendMassage();
        });
        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMassage();
            }
        });

        panel.add(scroll);
        panelS.add(tf);
        panelS.add(button);

        add(panel);
        add("South", panelS);

        //меню
        setJMenuBar(mainMenu);
        mainMenu.add(menuFile);
        mainMenu.add(menuHelp);
        menuFile.add(exit);
        menuHelp.add(about);
        exit.addActionListener(e -> System.exit(0));
        about.addActionListener(e -> JOptionPane.showMessageDialog(null, "Chat version 1.0",
                "About", JOptionPane.INFORMATION_MESSAGE));

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //отправить сообщение и написать
    void sendMassage() {
        String out = tf.getText();
        ta.append(getTime() + ": " + out + "\n");
        pw.append(getTime() + ": " + out + "\n");
        pw.flush();
        tf.setText("");
        tf.grabFocus();
    }

    public String getTime() {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }
}
