package NodeBasedQueue;

public class Queue {
    Node front;
    Node rear;
    int currentSize;

    Queue() {
        front = null;
        rear = null;
        currentSize = 0;
    }

    public void enqueue(int data) {
        Node node = new Node(data);

        if (isEmpty()) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = rear.next;
        }

        currentSize++;
    }

    public int dequeue() throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is Empty!");
        }
        if(rear==front){
            rear = null;
        }

        int temp=front.data;
        front=front.next;
        currentSize--;
        return temp;

    }

    public int peek()throws QueueUnderflowException {
        if(isEmpty()){
            throw new QueueUnderflowException("Queue is Empty!");
        }
        return front.data;

    }

    public int size(){
        return currentSize;

    }

    public boolean isEmpty() {
        return rear == null && front == null;
    }
}
