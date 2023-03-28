package polinomPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PolinomTest {

    @Test
    public void testAddition() {
        Polinom p1 = new Polinom();
        p1.addPolynomial("2x^5+3x^3+4x^2+5x^1-6", p1.pol1);
        p1.addPolynomial("-1x^5+2x^4-3x^3+5x^2-2x^1+7", p1.pol2);
        p1.addPolinoms();
        Polinom p2 = new Polinom();
        p2.addPolynomial("1x^5+2x^4+0x^3+9x^2+3x^1+1x^0", p2.pol1);
        Assert.assertEquals(p2.pol1.toString(), p1.result.toString());
    }

    @Test
    public void testSubtraction() {
        Polinom p1 = new Polinom();
        p1.addPolynomial("2x^5+3x^3+4x^2+5x^1-6", p1.pol1);
        p1.addPolynomial("-1x^5+2x^4-3x^3+5x^2-2x^1+7", p1.pol2);
        p1.subtractPolinoms();
        Polinom p2 = new Polinom();
        p2.addPolynomial("3x^5-2x^4+6x^3-1x^2+7x^1-13", p2.pol1);
        Assert.assertEquals(p2.pol1.toString(), p1.result.toString());
    }

    @Test
    public void testMultiplication() {
        Polinom p1 = new Polinom();
        p1.addPolynomial("2x^5+3x^3+4x^2+5x^1-6", p1.pol1);
        p1.addPolynomial("-1x^5+2x^4-3x^3+5x^2-2x^1+7", p1.pol2);
        p1.multiplyPolinoms();
        Polinom p2 = new Polinom();
        p2.addPolynomial("-2x^10+4x^9-9x^8+12x^7-10x^6+33x^5-13x^4+56x^3-12x^2+47x^1-42", p2.pol1);
        Assert.assertEquals(p2.pol1.toString(), p1.result.toString());
    }

    @Test
    public void testDerivative() {
        Polinom p1 = new Polinom();
        p1.addPolynomial("2x^5+3x^3+4x^2+5x^1-6", p1.pol1);
        p1.addPolynomial("-1x^5+2x^4-3x^3+5x^2-2x^1+7", p1.pol2);
        p1.derivePolinom(p1.pol1);
        Polinom p2 = new Polinom();
        p2.addPolynomial("10x^4+9x^2+8x^1+5", p2.pol1);
        Assert.assertEquals(p2.pol1.toString(), p1.result.toString());
    }

    @Test
    public void testIntegration() {
        Polinom p1 = new Polinom();
        p1.addPolynomial("2x^5+3x^3+4x^2+5x^1-6", p1.pol1);
        p1.addPolynomial("-1x^5+2x^4-3x^3+5x^2-2x^1+7", p1.pol2);
        p1.integratePolinom(p1.pol1);
        Polinom p2 = new Polinom();
        p2.addPolynomial("0.3333333333333333x^6+0.75x^4+1.3333333333333333x^3+2.5x^2-6x^1+0x^0", p2.pol1);
        Assert.assertEquals(p2.pol1.toString(), p1.result.toString());
    }
}