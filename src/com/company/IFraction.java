package com.company;


public interface IFraction {

    /**
     *  Adds two fractions together
     * @param fraction
     * @return new instance which represents the resukt
     */
    public IFraction add(final IFraction fraction);

    /**
     * Subtracts two fractions
     * @param fraction
     * @return new instance representing the result
     */
    public IFraction minus(final IFraction fraction);

    /**
     * Multiplies fractions
     * @param fraction
     * @return new instance representing the result
     */
    public IFraction times(final IFraction fraction);

    /**
     * Divides one fraction by another
     * @param fraction
     * @return new instance representing the result
     */
    public IFraction divide(final IFraction fraction);

    /**
     * @return new Fraction like this: 10/2 => 5/1
     */
    public IFraction beautify();

    /**
     * @return float representation
     */
    public float getFloatValue();

    public Integer getNumerator();

    public Integer getDenominator();


    public boolean equals(final IFraction o);
}
