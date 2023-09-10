package ArrayBasedStack;

public class Stack {
    private int[] stack;
    private final int capacity;
    private int currentSize;
    private int top;

    Stack(int capacity){
        this.capacity = capacity;
        this.stack = new int[capacity];
        this.currentSize = 0;
        this.top = -1;
    }

    /*
    The operations work as follows:

         Yığındaki en üst öğeyi takip etmek için TOP adlı bir işaretçi kullanılır.
         Yığını başlatırken, TOP == -1'i karşılaştırarak yığının boş olup olmadığını kontrol edebilmemiz için değerini -1 olarak ayarladık.
         Bir elemanı iterken TOP'un değerini artırıyoruz ve yeni elemanı TOP'un gösterdiği konuma yerleştiriyoruz.
         Bir elemanı popladığımızda, TOP ile işaret edilen elemanı döndürür ve top değerini düşürürüz.
         Basmadan önce, yığının zaten dolu olup olmadığını kontrol ederiz
         Patlamadan önce, yığının boş olup olmadığını kontrol ederiz.
    */

    void push(int data) throws StackOverflowException{
        if(isFull())
            throw new StackOverflowException("Stack is full!");
        stack[++top]=data;
        currentSize++;
    }

    int pop() throws StackUnderflowException{
        if(isEmpty())
            throw new StackUnderflowException("Stack is empty!");
        currentSize--;
        return stack[top--];
    }

    int peek() throws StackUnderflowException{
        if(isEmpty())
            throw new StackUnderflowException("Stack is empty!");
        return stack[top];

    }

    int size(){
        return currentSize;
    }

    boolean isEmpty(){
        return top == -1;
    }

    boolean isFull(){
        return capacity-1 == top;
    }
}
