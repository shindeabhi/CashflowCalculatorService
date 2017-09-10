package com.abhishek.calculators;

import java.math.BigDecimal;

public class DividendCalculationParam implements CalculationParam {
    private final Long portfolioNo;
    private final BigDecimal nosOfUnitsInPortfolio;
    private final BigDecimal dividendDeclaredPerUnit;

    public DividendCalculationParam(Long portfolioNo, BigDecimal nosOfUnitsInPortfolio, BigDecimal dividendDeclaredPerUnit) {
        this.portfolioNo = portfolioNo;
        this.nosOfUnitsInPortfolio = nosOfUnitsInPortfolio;
        this.dividendDeclaredPerUnit = dividendDeclaredPerUnit;
    }

    public BigDecimal getNosOfUnitsInPortfolio() {
        return nosOfUnitsInPortfolio;
    }

    public BigDecimal getDividendDeclaredPerUnit() {
        return dividendDeclaredPerUnit;
    }

    @Override
    public String toString() {
        return "DividendCalculationParam{" +
                "portfolioNo=" + portfolioNo +
                ", nosOfUnitsInPortfolio=" + nosOfUnitsInPortfolio +
                ", dividendDeclaredPerUnit=" + dividendDeclaredPerUnit +
                '}';
    }
}
