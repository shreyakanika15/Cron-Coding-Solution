package com.deliveroo.parsers;

import com.deliveroo.segments.Base;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.when;

class AnyTest {

    @Test
    void generatePossibileExpressionsForAnyString() {

        Base base = Mockito.mock(Base.class, Answers.CALLS_REAL_METHODS);

        Any any = new Any(base);

        when(base.getMinimum()).thenReturn(0);
        when(base.getMaximum()).thenReturn(31);
        List<Integer> possibilities = any.generatePossibleExpressions();

        Assertions.assertNotNull(possibilities);
        Assertions.assertEquals(possibilities.size(), 32);

    }
}
