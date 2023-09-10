import NodeBasedStack.StackUnderFlowException;

public class Main {
    public static void main(String[] args) throws StackUnderFlowException {
        MinStack minStack = new MinStack();
        MaxStack maxStack = new MaxStack();

        minStack.push(6);
        maxStack.push(6);
        System.out.println("MIN: " + minStack.getMin());
        System.out.println("MAX: " + maxStack.getMax());
        System.out.println();

        minStack.push(7);
        maxStack.push(7);
        System.out.println("MIN: " + minStack.getMin());
        System.out.println("MAX: " + maxStack.getMax());
        System.out.println();

        minStack.push(8);
        maxStack.push(8);
        System.out.println("MIN: " + minStack.getMin());
        System.out.println("MAX: " + maxStack.getMax());
        System.out.println();

        minStack.push(5);
        maxStack.push(5);
        System.out.println("MIN: " + minStack.getMin());
        System.out.println("MAX: " + maxStack.getMax());
        System.out.println();

        minStack.push(3);
        maxStack.push(3);
        System.out.println("MIN: " + minStack.getMin());
        System.out.println("MAX: " + maxStack.getMax());
        System.out.println();

        minStack.pop();
        maxStack.pop();
        System.out.println("MIN: " + minStack.getMin());
        System.out.println("MAX: " + maxStack.getMax());
        System.out.println();

        minStack.push(10);
        maxStack.push(10);
        System.out.println("MIN: " + minStack.getMin());
        System.out.println("MAX: " + maxStack.getMax());
        System.out.println();

        minStack.pop();
        maxStack.pop();
        System.out.println("MIN: " + minStack.getMin());
        System.out.println("MAX: " + maxStack.getMax());
        System.out.println();

        minStack.pop();
        maxStack.pop();
        System.out.println("MIN: " + minStack.getMin());
        System.out.println("MAX: " + maxStack.getMax());

    }
}
