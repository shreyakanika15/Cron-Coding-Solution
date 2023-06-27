package com.deliveroo.parsers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Range extends com.deliveroo.parsers.Base {

  public Range(com.deliveroo.segments.Base segment) {
    super(segment);
  }

  @Override
  public List<Integer> generatePossibleExpressions() {
    List<Integer> rangeLimits = List.of(this.segment.getExpression().split("-")).stream()
            .map(Integer::valueOf).collect(
                    Collectors.toList());

    if (rangeLimits.size() != 2) {
      throw new RuntimeException(
              "Range does not have valid expression : " + this.segment.getExpression());
    }

    if (rangeLimits.get(1) < rangeLimits.get(0)) {
      throw new RuntimeException(
              "Range minimum/maximum are in wrong order. maximum should be : " + rangeLimits.get(0)
                      + " and minimum should be : " + rangeLimits.get(1));
    }

    if (rangeLimits.get(0) < this.segment.getMinimum()) {
      throw new RuntimeException(
              "Range minimum is not valid. Given : " + rangeLimits.get(0) + " Min allowed : "
                      + this.segment.getMinimum());
    }

    if (rangeLimits.get(0) > this.segment.getMaximum()) {
      throw new RuntimeException(
              "Range minimum is not valid. Given : " + rangeLimits.get(0) + " Max allowed : "
                      + this.segment.getMaximum());
    }

    if (rangeLimits.get(1) > this.segment.getMaximum()) {
      throw new RuntimeException(
              "Range maximum is not valid. Given : " + rangeLimits.get(1) + " Max allowed : "
                      + this.segment.getMaximum());
    }

    return Arrays.stream(IntStream.range(rangeLimits.get(0), rangeLimits.get(1) + 1).toArray())
            .boxed().collect(
                    Collectors.toList());
  }
}
