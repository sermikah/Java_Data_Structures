import NodeBasedStack.*;

public class MaxStack {
    Stack main;
    Stack maxStack;

    MaxStack() {
        maxStack=new Stack();
        main=new Stack();
    }

    int getMax() throws StackUnderFlowException{
        return maxStack.isEmpty() ? Integer.MIN_VALUE : maxStack.peek();
    }

    void push(int data) throws StackUnderFlowException{
        /*
            1-main stack'e pushla
            2-maxStack boş ise yada maxStack'in peek elementi data'dan küçükse maxStacke data'yı ekle
        */
        main.push(data);
        if(maxStack.isEmpty() || maxStack.peek()<data){
            maxStack.push(data);
        }
    }

    void pop() throws StackUnderFlowException{
        // main stack'ten pop yap ve bir değişkende pop edilen elementi sakla
        // eğer MaxStackin peeki eşit ise maxStacke pop yap
        int data= main.pop();
        if(maxStack.peek()==data){
            maxStack.pop();
        }
    }
}

