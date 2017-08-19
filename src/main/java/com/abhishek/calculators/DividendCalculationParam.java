package com.abhishek.calculators;

import java.math.BigDecimal;

public class DividendCalculationParam {
    private final Long portfolioNo;
    private final BigDecimal nosOfUnitsInPortfolio;
    private final BigDecimal pricePerUnit;

    public DividendCalculationParam(Long portfolioNo, BigDecimal nosOfUnitsInPortfolio, BigDecimal pricePerUnit) {
        this.portfolioNo = portfolioNo;
        this.nosOfUnitsInPortfolio = nosOfUnitsInPortfolio;
        this.pricePerUnit = pricePerUnit;
    }

    public BigDecimal getNosOfUnitsInPortfolio() {
        return nosOfUnitsInPortfolio;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    @Override
    public String toString() {
        return "DividendCalculationParam{" +
                "portfolioNo=" + portfolioNo +
                ", nosOfUnitsInPortfolio=" + nosOfUnitsInPortfolio +
                ", pricePerUnit=" + pricePerUnit +
                '}';
    }
}
