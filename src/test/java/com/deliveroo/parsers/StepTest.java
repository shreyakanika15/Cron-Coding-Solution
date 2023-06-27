package com.deliveroo.parsers;

import com.deliveroo.segments.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class StepTest {

    @Test
    void generatePossibleExpressionsForStep() {
        Base base = Mockito.mock(Base.class, Answers.CALLS_REAL_METHODS);

        Step step = new Step(base);
        when(base.getExpression()).thenReturn("*/2");
        when(base.getMinimum()).thenReturn(0);
        when(base.getMaximum()).thenReturn(31);
        java.util.List<Integer> possibilities = step.generatePossibleExpressions();

        Assertions.assertNotNull(possibilities);
        Assertions.assertEquals(possibilities.size(), 16);
    }
}

