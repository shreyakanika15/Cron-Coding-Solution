package com.deliveroo.parsers;

import com.deliveroo.segments.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

class RangeTest {

    @Test
    void generatePossibleExpressionsForRange() {
        Base base = Mockito.mock(Base.class, Answers.CALLS_REAL_METHODS);

        Range range = new Range(base);
        when(base.getExpression()).thenReturn("1-3");
        when(base.getMinimum()).thenReturn(0);
        when(base.getMaximum()).thenReturn(31);
        java.util.List<Integer> possibilities = range.generatePossibleExpressions();

        Assertions.assertNotNull(possibilities);
        Assertions.assertEquals(possibilities.size(), 3);
    }
}
