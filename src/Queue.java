public class Queue {

    private int[] queueArray;
    private int queueSize;
    private int front;
    private int rear;
    private int numberOfItems;

    public Queue() {
        queueSize = 100;
        queueArray = new int[queueSize];
        front = 0;
        rear = -1;
        numberOfItems = 0;
    }

    public boolean enqueue(int item) {
        if (!isFull()) {
            rear++;
            queueArray[rear] = item;
            numberOfItems++;
            return true;
        }else {

            return false;
        }

    }
    public int dequeue() {

        if(!isEmpty()) {

            numberOfItems--;
            return queueArray[front++];
        }
        else {
            return -10;

        }

    }

    public int peek() {

        return queueArray[front];

    }
    public int size(){
        return numberOfItems;
    }

    public boolean isEmpty() {

        return (size() == 0);
    }

    public boolean isFull(){

        return (size() == queueSize);
    }


}
