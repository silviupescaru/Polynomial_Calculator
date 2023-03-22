import java.util.Iterator;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Polinom {
    public TreeMap<Integer, Integer> pol1;
    public TreeMap<Integer, Integer> pol2;
    public TreeMap<Integer, Integer> result;

    public Polinom() {
        pol1 = new TreeMap<>();
        pol2 = new TreeMap<>();
        result = new TreeMap<>();
    }

    public void addTerm(String term, TreeMap<Integer, Integer> pol) {
        Pattern pattern = Pattern.compile("(-?\\d*)(x(?:\\^(\\d+))?)?");
        Matcher matcher = pattern.matcher(term);
        if (matcher.matches()) {
            int coefficient = 1;
            int degree;
            if (matcher.group(1) != null && !matcher.group(1).equals("")) {
                coefficient = Integer.parseInt(matcher.group(1));
            }
            if (matcher.group(3) != null && !matcher.group(3).equals("")) {
                degree = Integer.parseInt(matcher.group(3));
            } else if (matcher.group(2) == null) {
                degree = 0;
            } else {
                degree = 1;
            }
            if (pol.containsKey(degree)) {
                int currentCoefficient = pol.get(degree);
                pol.put(degree, currentCoefficient + coefficient);
            } else {
                pol.put(degree, coefficient);
            }
        }
    }

    public void addPolinoms() {
        result.clear();
        for (int degree : pol1.keySet()) {
            int coefficient = pol1.get(degree);
            result.put(degree, coefficient);
        }
        for (int degree : pol2.keySet()) {
            int coefficient = pol2.get(degree);
            if (result.containsKey(degree)) {
                int currentCoefficient = result.get(degree);
                result.put(degree, currentCoefficient + coefficient);
            } else {
                result.put(degree, coefficient);
            }
        }
    }

    public void subtractPolinoms() {
        result.clear();
        for (int degree : pol1.keySet()) {
            int coefficient = pol1.get(degree);
            result.put(degree, coefficient);
        }
        for (int degree : pol2.keySet()) {
            int coefficient = pol2.get(degree);
            if (result.containsKey(degree)) {
                int currentCoefficient = result.get(degree);
                result.put(degree, currentCoefficient - coefficient);
            } else {
                result.put(degree, -coefficient);
            }
        }
    }

    public void setPol1(TreeMap<Integer, Integer> pol1) {
        this.pol1 = pol1;
    }

    public void setPol2(TreeMap<Integer, Integer> pol2) {
        this.pol2 = pol2;
    }

    public TreeMap<Integer, Integer> getPol1() {
        return pol1;
    }

    public TreeMap<Integer, Integer> getPol2() {
        return pol2;
    }

    public TreeMap<Integer, Integer> getResult() {
        return result;
    }

    public String toString(TreeMap<Integer, Integer> pol) {
        StringBuilder sb = new StringBuilder();
        Iterator<Integer> descendingKeys = pol.descendingKeySet().iterator();
        while (descendingKeys.hasNext()) {
            int degree = descendingKeys.next();
            int coefficient = pol.get(degree);
            if (coefficient == 0) {
                continue; // skip terms with zero coefficient
            }
            if (coefficient > 0 && sb.length() > 0) {
                sb.append(" + "); // add plus sign for positive coefficients after the first term
            }
            if (coefficient < 0) {
                sb.append("-"); // add minus sign for negative coefficients
                coefficient = -coefficient;
            }
            sb.append(coefficient);
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
