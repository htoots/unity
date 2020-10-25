package a_theory.question4;

import ee.taltech.unity.service.AlphaVantageApi;
import ee.taltech.unity.service.FinanceCalculator;
import ee.taltech.unity.service.alpha.DailyResponse;
import ee.taltech.unity.service.classes.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class DependencyInjection {

    //todo
    // One of the reasons we use Spring is that it gives us good support for
    // Dependency Injection (DI) and Inversion of Control (IoC)

    //todo p1
    // In your words (do not use wiki definitions)
    // What is Dependency Injection?
    // Answer: Dependency injection is an act of moving creation of dependent objects outside of a class where they are
    //      needed and instead injecting them into it the class after they have been made.

    //todo p2
    // Bring example from your code of Dependency Injection.
    // Paste your code here, but comment it out

//    @Service
//    public class FinanceService {
//
//        @Autowired
//        private AlphaVantageApi alphaVantageApi;
//        @Autowired
//        private FinanceCalculator financeCalculator;
//
//        public Response queryForData(String symbol) {
//            DailyResponse dailyResponse = alphaVantageApi.queryForDaily(symbol);
//            return financeCalculator.getNegPosDays(dailyResponse);
//        }
//    }

    //  Autowired is an injection of beans. When FinanceService is instantiated, alphaVantageApi and financeCalculator
    //  are automatically injected.

    //todo p3
    // Name 2 benefits of Dependency Injection
    // 1 Logic changes effect less of the code.
    // 2 Modules can be reused more efficiently.

    //todo p4
    // Name 1 disadvantage of Dependency Injection
    // 1 DI can be hard to trace due to separating using from constructing.
}
