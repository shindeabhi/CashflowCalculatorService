package com.abhishek.actors.system.initialiser;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.abhishek.calculators.DividendCalculationParam;
import com.abhishek.dividend.actors.DividendActor;

import java.math.BigDecimal;

/**
 * Created by user on 8/19/2017.
 */
public class ActorSystemInitializer {

    public static void main(String[] args) {
        ActorSystem cashflowSystem = ActorSystem.create("cashflow_actor_system");
        ActorRef dividendActor = cashflowSystem.actorOf(Props.create(DividendActor.class), "dividend_actor");

        for (int i = 0; i < 100; i++) {
            dividendActor.tell(
                    new DividendCalculationParam(Long.valueOf(123456),
                            BigDecimal.valueOf(123.5678),
                            BigDecimal.valueOf(Math.random())),
                    ActorRef.noSender());
        }
    }
}
