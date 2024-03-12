package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {
    public static void main(String[] args) {

    }

    static String[] massProcess(Integer[] box1, Integer[] box2, String operation, String displayMode) {
        String result[] = new String[box1.length];
        for (int i = 0; i < box1.length; i++) {
            double num1 = box1[i].doubleValue();
            if (i >= box2.length) {
                result[i] = "";
                continue;
            }
            double num2 = box2[i].doubleValue();
            double numResult = 0.0;
            switch (operation) {
                case "Add":
                    numResult = num1 + num2;
                    break;
                case "Substract":
                    numResult = num1 - num2;
                    break;
                case "Multiply":
                    numResult = num1 * num2;
                    break;
                case "Divide":
                    numResult = num1 / num2;
                    break;
                default:
                    result[i] = "";
            }
            switch (displayMode) {
                case "Fractional":
                    result[i] = String.format("%.3", numResult);
                    break;
                case "Round":
                    result[i] = "" + (int) Math.round(numResult);
                    break;
                case "Round Down":
                    result[i] = "" + (int) Math.floor(numResult);
                    break;
                case "Round Up":
                    result[i] = "" + (int) Math.ceil(numResult);
                    break;
                case "Scientific":
                    result[i] = String.format("%.3e", numResult);
                    break;
                default:
                    result[i] = "";
            }

        }
        return result;
    }
}