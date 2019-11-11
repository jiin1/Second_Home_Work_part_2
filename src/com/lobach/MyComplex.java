package com.lobach;

public class MyComplex {
    private double real;
    private double imag;

    public MyComplex() {
        this.real = 0.0;
        this.imag = 0.0;
    }

    public MyComplex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImag() {
        return imag;
    }

    public void setImag(double imag) {
        this.imag = imag;
    }

    public void setValue(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    @Override
    public String toString() {
        return "(" + real +
                "+" + imag +
                "i)";
    }

    public boolean isReal() {
        return this.real != 0.0;
    }

    public boolean isImagery() {
        return this.imag != 0.0;
    }

    public boolean equals(double real, double imag) {
        return this.imag == imag & this.real == real;

    }

    public boolean equals(MyComplex another) {
        return this.imag == another.getImag() & this.real == another.getReal();

    }

    public double magnitude() {
        return Math.sqrt(real * real + imag * imag);
    }

    public double argument() {
        double i = 0.0;
        if (real > 0 & imag >= 0)
            i = Math.atan(imag / real);
        if (real < 0 & imag >= 0)
            i = Math.PI - Math.atan(Math.abs(imag / real));
        if (real < 0 & imag < 0)
            i = Math.PI + Math.atan(Math.abs(imag / real));
        if (real > 0 & imag < 0)
            i = 2 * Math.PI + Math.atan(Math.abs(imag / real));
        if (real == 0 & imag > 0)
            i = Math.PI / 2;
        if (real == 0 & imag < 0)
            i = 3 * Math.PI / 2;
        return i;
    }

    public MyComplex add(MyComplex right) {
        imag += right.getImag();
        real += right.getReal();
        return this;
    }

    public MyComplex addNew(MyComplex right) {
        double i = imag + right.getImag();
        double r = real + right.getReal();
        MyComplex myComplex = new MyComplex(r, i);
        return myComplex;
    }

    public MyComplex substract(MyComplex right) {
        imag -= right.getImag();
        real -= right.getReal();
        return this;
    }

    public MyComplex substractNew(MyComplex right) {
        double i = imag - right.getImag();
        double r = real - right.getReal();
        MyComplex myComplex = new MyComplex(r, i);
        return myComplex;
    }

    public MyComplex multiply(MyComplex right) {
        imag += right.getImag();
        real -= right.getReal();
        return this;
    }

    public MyComplex divide(MyComplex right) {
        double b = imag;
        double a = real;
        double a1 = right.getReal();
        double b1 = right.getImag();

        imag = (a * b1 - b * b1) / (a1 * a1 + b1 * b1);
        real = (a * a1 + b * b1) / (a1 * a1 + b1 * b1);
        return this;
    }

    public MyComplex conjugate() {
        imag *= -1;
        return this;
    }
}
