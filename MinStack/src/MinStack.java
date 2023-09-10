import NodeBasedStack.*;

public class MinStack {
    Stack main;
    Stack minStack;

    MinStack(){
        main = new Stack();
        minStack = new Stack();
    }

    void push(int data) throws StackUnderFlowException {
        main.push(data);
        if(minStack.isEmpty() || minStack.peek() > data){
            minStack.push(data);
        }
    }

    void pop() throws StackUnderFlowException{
        int poppedData = main.pop();
        if(!minStack.isEmpty() && minStack.peek() == poppedData){
            minStack.pop();
        }
    }

    int getMin() throws StackUnderFlowException{
        return minStack.isEmpty() ? Integer.MIN_VALUE:minStack.peek();
    }
}
