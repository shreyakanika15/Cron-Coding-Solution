package com.deliveroo.parsers;

import com.deliveroo.segments.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ExactTest {

    @Test
    void generatePossibleExpressionsForExactMatch() {
        Base base = Mockito.mock(Base.class, Answers.CALLS_REAL_METHODS);

        Exact exact = new Exact(base);
        when(base.getExpression()).thenReturn("1");
        when(base.getMinimum()).thenReturn(0);
        when(base.getMaximum()).thenReturn(31);
        List<Integer> possibilities = exact.generatePossibleExpressions();

        Assertions.assertNotNull(possibilities);
        Assertions.assertEquals(possibilities.size(), 1);
    }
}
