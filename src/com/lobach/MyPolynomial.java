package com.lobach;

import java.util.Arrays;

public class MyPolynomial {
    private double[] coeffs;

    public MyPolynomial(double... coeffs) {
        this.coeffs = coeffs;
    }

    public int getDegree() {
        return coeffs.length - 1;
    }

    public double[] getCoeffs() {
        return coeffs;
    }

    public void setCoeffs(double[] coeffs) {
        this.coeffs = coeffs;
    }

    @Override
    public String toString() {
        if (coeffs == null)
            return "null";
        int iMax = coeffs.length - 1;
        if (iMax == -1)
            return "";

        StringBuilder b = new StringBuilder();
        b.append('"');

        for (int i = iMax; ; i--) {
            b.append('C' + i + '*' + coeffs[i] + '^' + i);
            if (i == 2)
                break;
            b.append("+ ");
        }

        b.append("C1*" + coeffs[5] + '+');
        b.append(coeffs[0] + '+');
        return b.append('"').toString();
    }


    public double evaluate(double x) {
        int count = 1;
        double res = coeffs[0];
        for (double i : coeffs) {
            res += (count * Math.pow(x, count));
            count++;

        }
        return res;
    }

    public MyPolynomial add(MyPolynomial right) {
        double[] x = new double[Math.max(right.getDegree(), this.getDegree())];
        MyPolynomial myPolynomial = new MyPolynomial(x);
        for (int i = 0; i <= this.getDegree(); i++) myPolynomial.coeffs[i] += right.coeffs[i];
        for (int i = 0; i <= right.getDegree(); i++) myPolynomial.coeffs[i] -= this.coeffs[i];
        return myPolynomial;
    }

    public MyPolynomial multiply(MyPolynomial right) {
        double[] x = new double[Math.max(right.getDegree(), this.getDegree())];
        MyPolynomial myPolynomial = new MyPolynomial(x);
        for (int i = 0; i <= myPolynomial.getDegree(); i++) myPolynomial.coeffs[i] =1;
        for (int i = 0; i <= this.getDegree(); i++) myPolynomial.coeffs[i] *= right.coeffs[i];
        for (int i = 0; i <= right.getDegree(); i++) myPolynomial.coeffs[i] *= this.coeffs[i];
        return myPolynomial;
    }


}