package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;


public class App {
     public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> "Hello, World");

        post("/compute", (req, res) -> {
          String input1 = req.queryParams("input1");
          java.util.Scanner sc1 = new java.util.Scanner(input1);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList = new java.util.ArrayList<>();
          while (sc1.hasNext())
          {
            int value = Integer.parseInt(sc1.next().replaceAll("\\s",""));
            inputList.add(value);
          }
          System.out.println(inputList);


          String input2 = req.queryParams("input2");
          java.util.Scanner sc2 = new java.util.Scanner(input2);
          sc2.useDelimiter("[;\r\n]+");
          java.util.ArrayList<Integer> inputList2 = new java.util.ArrayList<>();
          while (sc2.hasNext())
          {
            int value = Integer.parseInt(sc2.next().replaceAll("\\s",""));
            inputList2.add(value);
          }
          System.out.println(inputList2);

          String input3 = req.queryParams("input3");
          java.util.Scanner sc3 = new java.util.Scanner(input3);
          sc3.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList3 = new java.util.ArrayList<>();
          while (sc3.hasNext())
          {
            String value = sc3.next().replaceAll("\\s","");
            inputList3.add(value);
          }
          System.out.println(inputList3);

          String input4 = req.queryParams("input4");
          java.util.Scanner sc4 = new java.util.Scanner(input4);
          sc1.useDelimiter("[;\r\n]+");
          java.util.ArrayList<String> inputList4 = new java.util.ArrayList<>();
          while (sc4.hasNext())
          {
            String value = sc4.next().replaceAll("\\s","");
            inputList4.add(value);
          }
          System.out.println(inputList4);

          String[] results = App.massProcess((Integer[])inputList.toArray(), (Integer[])inputList2.toArray(), inputList3.get(0),inputList4.get(0));

         Map map = new HashMap();
          map.put("result", Arrays.toString(results));
          return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());


        get("/compute",
            (rq, rs) -> {
              Map map = new HashMap();
              map.put("result", "not computed yet!");
              return new ModelAndView(map, "compute.mustache");
            },
            new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    static String[] massProcess(Integer[] box1, Integer[] box2, String operation, String displayMode) {
        String result[] = new String[box1.length];
        for (int i = 0; i < box1.length; i++) {
            if (i >= box2.length || box1[i] == null || box2[i] == null) {
                result[i] = "";
                continue;
            }
            double num1 = box1[i].doubleValue();
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