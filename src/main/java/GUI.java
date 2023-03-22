import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {
        setTitle("Polynomial Calculator");
        setSize(500, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel inputOutputPanel = new JPanel(new GridLayout(3, 2));
        JLabel inputLabel1 = new JLabel("Polynomial 1:");
        inputLabel1.setFont(new Font("Arial", Font.BOLD, 16));
        inputOutputPanel.add(inputLabel1);

        JTextField inputField1 = new JTextField();
        inputField1.setPreferredSize(inputLabel1.getPreferredSize());
        inputOutputPanel.add(inputField1);
        JLabel inputLabel2 = new JLabel("Polynomial 2:");
        inputLabel2.setFont(new Font("Arial", Font.BOLD, 16));
        inputOutputPanel.add(inputLabel2);

        JTextField inputField2 = new JTextField();
        inputField2.setPreferredSize(inputLabel2.getPreferredSize());
        inputOutputPanel.add(inputField2);
        JLabel outputLabel = new JLabel("Result:");
        outputLabel.setFont(new Font("Arial", Font.BOLD, 16));
        inputOutputPanel.add(outputLabel);

        JTextField outputField = new JTextField();
        outputField.setEditable(false);
        inputOutputPanel.add(outputField);
        add(inputOutputPanel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 5));
        String[] buttonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "x", "^", "+", "-", "*", "/", "d", "i", "=", "D"};
        JButton[] buttons = new JButton[buttonLabels.length];
        for (int i = 0; i < buttonLabels.length; i++) {
            buttons[i] = new JButton(buttonLabels[i]);
            buttonPanel.add(buttons[i]);
        }
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }
}