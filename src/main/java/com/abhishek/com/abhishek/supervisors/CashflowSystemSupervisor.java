package com.abhishek.com.abhishek.supervisors;

import akka.actor.*;
import akka.japi.pf.DeciderBuilder;
import akka.japi.pf.ReceiveBuilder;
import com.abhishek.actors.EquityActor;
import com.abhishek.calculators.CalculationParam;
import com.abhishek.calculators.DividendCalculationParam;
import com.abhishek.calculators.EquityCalculationParam;
import com.abhishek.actors.DividendActor;
import scala.concurrent.duration.Duration;

import java.util.concurrent.TimeUnit;

import static akka.actor.SupervisorStrategy.stop;

/**
 * Created by user on 8/20/2017.
 */
public class CashflowSystemSupervisor extends AbstractLoggingActor {

    final ActorRef dividendActor = getContext().actorOf(Props.create(DividendActor.class), "dividend_actor");

    final ActorRef equityActor = getContext().actorOf(Props.create(EquityActor.class), "equity_actor");

    {
        receive(ReceiveBuilder
                .match(CalculationParam.class, this::forwardForCalculation)
                .build()
        );
    }

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return new OneForOneStrategy(
                3,
                Duration.create(10, TimeUnit.SECONDS),
                DeciderBuilder
                        .match(RuntimeException.class, ex -> stop())
                        .build()
        );
    }

    private void forwardForCalculation(CalculationParam message) {
        if (message instanceof EquityCalculationParam) {
            equityActor.forward(message, getContext());
        } else if (message instanceof DividendCalculationParam) {
            dividendActor.forward(message, getContext());
        }
    }
}
