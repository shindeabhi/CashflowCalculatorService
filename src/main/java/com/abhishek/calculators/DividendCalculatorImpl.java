package com.abhishek.calculators;

import java.math.BigDecimal;

/**
 * Created by user on 8/19/2017.
 */
public class DividendCalculatorImpl implements DividendCalculator {

    public BigDecimal calculateCashflow(DividendCalculationParam dividendCalculationParam) {
        BigDecimal dividendAmt =
                dividendCalculationParam.getNosOfUnitsInPortfolio().multiply(dividendCalculationParam.getPricePerUnit());
        dividendAmt.setScale(6,BigDecimal.ROUND_HALF_UP);
        return dividendAmt;
    }
}
