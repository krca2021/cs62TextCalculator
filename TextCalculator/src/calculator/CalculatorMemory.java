package calculator;

import java.util.LinkedList;

public class CalculatorMemory
{
    private LinkedList<Integer> stack;
    
    public CalculatorMemory() {
        this.stack = new LinkedList<Integer>();
    }
    
    public void push(final int number) {
        this.stack.push(number);
    }
    
    public int pop() {
        return this.stack.removeFirst();
    }
    
    public boolean isEmpty() {
        return this.stack.size() == 0;
    }
    
    public int size() {
        return this.stack.size();
    }
    
    public void clear() {
        this.stack.clear();
    }
    
    @Override
    public String toString() {
        String stackstr = "\nMemory contents: \n";
        final LinkedList<Integer> stackCopy = this.stack;
        for (int i = 0; i < stackCopy.size(); ++i) {
            stackstr = String.valueOf(stackstr) + stackCopy.get(i) + "\n";
        }
        stackstr = String.valueOf(stackstr) + "--- \n";
        return stackstr;
    }
}