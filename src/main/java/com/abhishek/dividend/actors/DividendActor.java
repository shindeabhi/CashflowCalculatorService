package com.abhishek.dividend.actors;

import akka.actor.AbstractLoggingActor;
import akka.japi.pf.ReceiveBuilder;
import com.abhishek.calculators.DividendCalculationParam;
import com.abhishek.calculators.DividendCalculator;
import com.abhishek.calculators.DividendCalculatorImpl;

/**
 * Created by user on 8/19/2017.
 */
public class DividendActor extends AbstractLoggingActor {

    DividendCalculator dividendCalculator = new DividendCalculatorImpl();

    {
        receive(ReceiveBuilder
                .match(DividendCalculationParam.class, this::processDividendMessage)
                .build()
        );
    }

    @Override
    public void preStart() throws Exception {
        log().info("Pre-Start Dividend Actor");
        super.preStart();
    }

    @Override
    public void postStop() throws Exception {
        super.postStop();
        log().info("Post-Start Dividend Actor");
    }

    private void processDividendMessage(DividendCalculationParam message) {
        log().info("Dividend Amount:--"+dividendCalculator.calculateCashflow(message));
    }
}
