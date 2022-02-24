public class Stack {

    private int[] stack;
    private int top;
    private int size;

    public Stack() {
        top = -1;
        size = 100;
        stack = new int[100];

    }

    public boolean push(int item) {
        if (!isFull()) {
            top++;
            stack[top] = item;
            return true;
        }else {

            return false;
        }
    }

    public boolean isFull() {
        return (top == stack.length -1);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int pop() {

        if(!isEmpty()) {

            return stack[top--];
        }
        else {
            return -10;

        }
    }

    public int peek() {

        return stack[top];
    }


}
