package com.abhishek.calculators;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 8/19/2017.
 */
class DividendCalculatorImplTest {

    DividendCalculator dividendCalculator = new DividendCalculatorImpl();

    @Test
    public void should_calculate_cashflows_when_nos_of_units_and_div_per_unit_passed() {
        DividendCalculationParam dividendCalculationParam = new DividendCalculationParam(Long.valueOf(123456),BigDecimal.valueOf(123.5678),BigDecimal.valueOf(0.3));
        BigDecimal dividendAmt = dividendCalculator.calculateCashflow(dividendCalculationParam);
        assertEquals("Dividend Amt is not matching",BigDecimal.valueOf(37.07034),dividendAmt);
    }


}