package ArrayBasedStack;

public class StackUnderflowException extends Exception {
    StackUnderflowException(String message){
        super(message);
    }
}
