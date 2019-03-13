package com.epam.cleancode.comments;


class MortgageInstallmentCalculator {

    private static final String INVALID_INPUT_EXCEPTION = "Negative values are not allowed";
    private static final double NUMBER_FOR_CONVERT_TO_DECIMAL = 100.0;
    private static final double AMOUNT_OF_MONTHS = 12.0;
    private static final double MIN_VALUE = 12.0;

    /**
     *
     * @param loanAmount principal amount
     * @param termDurationInYears term of mortgage in years
     * @param digitaRateOfInterest rate of interest
     * @return monthly payment amount
     */
    static double calculateMonthlyPayment(final int loanAmount, final int termDurationInYears, double digitaRateOfInterest) {

        digitaRateOfInterest = digitaRateOfInterest / NUMBER_FOR_CONVERT_TO_DECIMAL;
        double rateOfMonthlyInterest = digitaRateOfInterest /AMOUNT_OF_MONTHS;
        double termDurationInMonths = termDurationInYears * AMOUNT_OF_MONTHS;

        if (loanAmount < MIN_VALUE || termDurationInYears <= MIN_VALUE || digitaRateOfInterest < MIN_VALUE) {
            throw new InvalidInputException(INVALID_INPUT_EXCEPTION);
        }

        if(digitaRateOfInterest == 0) {
            return loanAmount / termDurationInMonths;
        }

        return (loanAmount * rateOfMonthlyInterest) / (1 - Math.pow(1 + rateOfMonthlyInterest, -termDurationInMonths));
    }

}
