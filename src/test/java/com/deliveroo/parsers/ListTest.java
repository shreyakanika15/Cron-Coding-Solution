package com.deliveroo.parsers;

import com.deliveroo.segments.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

class ListTest {

    @Test
    void generatePossibleExpressionsForList() {
        Base base = Mockito.mock(Base.class, Answers.CALLS_REAL_METHODS);

        com.deliveroo.parsers.List list = new com.deliveroo.parsers.List(base);
        when(base.getExpression()).thenReturn("1,4");
        when(base.getMinimum()).thenReturn(0);
        when(base.getMaximum()).thenReturn(31);
        List<Integer> possibilities = list.generatePossibleExpressions();

        Assertions.assertNotNull(possibilities);
        Assertions.assertEquals(possibilities.size(), 2);
    }
}
