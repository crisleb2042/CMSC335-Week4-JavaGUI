import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;

public class LoginPage implements ActionListener {

    private final ImageIcon icon;

    private final BufferedImage myPicture;

    // Initalizing JFrame, and JComponents (JPanel, JButton, JLabel) and
    JFrame frame = new JFrame("Portal Login");
    JPanel panel = new JPanel();
    JButton loginButton = new JButton("Login");
    JButton resetButton = new JButton("Reset");
    JTextField userIdField = new JTextField();
    JPasswordField userPasswordField = new JPasswordField();
    JLabel userIdLabel = new JLabel("User ID: ");
    JLabel userPasswordLabel = new JLabel("Password: ");
    JLabel messageLabel = new JLabel("");
    JLabel logoLabel = new JLabel();
    JLabel header = new JLabel("Login to the Portal");
    JLabel notes = new JLabel("ToDo: Add Encryption");
    JLabel notes2 = new JLabel("Hint: Student / UMGC");

    //Creates a HashMap to store key:value pair as String and String of Login & Password
    HashMap<String, String> loginInfo = new HashMap<>();

    //Constructor for LoginPage needs HashMap values for <String,String>
    LoginPage(HashMap<String, String> loginInfoOriginal) throws IOException {

        // Declares Constructor argument HashMap as variable
        loginInfo = loginInfoOriginal;

        // .read method returns BufferedImage from .getResource path
        myPicture = ImageIO.read(this.getClass().getResource("login_logo_small.jpg"));
        icon = new ImageIcon(myPicture);

        userIdLabel.setBounds(50, 200, 75,25);
        userPasswordLabel.setBounds(50, 250, 75,25);
        userIdField.setBounds(125, 200, 200, 25);
        userPasswordField.setBounds(125, 250, 200,25);

        messageLabel.setBounds(100,350,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 20));

        loginButton.setBounds(125, 300, 100,25);
        loginButton.setFocusable(false);
        loginButton.addActionListener(this);

        resetButton.setBounds(225,300,100,25);
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);

        logoLabel.setIcon(icon);
        logoLabel.setBounds(-1,-1,400,400);
        logoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        logoLabel.setVerticalAlignment(SwingConstants.CENTER);

        header.setFont(new Font(null, Font.BOLD, 25));
        header.setBounds(50, 100, 300,30);
        header.setHorizontalAlignment(SwingConstants.CENTER);

        notes.setFont(new Font(null, Font.BOLD, 9));
        notes.setBounds(50, 125, 300,30);
        notes.setHorizontalAlignment(SwingConstants.CENTER);

        notes2.setFont(new Font(null, Font.BOLD, 9));
        notes2.setBounds(50, 150, 300,30);
        notes2.setHorizontalAlignment(SwingConstants.CENTER);

        panel.setLayout(null);
        panel.setBounds(385,-1,400,600);
        panel.setBackground(new Color(230,235,238));
        panel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        //panel.setBorder(BorderFactory.createBevelBorder(1,Color.BLACK,Color.DARK_GRAY));

        // Adding Parts to the frame
        panel.add(logoLabel);
        frame.add(notes);
        frame.add(notes2);
        frame.add(header);
        frame.add(panel);
        frame.add(userIdField);
        frame.add(userPasswordField);
        frame.add(userIdLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(loginButton);
        frame.add(resetButton);

        // Frame properties
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setLocationRelativeTo(null);  // centers the frame on screen
        frame.setSize(800,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    // Logic that compares HashMap key value pairs.
    @Override
    public void actionPerformed(ActionEvent e) {
        // If user pushes resetButton
        if(e.getSource()==resetButton) {
            userIdField.setText("");        // Clears the userIdField
            userPasswordField.setText("");  // Clears userPasswordField
            messageLabel.setText("");       // Resets messageLabel
        }
        // If loginButton is pressed
        if(e.getSource()==loginButton) {

            // Stores userID as String variable
            String userID = userIdField.getText();
            // Uses .getPassword() from the JPasswordField to convert to string
            String userPassword = String.valueOf(userPasswordField.getPassword());

            if(loginInfo.containsKey(userID)) {
                if(loginInfo.get(userID).equals(userPassword)){
                    messageLabel.setForeground(Color.green);
                    messageLabel.setText("Login Successful");
                    frame.dispose();
                    try {
                        new Portal();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else {
                    messageLabel.setForeground(Color.red);
                    messageLabel.setText("Wrong Password");
                }
            }else {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username not found");
            }
        }
    }
}
