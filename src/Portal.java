import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Portal {

    private final BufferedImage backgroundImg;

    private final ImageIcon icon;

    JFrame frame = new JFrame("Portal Dashboard");
    JPanel panel = new JPanel();
    JLabel background = new JLabel();
    JLabel message = new JLabel("Welcome!"); // ToDo:Add username
    JLabel welcomeLabel = new JLabel(("Welcome to the Portal"));

    Portal() throws IOException {

        backgroundImg = ImageIO.read(this.getClass().getResource("portal.jpg"));
        icon = new ImageIcon(backgroundImg);

        background.setIcon(icon);
        background.setBounds(0,0, 1024,1024);

        message.setBounds(50,50, 300,30);
        message.setFont(new Font(null, Font.BOLD, 25));
        message.setForeground(Color.WHITE);

        panel.add(message);
        panel.add(background);
        panel.setBounds(0,0,1024,1024);
        panel.setLayout(null);

        frame.add(panel);

        welcomeLabel.setBounds(10,10,500,35);
        welcomeLabel.setFont(new Font(null, Font.PLAIN, 25));

        //frame.setLocationRelativeTo(null);  // Centers frame on screen
        frame.setSize(1024,1024);
        frame.add(welcomeLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(null);
        frame.setVisible(true);
    }
}
