import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            GUI gui = new GUI();
            gui.setVisible(true);
        });
        Polinom pol = new Polinom();

        pol.addPolynomial("+2x^2+1x^1-1123", pol.pol1);
        pol.addPolynomial("-1x^2+420", pol.pol2);

        System.out.println("Pol1: " + pol.toString(pol.pol1));
        System.out.println("Pol2: " + pol.toString(pol.pol2));
        pol.addPolinoms();
        System.out.println("Pol1 + Pol2: " + pol.toString(pol.getResult()));
        pol.subtractPolinoms();
        System.out.println("Pol1 - Pol2: " + pol.toString(pol.getResult()));
        pol.multiplyPolinoms();
        System.out.println("Pol1 * Pol2: " + pol.toString(pol.getResult()));


        pol.derivePolinom(pol.pol1);
        System.out.println("Pol1 derivat: " + pol.toString(pol.getResult()));

        pol.integratePolinom(pol.pol1);
        System.out.println("Pol1 integrat: " + pol.toString(pol.getResult()));
    }
}
