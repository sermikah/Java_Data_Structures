package NodeBasedStack;

public class Stack {
    Node top;
    int currentSize;

    public Stack() {
        top = null;
        currentSize = 0;
    }


    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        currentSize++;
    }

    public int pop() throws StackUnderFlowException {
        if (isEmpty()) {
            throw new StackUnderFlowException("Stack is Empty");
        } else {
            int ans = top.data;
            top = top.next;
            return ans;
        }
    }

    public int peek() throws StackUnderFlowException {
        if (isEmpty()) {
            throw new StackUnderFlowException("Stack is Empty");
        } else {
            return top.data;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void clear() {
        top = null;
    }
}
