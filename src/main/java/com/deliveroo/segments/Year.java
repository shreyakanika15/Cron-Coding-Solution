package com.deliveroo.segments;

public class Year extends Base {
    public Year(String expression) {
        super(expression);
        this.minimum = 1970;
        this.maximum = 2076;
    }
}
