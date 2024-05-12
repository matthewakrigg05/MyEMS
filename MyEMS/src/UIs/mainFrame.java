package UIs;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import DB_Init.User;

public abstract class mainFrame extends JFrame implements ActionListener {

    protected User user;

    // Defining the frame itself
    private final JFrame mainFrame = new JFrame("EMS");

    //Methods for building and maintaining the frame
    public mainFrame(String title) throws IOException {init(title);}
    public mainFrame(User user, String title){
        this.user = user;
        init(title);
    }

    private void init(String title) {
        setTitle(title);
        setSize(900, 500);
        setVisible(true);
        setResizable(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addUIcomponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    protected abstract void addUIcomponents();

}
