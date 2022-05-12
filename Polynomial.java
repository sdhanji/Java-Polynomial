/*
 * PROJECT II: Polynomial.java
 *
 * This file contains a template for the class Polynomial. Not all methods are
 * implemented. Make sure you have carefully read the project formulation
 * before starting to work on this file.
 *
 * This class is designed to use Complex in order to represent polynomials
 * with complex co-efficients. It provides very basic functionality and there
 * are very few methods to implement! The project formulation contains a
 * complete description.
 *
 * Remember not to change the names, parameters or return types of any
 * variables in this file! You should also test this class using the main()
 * function.
 *
 * The function of the methods and instance variables are outlined in the
 * comments directly above them.
 * 
 * Tasks:
 *
 * 1) Complete this class with the indicated methods and instance variables.
 *
 * 2) Fill in the following fields:
 *
 * NAME: Shiv Dhanji
 * UNIVERSITY ID: 2109288
 * DEPARTMENT: Mathematics
 */

public class Polynomial {
    /**
     * An array storing the complex co-efficients of the polynomial.
     */
    Complex[] coeff;

    // ========================================================
    // Constructor functions.
    // ========================================================

    /**
     * General constructor: assigns this polynomial a given set of
     * co-efficients.
     *
     * @param coeff  The co-efficients to use for this polynomial.
     */
    public Polynomial(Complex[] coeff) {
        int length = coeff.length;
        boolean foundLeadingTerm = false;
        for (int i = coeff.length - 1; i >= 0; i--) {
            if (coeff[i].getReal() == 0 && coeff[i].getImag() == 0 && !foundLeadingTerm) {
                length--;
            }
            else{
                foundLeadingTerm = true;
            }
        }
        if (length == 0) {
            this.coeff = new Complex[1];
            this.coeff[0] = new Complex();
        }
        else{
            this.coeff = new Complex[length];
            for (int i = 0; i < this.coeff.length; i++) {
                this.coeff[i] = coeff[i];
            }
        }
    }
    
    /**
     * Default constructor: sets the Polynomial to the zero polynomial.
     */
    public Polynomial() {
        this.coeff = new Complex[1];
        this.coeff[0] = new Complex();
    }

    // ========================================================
    // Operations and functions with polynomials.
    // ========================================================

    /**
     * Return the coefficients array.
     *
     * @return  The coefficients array.
     */
    public Complex[] getCoeff() {
        return this.coeff;
    }

    /**
     * Create a string representation of the polynomial.
     * Use z to represent the variable.  Include terms
     * with zero co-efficients up to the degree of the
     * polynomial.
     *
     * For example: (-5.000+5.000i) + (2.000-2.000i)z + (-1.000+0.000i)z^2
     */
    public String toString() {
        // You need to fill in this method with the correct code.
        String string = "";
        for (int i = 0; i < coeff.length; i++) {
            string += "(" + coeff[i].getReal() + " + " + coeff[i].getImag() + "i)";
            if (i > 0) {
                string += "z";
                if (i > 1) {
                    string += "^" + (i);
                }
            }
            if (i != coeff.length - 1) {
                string += " + ";
            }
        }
        return string;
        //return "(-5.000+5.000i) + (2.000-2.000i)z + (-1.000+0.000i)z^2";
    }

    /**
     * Returns the degree of this polynomial.
     */
    public int degree() {
        return this.getCoeff().length - 1;
    }

    /**
     * Evaluates the polynomial at a given point z.
     *
     * @param z  The point at which to evaluate the polynomial
     * @return   The complex number P(z).
     */
    public Complex evaluate(Complex z) {
        Complex evaluation = this.coeff[this.coeff.length - 1];
        for (int i = this.coeff.length - 1; i > 0; i--) {
            evaluation = (evaluation.multiply(z)).add(this.coeff[i - 1]);
        }
        return evaluation;
    }

    
    // ========================================================
    // Tester function.
    // ========================================================

    public static void main(String[] args) {
        // You can fill in this function with your own testing code.
        Complex A = new Complex();
        Complex B = new Complex(2, 1);
        Complex C = new Complex(4.6, 8.5);
        Complex D = new Complex(10, 0);
        Complex E = new Complex(-9, 6);
        Complex[] a_coefficients = new Complex[]{A, A, A, A, A, A};
        Complex[] b_coefficients = new Complex[]{B, C, D, E, A, A};
        Polynomial a = new Polynomial(a_coefficients);
        Polynomial b = new Polynomial(b_coefficients);
        Polynomial c = new Polynomial();
        System.out.println(a.getCoeff()[0]);
        System.out.println(b.getCoeff()[3]);
        System.out.println(c.getCoeff()[0]);
        System.out.println();
        System.out.println(a.degree());
        System.out.println(b.degree());
        System.out.println(c.degree());
        System.out.println();
        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
        System.out.println();
        System.out.println(a.evaluate(E));
        System.out.println(b.evaluate(C));
        System.out.println(c.evaluate(B));
        System.out.println();
        System.out.println("stop");
    }
}