package NodeBasedStack;

public class Stack {
    Node top;
    int currentSize;

    Stack() {
        top = null;
        currentSize = 0;
    }


    void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        currentSize++;
    }

    int pop() throws StackUnderFlowException {
        if (isEmpty()) {
            throw new StackUnderFlowException("Stack is Empty");
        } else {
            int ans = top.data;
            top = top.next;
            return ans;
        }
    }

    int peek() throws StackUnderFlowException {
        if (isEmpty()) {
            throw new StackUnderFlowException("Stack is Empty");
        } else {
            return top.data;
        }
    }

    boolean isEmpty() {
        return top == null;
    }

    void clear() {
        top = null;
    }
}
