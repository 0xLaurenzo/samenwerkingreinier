package polynomial;

import java.util.Scanner;

/**
 * For representing terms in a polynomial.
 *
 * @author Sjaak Smetsers
 * @version 1.0
 * @date 15-02-2012
 */
public class Term {

    /**
     * Each term consists of a coefficient and an exponent
     */
    private double coefficient;
    private int exponent;

    /**
     * a get-method for the exponent
     *
     * @return exponent
     */
    public int getExp() {
        return exponent;
    }

    /**
     * a get-method for the coefficient
     *
     * @return coefficient
     */
    public double getCoef() {
        return coefficient;
    }

    /**
     * A two-argument constructor
     *
     * @param c the value for the coefficient
     * @param e the value for the exponent
     */
    public Term(double c, int e) {
        coefficient = c;
        exponent = e;
    }

    /**
     * A copy-constructor
     *
     * @param t the term to be copied
     */
    public Term(Term t) {
        this(t.coefficient, t.exponent);
    }

    /**
     * For adding two terms with equal exponents
     *
     * @param t the term added to this
     * @require exponent == t.exponent
     */
    public void plus(Term t) {
        coefficient += t.coefficient;
    }

    /**
     * For multiplying two terms
     *
     * @param t the multiplier
     */
    public void times(Term t) {
        exponent += t.exponent;
        coefficient *= t.coefficient;
    }

    /**
     * For negating terms
     *
     * @param t the divisor
     */
    public void neg() {
        coefficient *= -1;
    }
    /**
     * For dividing two terms
     *
     * @param t the divisor
     */
    public void divide(Term t) {
        if ( exponent < t.exponent ) {
            throw new ArithmeticException( "division error: exponent of divisor too large" );
        }
        exponent -= t.exponent;
        coefficient /= t.coefficient;
    }
    
    /**
     * Converts a term into a readable representation the standard format is
     * %fx^%d
     *
     * @return the string representing the term
     */
    @Override
    public String toString() {
        if (exponent == 0) {
            return String.format("%f", coefficient, exponent);
        } else if (exponent == 1) {
            return String.format("%fx", coefficient, exponent);
        } else {
            return String.format("%fx^%d", coefficient, exponent);
        }
    }

    /**
     * Standard implementation of equality
     */
    @Override
    public boolean equals(Object may_be_term) {
        if (may_be_term == null || getClass() != may_be_term.getClass()) {
            return false;
        } else {
            Term term = (Term) may_be_term;
            return exponent == term.exponent
                    && coefficient == term.coefficient;
        }
    }

    /**
     * A static method for converting scanner input into a term. The expected
     * format is two numbers (coef, exp) separated by whitespaces. The coef
     * should be either an integer or a decimal number. The exp is an integer.
     *
     * @param s the scanner providing the input
     * @return null if no term could be found, the found term otherwise
     */
    public static Term scanTerm(Scanner s) {
        String coef_patt = "\\-?\\d+(\\.\\d+)?";
        if (s.hasNext(coef_patt)) {
            String coef = s.next(coef_patt);
            int exp = s.nextInt();
            return new Term(Double.parseDouble(coef), exp);
        } else {
            return null;
        }
    }
}
