package com.abhishek.calculators;

import java.math.BigDecimal;

/**
 * Created by user on 8/19/2017.
 */
public interface DividendCalculator {

    BigDecimal calculateCashflow(DividendCalculationParam dividendCalculationParam);
}
