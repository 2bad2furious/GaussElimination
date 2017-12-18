package com.company;


public class Fraction implements IFraction {

    private Integer numerator;
    private Integer denominator;

    public Fraction(Integer numerator, Integer denominator) {
        int divisor = Utils.greatestCommonDivisor(numerator, denominator);

        this.numerator = numerator / divisor;
        this.denominator = denominator / divisor;
    }

    @Override
    public IFraction add(IFraction fraction) {
        Integer denominator = Utils.leastCommonMultiple(fraction.getDenominator(), this.getDenominator());

        Integer numerator1 = fraction.getNumerator() * (denominator / fraction.getDenominator());
        Integer numerator2 = this.getNumerator() * (denominator / this.getDenominator());

        return new Fraction(numerator1 + numerator2, denominator)
                .beautify();
    }

    @Override
    public IFraction minus(IFraction fraction) {
        Integer denominator = Utils.leastCommonMultiple(fraction.getDenominator(), this.getDenominator());

        Integer numerator1 = fraction.getNumerator() * (denominator / fraction.getDenominator());
        Integer numerator2 = this.getNumerator() * (denominator / this.getDenominator());

        return new Fraction(numerator1 - numerator2, denominator)
                .beautify();
    }

    @Override
    public IFraction times(IFraction fraction) {
        Integer newNumerator = fraction.getNumerator() * this.getNumerator();
        Integer newDenominator = fraction.getDenominator() * this.getDenominator();

        return new Fraction(newNumerator, newDenominator)
                .beautify();
    }

    @Override
    public IFraction divide(IFraction fraction) {
        Integer newNumerator = fraction.getNumerator() * this.getDenominator();
        Integer newDenominator = fraction.getDenominator() * this.getNumerator();

        return new Fraction(newNumerator, newDenominator)
                .beautify();
    }

    @Override
    public float getFloatValue() {
        return (float) this.getNumerator() / this.getDenominator();
    }

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    @Override
    public boolean equals(IFraction o) {
        IFraction beautified = o.beautify();

        return this.getDenominator().equals(beautified.getDenominator()) && this.getNumerator().equals(beautified.getNumerator());
    }

    public IFraction beautify() {
        int divisor = Utils.greatestCommonDivisor(getNumerator(), getDenominator());
        return new Fraction(getNumerator() / divisor, getDenominator() / divisor);
    }

    @Override
    public String toString() {
        return "Fraction " + getNumerator() + "/" + getDenominator();
    }
}
