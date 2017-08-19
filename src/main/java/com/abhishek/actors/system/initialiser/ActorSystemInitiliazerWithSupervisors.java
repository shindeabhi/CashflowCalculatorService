package com.abhishek.actors.system.initialiser;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.abhishek.calculators.DividendCalculationParam;
import com.abhishek.com.abhishek.supervisors.CashflowSystemSupervisor;

import java.math.BigDecimal;

/**
 * Created by user on 8/20/2017.
 */
public class ActorSystemInitiliazerWithSupervisors {

    public static void main(String[] args) {
        ActorSystem cashflowSystem = ActorSystem.create("cashflow_actor_system");
        ActorRef cashflowSystemSupervisor = cashflowSystem.actorOf(Props.create(CashflowSystemSupervisor.class), "cashflow_system_supervisor");
        // akka://cashflow_actor_system/user/cashflow_system_supervisor/dividend_actor
        for (int i = 0; i < 20; i++) {
            cashflowSystemSupervisor.tell(
                    new DividendCalculationParam(Long.valueOf(123456),
                            BigDecimal.valueOf(123.5678),
                            BigDecimal.valueOf(Math.random())),
                    ActorRef.noSender());
        }
    }
}
