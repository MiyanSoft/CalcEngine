package com.miyansoft.calcengine;

public class MathEquation {
    double leftVal;
    double rightVal;
    char opCode;
    double result;

    //provide average result of the calculations for all MathEquation instances in a way that's not tied to any instance of this class  using static members
    private static int numberOFCalculations;
    private static double sumOfResults;

    public MathEquation() { }

    public MathEquation(char opCode)    {
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftVal, double rightVal)   {
        this(opCode);
        this.leftVal = leftVal;
        this.rightVal = rightVal;


    }


    void execute()  {

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
        //keep count of the number of calculations executed as well as the total of all the results
        numberOFCalculations++;
        sumOfResults += result;

    }

    public static double getAverageResult(){
     return sumOfResults / numberOFCalculations;
    }

    public double getLeftVal() {
        return leftVal;
    }

    public void setLeftVal(double leftVal) {
        this.leftVal = leftVal;
    }

    public double getRightVal() {
        return rightVal;
    }

    public void setRightVal(double rightVal) {
        this.rightVal = rightVal;
    }

    public char getOpCode() {
        return opCode;
    }

    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }

    public double getResult() {
        return result;
    }

}
