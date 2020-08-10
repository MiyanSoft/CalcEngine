package com.miyansoft.calcengine;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        performCalculation();
    }

     static void performCalculation() {

        MathEquation[] equations = new MathEquation[4]; //creates 4 references of type MathEquation (each element of this array will create the instance of the MA class)
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);

        for(MathEquation equation: equations)   {
            equation.execute();
            System.out.println("result = " + equation.result);

        }
        System.out.println("Average result = " + MathEquation.getAverageResult());  //since getAverageResult is a static method, it's been accessed using MathEquation classname

    }



}
