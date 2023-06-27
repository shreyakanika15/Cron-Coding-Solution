package com.deliveroo;

import com.deliveroo.segments.*;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CronExpressionParser {

    private static List<String> displayOrder = List.of("minute", "hour", "day", "month", "weekday", "year");
    private static Map<String, String> displayString = Map
            .of("day", "day of month", "weekday", "day of week");
    private String expression;
    private String command;
    private HashMap<String, List> segmentsMap;

    private CronExpressionParser(String expression)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.expression = expression;
        this.segmentsMap = new HashMap<>();
        this.parse();
    }

    public static void main(String[] args)
            throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        if (args.length != 1) {
            throw new RuntimeException("There should be at least one argument : " + String.join(";", args));
        }

        System.out.println(new CronExpressionParser(args[0]).toString());
    }

    private CronExpressionParser parse()
            throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        System.out.println("Expression entered : " + this.expression);
        String[] segments = this.expression.split("\\s+");

        if (segments.length < 6) {
            throw new RuntimeException("There must be 6 segments in the expression");
        }
        int i = 0;
        this.segmentsMap.put("minute", new Minute(segments[i++]).parse());
        this.segmentsMap.put("hour", new Hour(segments[i++]).parse());
        this.segmentsMap.put("day", new Day(segments[i++]).parse());
        this.segmentsMap.put("month", new Month(segments[i++]).parse());
        this.segmentsMap.put("weekday", new Weekday(segments[i++]).parse());
        try {
            this.segmentsMap.put("year", new Year(segments[i++]).parse());
        } catch (Exception e) {
            i--;
        }
        this.command = segments[i] + extractArguments(segments, i + 1);
        return this;
    }

    private String extractArguments(String[] segments, int startingIndex) {
        String arguments = "";
        for (int i = startingIndex; i < segments.length; i++) {
            arguments += " " + segments[i];
        }
        return arguments;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String section : displayOrder) {
            if (this.segmentsMap.get(section) == null) {
                continue;
            }
            String displayString = CronExpressionParser.displayString.getOrDefault(section, section);
            sb.append(String.format(displayString + " ".repeat(14 - displayString.length()) + "%s",
                    this.segmentsMap.get(section).stream().map(i -> i.toString()).collect(
                            Collectors.joining(" "))));
            sb.append(System.getProperty("line.separator"));
        }
        sb.append(String.format("command     %s", this.command));
        return sb.toString();
    }
}
