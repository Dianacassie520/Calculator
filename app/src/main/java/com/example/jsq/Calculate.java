package com.example.jsq;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class Calculate {
    String expr;
    ArrayList<Object> suffixExpr= new ArrayList<>();

    public static void main(String[] args){
        Calculate c = new Calculate("(3+5)/2");
        System.out.println(c.suffix());
    }

    public Calculate(String expr){
        this.expr = expr + "#";
    }

    public boolean isLegal(){
        for(int i=0;i<expr.length()-1;i++){
            if(!isNumeric(expr.charAt(i))&&!isNumeric(expr.charAt(i+1))&&((expr.charAt(i)!='(' && expr.charAt(i)!=')')&&(expr.charAt(i+1)!='(' && expr.charAt(i+1)!=')')))
                return false;
        }
        return true;
    }

    public String suffix(){
        Stack<Character> operator = new Stack<>();
        boolean isNum = false;
        boolean isFloat = false;
        int floatNum = 0;
        operator.push('#');
        for(int i=0;i<expr.length();i++){
            if(isNumeric(expr.charAt(i))){
                double num = Double.parseDouble(expr.charAt(i)+"");
                if(isNum){
                    double lastNum = (double)suffixExpr.get(suffixExpr.size()-1);
                    suffixExpr.set(suffixExpr.size()-1,lastNum*10+num);
                }
                else if(isFloat){
                    floatNum -- ;
                    num *= Math.pow(10,floatNum);
                    double lastNum = (double)suffixExpr.get(suffixExpr.size()-1);
                    suffixExpr.set(suffixExpr.size()-1,lastNum+num);
                }
                else {
                    suffixExpr.add(Double.parseDouble(expr.charAt(i) + ""));
                    isNum = true;
                }
            }
            else{
                isNum = false;
                if(expr.charAt(i)=='.')
                    isFloat = true;
                else{
                    isNum=false;
                    isFloat=false;
                    floatNum=0;
                    switch(expr.charAt(i)){
                        case '(':
                            operator.push(expr.charAt(i));
                            break;
                        case ')':
                            char top=operator.pop();
                            while (top!='('){
                                suffixExpr.add(top);
                                top=operator.pop();
                            }
                            break;
                        default:
                            char top1 = operator.peek();
                            if(op(top1)<op(expr.charAt(i))){
                                operator.push(expr.charAt(i));
                            }
                            else{
                                if(top1 == '#')
                                    operator.pop();
                                else{
                                    top=operator.pop();
                                    suffixExpr.add(top);
                                    i--;
                                }
                            }
                    }
                }

            }
        }
        String suffixE = "";
        Iterator<Object> it = suffixExpr.iterator();
        while(it.hasNext()){
            suffixE+=it.next()+"";
        }
        return suffixE;
    }

    public double getResult(){
        double result;
        suffix();
        Stack<Double> calculate = new Stack<>();
        Iterator<Object> it = suffixExpr.iterator();
        while (it.hasNext()){
            Object e = it.next();
            if(e instanceof Double){
                calculate.push((double)e);
            }
            else{
                double num1 = calculate.pop();
                double num2 = calculate.pop();
                double resultTemp = Calculate((char)e,num1,num2);
                calculate.push(resultTemp);
            }
        }
        result = calculate.peek();
        return result;
    }

    //设置符号的运算符的优先级用数字表示，左括号直接入栈
    //#  +  -  *  /  (
    //-1 1  1  2  2  0

    public int op(char operator){
        if(operator == '#')
            return -1;
        else if(operator == '+' || operator == '-')
            return 1;
        else if(operator == '*' || operator == '/')
            return 2;
        else
            return 0;
    }

    public boolean isNumeric(char character){
        if(character <= '9' && character >= '0')
            return true;
        else
            return false;
    }

    public double Calculate(char op, double num1,double num2){
        double resultTemp = 0;
        switch (op){
            case '+':
                resultTemp = num2 + num1;
                break;
            case '-':
                resultTemp = num2 - num1;
                break;
            case '*':
                resultTemp = num2 * num1;
                break;
            case '/':
                resultTemp = num2 / num1;
                break;
        }
        return resultTemp;
    }
}
