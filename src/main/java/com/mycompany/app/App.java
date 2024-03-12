package com.mycompany.app;

public class App 
{
    public static void main( String[] args )
    {

    }

    static String[] massProcess(Integer[] box1, Integer[] box2, String operation, String displayMode) throws Exception{
        String result[] = new String[box1.length];
        for(int i = 0; i<box1.length;i++){
            double num1 = (double)box1[i];
            if(i >= box2.length){
                result[i] = "";
                continue;
            }
            double num2 = (double)box2[i];
            double numResult = 0.0;
            switch (operation) {
                case "Add":
                numResult = num1 + num2;
                case "Substract":
                numResult = num1 - num2;
                case "Multiply":
                numResult = num1 * num2;
                case "Divide":
                numResult = num1 / num2;
                    break;
                default:
                throw new Exception("Invalid Operation");
            }
            switch (displayMode) {
                case "Fractional":
                result[i] = String.format("%.3",numResult);
                case "Round":
                result[i] = "" + (int)Math.round(numResult);
                case "Round Down":
                result[i] = "" + (int)Math.floor(numResult);
                case "Round Up":
                result[i] = "" + (int)Math.ceil(numResult);
                case "Scientific":
                result[i] = String.format("%.3e",numResult);
                    break;
                default:
                throw new Exception("Invalid Display Mode");
            }
            
        }
        return result;
    }
}