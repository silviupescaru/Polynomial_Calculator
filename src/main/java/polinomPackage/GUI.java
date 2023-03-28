package polinomPackage;

import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    private JPanel mainPanel;

    private JPanel polinomPanel;
    private JLabel pol1Label;
    private JTextField textField1;
    private JLabel pol2Label;
    private JTextField textField2;
    private JLabel rezultatLabel;
    private JTextField textField3;

    private JPanel buttonPanel;
    private JButton adunareButton;
    private JButton inmultireButton;
    private JButton derivareButton;
    private JButton scadereButton;
    private JButton loadButton;
    private JButton integrareButton;

    Polinom polinom = new Polinom();
    Polinom polinomInitial = new Polinom();

    public GUI() {
        super("Calculator Polinoame");
        setSize(850, 420);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1, 10, 10));
        mainPanel.setBackground(new Color(-16370603));

        JPanel polinomPanel = new JPanel();
        polinomPanel.setLayout(new GridLayout(3, 2, 10, 10));
        polinomPanel.setBackground(new Color(-16370603));
        mainPanel.add(polinomPanel);

        JLabel pol1Label = new JLabel();
        pol1Label.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        pol1Label.setForeground(new Color(-3));
        pol1Label.setText("polinomPackage.Polinom 1:");
        polinomPanel.add(pol1Label);

        JTextField textField1 = new JTextField();
        textField1.setBackground(new Color(-9532));
        textField1.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
        polinomPanel.add(textField1);

        JLabel pol2Label = new JLabel();
        pol2Label.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        pol2Label.setForeground(new Color(-3));
        pol2Label.setText("polinomPackage.Polinom 2:");
        polinomPanel.add(pol2Label);

        JTextField textField2 = new JTextField();
        textField2.setBackground(new Color(-9532));
        textField2.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
        polinomPanel.add(textField2);

        JLabel rezultatLabel = new JLabel();
        rezultatLabel.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        rezultatLabel.setForeground(new Color(-3));
        rezultatLabel.setText("Rezultat:");
        polinomPanel.add(rezultatLabel);

        JTextField textField3 = new JTextField();
        textField3.setBackground(new Color(-9532));
        textField3.setFont(new Font("Ubuntu Mono", Font.BOLD, 16));
        polinomPanel.add(textField3);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));
        buttonPanel.setBackground(new Color(-16370603));
        mainPanel.add(buttonPanel);


        JButton adunareButton = new JButton("Adunare");
        adunareButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        adunareButton.setBackground(new Color(-12017220));
        buttonPanel.add(adunareButton);

        JButton scadereButton = new JButton("Scadere");
        scadereButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        scadereButton.setBackground(new Color(-12017220));
        buttonPanel.add(scadereButton);

        JButton inmultireButton = new JButton("Inmultire");
        inmultireButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        inmultireButton.setBackground(new Color(-2712213));
        buttonPanel.add(inmultireButton);

        JButton loadButton = new JButton("Load");
        loadButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        loadButton.setBackground(new Color(-2712213));
        buttonPanel.add(loadButton);

        JButton derivareButton = new JButton("Derivare");
        derivareButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        derivareButton.setBackground(new Color(-4434599));
        buttonPanel.add(derivareButton);

        JButton integrareButton = new JButton("Integrare");
        integrareButton.setFont(new Font("Ubuntu Mono", Font.BOLD, 18));
        integrareButton.setBackground(new Color(-4434599));
        buttonPanel.add(integrareButton);


        loadButton.addActionListener(e -> {
            String polynomial1 = textField1.getText();
            polinom.addPolynomial(polynomial1, polinom.pol1);
            String polynomial2 = textField2.getText();
            polinom.addPolynomial(polynomial2, polinom.pol2);
            textField3.setText("");
        });

        adunareButton.addActionListener(e -> {
            polinom.addPolinoms();
            String resultP = polinom.toString(polinom.getResult());
            textField3.setText(resultP);
            System.out.println(polinom.toString(polinom.pol1));
            System.out.println(polinom.toString(polinom.pol2));
            System.out.println("Pol1 + Pol2: " + polinom.toString(polinom.getResult()));
        });

        scadereButton.addActionListener(e -> {
            polinom.subtractPolinoms();
            String resultP = polinom.toString(polinom.getResult());
            textField3.setText(resultP);
            System.out.println(polinom.toString(polinom.pol1));
            System.out.println(polinom.toString(polinom.pol2));
            System.out.println("Pol1 - Pol2: " + polinom.toString(polinom.getResult()));
        });

        inmultireButton.addActionListener(e -> {
            polinom.multiplyPolinoms();
            String resultP = polinom.toString(polinom.getResult());
            textField3.setText(resultP);
            System.out.println(polinom.toString(polinom.pol1));
            System.out.println(polinom.toString(polinom.pol2));
            System.out.println("Pol1 * Pol2: " + polinom.toString(polinom.getResult()));
        });

        derivareButton.addActionListener(e -> {
            polinom.derivePolinom(polinom.pol1);
            String resultP = polinom.toString(polinom.getResult());
            textField3.setText(resultP);
            System.out.println(polinom.toString(polinom.pol1));
            System.out.println("Pol1 derivat: " + polinom.toString(polinom.getResult()));
        });

        integrareButton.addActionListener(e -> {
            polinom.integratePolinom(polinom.pol1);
            String resultP = polinom.toString(polinom.getResult());
            textField3.setText(resultP);
            System.out.println(polinom.toString(polinom.pol1));
            System.out.println("Pol1 derivat: " + polinom.toString(polinom.getResult()));
        });

        this.setContentPane(mainPanel);
    }
}