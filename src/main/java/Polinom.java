
import java.text.DecimalFormat;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    public TreeMap<Integer, Double> pol1;
    public TreeMap<Integer, Double> pol2;
    public TreeMap<Integer, Double> result;

    public Polinom() {
        pol1 = new TreeMap<>();
        pol2 = new TreeMap<>();
        result = new TreeMap<>();
    }

    public void addPolynomial(String polynomial, TreeMap<Integer, Double> pol) {
        Pattern pattern = Pattern.compile("([+\\-]?\\d*)(x(?:\\^(\\d+))?)?"); // matches a term of the form ax^b or ax or b
        Matcher matcher = pattern.matcher(polynomial);
        while (matcher.find()) {
            String coeffString = matcher.group(1);
            String degreeString = matcher.group(3);
            double coeff = 0;
            int degree = 0;
            if (!coeffString.isEmpty()) {
                coeff = Integer.parseInt(coeffString);
            }
            if (degreeString != null) {
                degree = Integer.parseInt(degreeString);
            }
            if (pol.containsKey(degree)) {
                coeff += pol.get(degree);
            }
            pol.put(degree, coeff);
        }
    }

    public void addPolinoms() {
        result.clear();
        for (int degree : pol1.keySet()) {
            double coefficient = pol1.get(degree);
            result.put(degree, coefficient);
        }
        for (int degree : pol2.keySet()) {
            double coefficient = pol2.get(degree);
            if (result.containsKey(degree)) {
                double currentCoefficient = result.get(degree);
                result.put(degree, currentCoefficient + coefficient);
            } else {
                result.put(degree, coefficient);
            }
        }
    }

    public void subtractPolinoms() {
        result.clear();
        for (int degree : pol1.keySet()) {
            double coefficient = pol1.get(degree);
            result.put(degree, coefficient);
        }
        for (int degree : pol2.keySet()) {
            double coefficient = pol2.get(degree);
            if (result.containsKey(degree)) {
                double currentCoefficient = result.get(degree);
                result.put(degree, currentCoefficient - coefficient);
            } else {
                result.put(degree, -coefficient);
            }
        }
    }

    public void multiplyPolinoms() {
        result.clear();
        for (int degree1 : pol1.keySet()) {
            for (int degree2 : pol2.keySet()) {
                double coefficient1 = pol1.get(degree1);
                double coefficient2 = pol2.get(degree2);
                int degreeResult = degree1 + degree2;
                double coefficientResult = coefficient1 * coefficient2;
                if (result.containsKey(degreeResult)) {
                    double currentCoefficient = result.get(degreeResult);
                    result.put(degreeResult, currentCoefficient + coefficientResult);
                } else {
                    result.put(degreeResult, coefficientResult);
                }
            }
        }
    }

    public void derivePolinom(TreeMap<Integer, Double> pol) {
        result.clear();
        for (int degree : pol.keySet()) {
            double coefficient = pol.get(degree);
            if (degree > 0) {
                result.put(degree - 1, degree * coefficient);
            }
        }
    }

    public void integratePolinom(TreeMap<Integer, Double> pol) {
        result.clear();
        for (int degree : pol.keySet()) {
            double coefficient = pol.get(degree);
            result.put(degree + 1, coefficient / (degree + 1));
        }
        result.put(0, 0.0);
    }


    public void setPol1(TreeMap<Integer, Double> pol1) {
        this.pol1 = pol1;
    }

    public void setPol2(TreeMap<Integer, Double> pol2) {
        this.pol2 = pol2;
    }

    public TreeMap<Integer, Double> getPol1() {
        return pol1;
    }

    public TreeMap<Integer, Double> getPol2() {
        return pol2;
    }

    public TreeMap<Integer, Double> getResult() {
        return result;
    }

    public String toString(TreeMap<Integer, Double> pol) {
        StringBuilder sb = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.##");
        for (int degree : pol.descendingKeySet()) {
            double coefficient = pol.get(degree);
            if (coefficient == 0) {
                continue; // skip terms with zero coefficient
            }
            if (coefficient > 0 && sb.length() > 0) {
                sb.append(" + "); // add plus sign for positive coefficients after the first term
            }
            if (coefficient < 0) {
                sb.append(" - "); // add minus sign for negative coefficients
                coefficient = -coefficient;
            }
            sb.append(df.format(coefficient));
            if (degree > 0) {
                sb.append("x");
                if (degree > 1) {
                    sb.append("^").append(degree);
                }
            }
        }
        if (sb.length() == 0) {
            sb.append("0"); // polynomial is zero
        }
        return sb.toString();
    }
}
