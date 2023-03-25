
public class Main {
    public static void main(String[] args) {

        //new GUI();
        // Create a new instance of the Polinom class
        Polinom pol = new Polinom();

        // Add terms to pol1 HashMap
        pol.addTerm("10", pol.pol1);
        pol.addTerm("-1x^1", pol.pol1);
        pol.addTerm("2x^2", pol.pol1);
        pol.addTerm("x^3", pol.pol1);

        // Add terms to pol2 HashMap
        pol.addTerm("x^5", pol.pol2);
        pol.addTerm("x^2", pol.pol2);
        pol.addTerm("-2x^1", pol.pol2);
        pol.addTerm("20", pol.pol2);

        // Display pol1, pol2, and their sum and difference
        System.out.println("Pol1: " + pol.toString(pol.pol1));
        System.out.println("Pol2: " + pol.toString(pol.pol2));
        pol.addPolinoms();
        System.out.println("Pol1 + Pol2: " + pol.toString(pol.getResult()));
        pol.subtractPolinoms();
        System.out.println("Pol1 - Pol2: " + pol.toString(pol.getResult()));
        pol.multiplyPolinoms();
        System.out.println("Pol1 * Pol2: " + pol.toString(pol.getResult()));
    }
}
