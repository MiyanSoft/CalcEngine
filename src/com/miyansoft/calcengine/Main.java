package com.miyansoft.calcengine;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        performCalculation();
    }

     static void performCalculation() {

        MathEquation[] equations = new MathEquation[4]; //creates 4 references of type MathEquation (each element of this array will create the instance of the MA class)
        equations[0] = create(100.0d, 50.0d, 'd');
        equations[1] = create(25.0d, 92.0d, 'a');
        equations[2] = create(225.0d, 17.0d, 's');
        equations[3] = create(11.0d, 3.0d, 'm');

        for(MathEquation equation: equations)   {
            equation.execute();
            System.out.println("result = " + equation.result);

        }

    }

    private static MathEquation create(double leftVals, double rightVals, char opCode) {
        MathEquation equation = new MathEquation(); //create new instance of ME class
        equation.leftVal = leftVals;
        equation.rightVal = rightVals;
        equation.opCode = opCode;
        return equation;                            //returns the reference of the newly created ME class
    }

}
