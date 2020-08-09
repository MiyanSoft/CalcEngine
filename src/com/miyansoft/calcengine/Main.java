package com.miyansoft.calcengine;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        //these are parallel arrays i.e the element in each array are meant to be used with the corresponding element in each of the other arrays
        //i.e each member of the first array belongs to one another (100.0d / 50.0d) the result will be stored in the first member of the result array, e.t.c.
        double[] leftVals = {100.0d, 25.0d, 225.0d, 11.0d};
        double[] rightVals = {50.0d, 92.0d, 17.0d, 3.0d};
        char[] opCodes = {'d', 'a', 's', 'm'};
        double[] results = new double[opCodes.length];

        //check for command-line argument
        if (args.length == 0)	{
            for (int i = 0; i < opCodes.length; i++)	{
                results[i] = execute(opCodes[i], leftVals[i], rightVals[i]);

            }

            for (double currentResult : results)
                System.out.println(currentResult);

        }	else if (args.length == 1 && args[0].equals("interactive"))
            executeInteractively();
        else if(args.length == 3)
            handleCommandLine(args);
        else
            System.out.println("Please provide an operation code and 2 numeric values");
    }


    static void executeInteractively()	{
        System.out.println("Enter an operation and two numbers:");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }


    private static void performOperation(String[] parts) {
        char opCode = opCodeFromString(parts[0]);
        if(opCode == 'w')
            handleWhen(parts);
        else {
            double leftVal = valueFromWord(parts[1]);
            double rightVal = valueFromWord(parts[2]);
            double result = execute(opCode, leftVal, rightVal);
            displayResult(opCode, leftVal, rightVal, result);
        }
    }

    private static void handleWhen(String[] parts) {
        // parse the string value typed in by the user and translate it into an instance of LocalDate and assign it to the declared variable
        LocalDate startDate = LocalDate.parse(parts[1]);
        //get number of days that user wants to add. valueFromWord() returns double so there's need for explicit casting
        long daysToAdd = (long) valueFromWord(parts[2]);
        //plusDays() is used to perform the date arithmetic
        LocalDate newDate = startDate.plusDays(daysToAdd);
        String output = String.format("%s plus %d days is %s", startDate, daysToAdd, newDate);	//daysToAdd is a long data type (%d)
        System.out.println(output);
    }

    private static void displayResult(char opCode, double leftVal, double rightVal, double result) {
        //translate opCode into symbol
        char symbol = symbolFromOpCode(opCode);
        //create string builder instance
    /**		StringBuilder builder = new StringBuilder(20);
     builder.append(leftVal);
     builder.append(" ");
     builder.append(symbol);
     builder.append(" ");
     builder.append(rightVal);
     builder.append(" = ");
     builder.append(result);
     String output = builder.toString(); */ //format class will be used instead

        //.3 implies that the values should be in 3 decimal places
        String output = String.format("%.3f %c %.3f = %.3f", leftVal, symbol, rightVal, result);
        System.out.println(output);

    }

    //translate opcode into appropriate mathematical symbol
    private static char symbolFromOpCode(char opCode)	{
        char[] opCodes = {'a', 's', 'm', 'd'};
        char[] symbols = {'+', '-', '*', '/' };
        char symbol = ' ';
        for(int index = 0; index < opCodes.length; index++)	{
            if(opCode == opCodes[index])	{
                symbol = symbols[index];
                break;
            }

        }

        return symbol;
    }
    private static void handleCommandLine(String[] args) {
        // convert string representation of character to char rep. of character
        char opCode = args[0].charAt(0);
        //convert sequence of characters into double using the parseDouble()
        //args[1] convert string representation of our numbers to double
        double leftVal = Double.parseDouble(args[1]);
        double rightVal = Double.parseDouble(args[2]);
        double result = execute(opCode, leftVal, rightVal);
        System.out.println(result);
    }

    static double execute(char opCode, double leftVal, double rightVal)	{
        double result;
        switch(opCode)	{
            case 'a':
                result= leftVal + rightVal;
                break;
            case 's':
                result = leftVal - rightVal;
                break;
            case 'm':
                result = leftVal * rightVal;
                break;
            case 'd':
                //if value2 is not 0, divide v1 by v2. else result should be 0.0
                result = rightVal != 0 ? leftVal / rightVal : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode" + opCode);
                result = 0.0d;
                break;
        }
        return result;
    }

    static char opCodeFromString(String operationName)	{
        char opCode = operationName.charAt(0);
        return opCode;
    }
    //receives string values and convert it to it's appropriate equivalent
    static double valueFromWord(String word)	{
        //arrays of numeric words
        String[] numberWords = {
                "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
        };
        double value = -1d;	//set to -1 instead of 0 which makes value to be invalid
        for(int index = 0; index < numberWords.length; index++)	{	//match up number word typed in by user
            if(word.equals(numberWords[index]))	{	//after finding the matching word, assign its index to 'value', and return it
                value = index;
                break;

            }
        }

        //if the string received  is not understood, parse such number out of the string and since this method returns double,
        //Double wrapper class is used and its result is assign to value . . . (accept numeric values in addition to string)

        if(value == -1d)
            value = Double.parseDouble(word);

        return value;

    }
}
