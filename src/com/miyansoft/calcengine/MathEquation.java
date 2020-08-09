package com.miyansoft.calcengine;

public class MathEquation {
    double leftVal;
    double rightVal;
    char opCode;
    double result;

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
    }
}
