import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    Calculator calculator;
    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Simple Multiplication Should Work")
    void testMultiply() {
        assertEquals(20,calculator.multiply(5,4));
    }

    @RepeatedTest(5)
    @DisplayName("Ensure Correct handling of Zero")
    void testMultipleWithZero(){
        assertEquals(0,calculator.multiply(0,5),()->"Multiply with zero should be zero");
        assertEquals(0,calculator.multiply(5,0),"Multiply with zero should be zero");
    }
}
