package ArrayBasedQueue;

public class Queue {
    int[] queue;
    int front;
    int rear;
    int currentSize;
    int capacity;

    Queue(int capacity) {
        this.capacity = capacity;
        this.currentSize = 0;
        this.front = -1;
        this.rear = -1;
        queue = new int[capacity];
    }

    void enqueue(int data) throws QueueOverflowException {
        if (isFull()) {
            throw new QueueOverflowException("Queue is full!");
        }
        if (isEmpty()) {
            front = 0;
        }
        rear++;
        queue[rear] = data;
        currentSize++;
    }

    /*

    Working of Queue
        Queue operations work as follows:
        * two pointers FRONT and REAR
        * FRONT track the first element of the queue
        * REAR track the last element of the queue
        * initially, set value of FRONT and REAR to -1

        Enqueue Operation
        * check if the queue is full
        * for the first element, set the value of FRONT to 0
        * increase the REAR index by 1
        * add the new element in the position pointed to by REAR

        Dequeue Operation
        * check if the queue is empty
        * return the value pointed by FRONT
        * increase the FRONT index by 1
        * for the last element, reset the values of FRONT and REAR to -1
     */

    int dequeue() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty!");
        }
        int data = queue[front];
        if(front == rear){
            front = -1;
            rear = -1;
        }
        else{
            front++;
        }
        currentSize--;
        return data;
    }

    int peek() throws QueueUnderflowException {
        if (isEmpty()) {
            throw new QueueUnderflowException("Queue is empty!");
        }
        return queue[front];

    }

    int size() {
        return currentSize;

    }

    public boolean isEmpty() {
        return front == -1 && rear == -1;
    }

    boolean isFull() {
        return currentSize == capacity;
    }
}
