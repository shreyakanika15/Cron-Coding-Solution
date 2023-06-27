package com.deliveroo.parsers;

import java.util.stream.Collectors;

public class List extends com.deliveroo.parsers.Base {

  public List(com.deliveroo.segments.Base segment) {
    super(segment);
  }

  @Override
  public java.util.List<Integer> generatePossibleExpressions() {
    String[] lists = this.segment.getExpression().split(",");

    if (lists.length != 2) {
      throw new RuntimeException(
              "List does not have valid expression : " + this.segment.getExpression());
    }

    return java.util.List.of(lists).stream()
            .flatMap(l -> {
              try {
                return com.deliveroo.parsers.Base.get(new com.deliveroo.segments.Base(l) {
                  @Override
                  public Integer getMinimum() {
                    return segment.getMinimum();
                  }

                  @Override
                  public Integer getMaximum() {
                    return segment.getMaximum();
                  }

                  @Override
                  public String getExpression() {
                    return l;
                  }
                }).generatePossibleExpressions().stream();
              } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
              }
            }).distinct().sorted().collect(Collectors.toList());
  }
}
