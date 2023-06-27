package com.deliveroo.parsers;

import java.util.List;

public class Exact extends com.deliveroo.parsers.Base {

  public Exact(com.deliveroo.segments.Base segment) {
    super(segment);
  }

  @Override
  public List<Integer> generatePossibleExpressions() {
    Integer value = Integer.valueOf(this.segment.getExpression());
    if (value > this.segment.getMaximum()) {
      throw new RuntimeException("The value for segment is more than the maximum allowed");
    }

    if (value < this.segment.getMinimum()) {
      throw new RuntimeException("The value for segment is less than the minimum allowed");
    }

    return List.of(value);
  }
}
