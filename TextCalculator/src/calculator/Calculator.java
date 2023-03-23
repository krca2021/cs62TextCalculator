package calculator;

import java.util.Scanner;

public class Calculator
{
    private Scanner scanner;
    private CalculatorMemory memory;
    private int top;
    
    private int checkTop() {
        this.top = this.memory.pop();
        this.memory.push(this.top);
        return this.top;
    }
    
    public void run() {
        this.scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number or operator:");
            final String str = this.scanner.nextLine();
            if (str.equals("pop")) {
                if (this.memory.size() == 0) {
                    System.out.println("Error: pop requires one argument \n");
                    System.out.println(this.memory.toString());
                }
                else {
                    System.out.println(this.memory.pop());
                    System.out.println(this.memory.toString());
                }
            }
            else if (str.equals("clear")) {
                this.memory.clear();
                System.out.println(this.memory.toString());
            }
            else if (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) {
                if (this.memory.size() > 1) {
                    if (str.equals("/") && this.checkTop() == 0) {
                        System.out.println("Error: divide by zero \n" + this.memory.toString());
                    }
                    else {
                        final int right = this.memory.pop();
                        final int left = this.memory.pop();
                        this.memory.push(Operation.performOperation(str.charAt(0), left, right));
                        System.out.println("Answer: " + Operation.performOperation(str.charAt(0), left, right));
                        System.out.println(this.memory.toString());
                    }
                }
                else {
                    System.out.println("Error: operator requires two arguments \n" + this.memory.toString());
                }
            }
            else if (str.equals("")) {
                System.out.println("Error: empty input");
            }
            else {
                if (str.equals("quit")) {
                    break;
                }
                try {
                    final int isNumber = Integer.parseInt(str);
                    this.memory.push(Integer.parseInt(str));
                }
                catch (Exception e) {
                    System.out.println("Error: expected number or operator");
                }
                System.out.println(this.memory.toString());
            }
        }
    }
    
    public Calculator() {
        this.memory = new CalculatorMemory();
    }
    
    public static void main(final String[] args) {
        final Calculator calc = new Calculator();
        calc.run();
    }
}
