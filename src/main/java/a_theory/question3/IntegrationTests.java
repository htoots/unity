package a_theory.question3;

public class IntegrationTests {

    //todo p1
    // What are integration tests? In your words (don't use wiki definitions)
    // Answer: A type of test where you combine individual components of code and test them as a group.

    //todo p2
    // Name 2 benefits of integration tests
    // 1 Covers a larger volume of the code, being more efficient and confirming everything works together
    // 2 Detects errors related between modules

    //todo p3
    // Name 1 disadvantage of integration tests
    // 1 Most modules are tested at once, critical modules that need to work are not tested separately.

    //todo p4
    // Name 2 integration test frameworks or libraries
    // 1 JUnit
    // 2 Spock

    //todo p5
    // Would you use mocking with integration tests?
    // Yes/No: No
    // Why? Since you are integrating multiple modules into one test, it is imperative that all these modules work
    //      as intended. If they all work correctly, there is no need for mocks.
}
