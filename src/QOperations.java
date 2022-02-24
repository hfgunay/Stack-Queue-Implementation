import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class QOperations {

    Queue queue = new Queue();

    public void readqueue(String queuefile) {
        File file = new File(queuefile);

        try {

            Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name());

            while (sc.hasNextLine()) {

                String yigin = sc.nextLine();

                String yiginarray[] = yigin.split(" ");



                for (int i = 0; i < yiginarray.length; i++) {

                    int number = Integer.parseInt(yiginarray[i]);

                    queue.enqueue(number);

                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public void writeStacksOutput(String commandfile) { // geçici, SOperations a taşınacak

        File file = new File(commandfile);

        readqueue("queue.txt");

        try {

            Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name());

            while (sc.hasNextLine()) {

                String lin = sc.nextLine();

                String line[] = lin.split(" ");

                if(line[0].equalsIgnoreCase("Q")){

                    if(line[1].equalsIgnoreCase("calculateDistance")){
                        calculateDistance();

                    }
                    else if(line[1].equalsIgnoreCase("removeGreater")){
                        int k = Integer.parseInt(line[2]);
                        removeGreater(k);

                    }
                    else if(line[1].equalsIgnoreCase("addOrRemove")){
                        int k = Integer.parseInt(line[2]);
                        addOrRemove(k);

                    }
                    else if(line[1].equalsIgnoreCase("reverse")){
                        int k = Integer.parseInt(line[2]);
                        reverse(k);

                    }
                    else if(line[1].equalsIgnoreCase("sortElements")){
                        sortElements();

                    }
                    else if(line[1].equalsIgnoreCase("distinctElements")){
                        distinctElements();

                    }

                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    public void writeQueue(int i, int value, int queue1length) {


        if (i == 1) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queue.txt" , false))) {

                writer.write(String.valueOf(value) + " ");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (i == queue1length) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queue.txt", true))) {

                writer.write(String.valueOf(value));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("queue.txt" , true))) {
                writer.write(String.valueOf(value) + " ");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    public void writeQueueOut(int i, int value, int stack1length) {


        if (i == 1) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queueOut.txt" , true))) {

                writer.write(String.valueOf(value) + " ");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (i == stack1length) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queueOut.txt", true))) {

                writer.write(String.valueOf(value));
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("queueOut.txt" , true))) {
                writer.write(String.valueOf(value) + " ");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void removeGreater(int k) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queueOut.txt" , true))) {

            String writing = "After removeGreater " + k + ":";
            writer.write(writing);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // en üst

        Queue queue1 = new Queue();
        int queue1length = 0;
        while (!queue.isEmpty()) {

            int value = queue.dequeue();

            if (k >= value){
                queue1.enqueue(value);
                queue1length += 1;
            }
        }

        int i = 1;
        while (!queue1.isEmpty()){
            int value = queue1.dequeue();

            queue.enqueue(value);
            writeQueue(i,value,queue1length);
            writeQueueOut(i,value,queue1length);

            i += 1;

        }



    }

    public void calculateDistance(){

        ArrayList<Integer> distanceal = new ArrayList<Integer>();
        Queue queue1 = new Queue();

        while (!queue.isEmpty()) {
            int value = queue.dequeue();

            queue1.enqueue(value);

            distanceal.add(value);
        }

        int totaldistance = 0;

        while (!queue1.isEmpty()) {
            int value = queue1.dequeue();
            queue.enqueue(value);


            int distance = 0;

            for (int i = 0; i < distanceal.size(); i ++) {

                distance += Math.abs(value - distanceal.get(i));

            }
            totaldistance += distance;
            distanceal.remove(0);


        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queueOut.txt" , true))) {

            String writing = "After calculateDistance:";
            writer.write(writing);
            writer.newLine();
            String writing1 = "Total distance=" + totaldistance;
            writer.write(writing1);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void addOrRemove(int number){

        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queueOut.txt" , true))) {

            String writing = "After addOrRemove " + number + ":";
            writer.write(writing);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // en üst

        Queue queue1 = new Queue();
        int queue1length = 0;
        while (!queue.isEmpty()) {

            int value = queue.dequeue();

            queue1.enqueue(value);
            queue1length += 1;

        }


        if(number > 0) {

            for (int i = 0; i < number; i ++) {

                int random = (int )(Math.random() * 49 + 1 );

                queue1.enqueue(random);
                queue1length += 1;
            }
        }
        else if(number < 0) {

            for (int i = 0; i > number ; i--) {

                queue1.dequeue();
                queue1length += -1;
            }
        }


        int i = 1;
        while (!queue1.isEmpty()) {

            int value = queue1.dequeue();

            queue.enqueue(value);


            writeQueue(i, value, queue1length);
            writeQueueOut(i, value, queue1length);

            i += 1;
        }

    }

    public void reverse(int k) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queueOut.txt" , true))) {

            String writing = "After reverse " + k + ":";
            writer.write(writing);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // en üstte bu var

        Stack stack1 = new Stack();
        Queue queue1 = new Queue();

        for (int i = 0; i < k; i ++) {

            int value = queue.dequeue();
            stack1.push(value);
        }
        while (!queue.isEmpty()) {

            int value = queue.dequeue();

            queue1.enqueue(value);

        }

        int queue1length = 0;
        while (!stack1.isEmpty()) {

            int value = stack1.pop();

            queue.enqueue(value);
            queue1length += 1;

        }

        while (!queue1.isEmpty()) {

            int value = queue1.dequeue();
            queue.enqueue(value);
            queue1length += 1;
        }

        while (!queue.isEmpty()) {

            int value = queue.dequeue();
            queue1.enqueue(value);

        }
        int i = 1;
        while (!queue1.isEmpty()) {

            int value = queue1.dequeue();
            queue.enqueue(value);
            writeQueue(i, value, queue1length);
            writeQueueOut(i, value, queue1length);

            i += 1;

        }


    }

    public void sortElements() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queueOut.txt" , true))) {

            String writing = "After sortElements:";
            writer.write(writing);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // en üstte bu var

        Queue queue1 = new Queue();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();


        int queue1length = 0;
        while (!queue.isEmpty()) {

            int value = queue.dequeue();
            queue1.enqueue(value);
            queue1length += 1;
        }

        while (!queue1.isEmpty()) {
            int value = queue1.dequeue();
            while(!stack1.isEmpty() && value < stack1.peek()) {
                queue1.enqueue(stack1.pop());
            }
            stack1.push(value);
        }

        while (!stack1.isEmpty()) {

            int value = stack1.pop();
            stack2.push(value);

        }
        while (!stack2.isEmpty()) {

            int value = stack2.pop();
            queue1.enqueue(value);

        }
        // queue1 sortlu

        int i = 1;
        while (!queue1.isEmpty()) {

            int value = queue1.dequeue();
            queue.enqueue(value);
            writeQueue(i, value, queue1length);
            writeQueueOut(i, value, queue1length);

            i += 1;
        }


    }

    public void distinctElements() {






        Queue queue1 = new Queue();
        Queue queue2 = new Queue();
        Stack stack1 = new Stack();
        Stack stack2 = new Stack();



        while (!queue.isEmpty()) {

            int value = queue.dequeue();
            queue1.enqueue(value);
            queue2.enqueue(value);

        }

        while (!queue1.isEmpty()) {
            int value = queue1.dequeue();
            while(!stack1.isEmpty() && value < stack1.peek()) {
                queue1.enqueue(stack1.pop());
            }
            stack1.push(value);
        }

        while (!stack1.isEmpty()) {

            int value = stack1.pop();
            stack2.push(value);

        }
        while (!stack2.isEmpty()) {

            int value = stack2.pop();
            queue1.enqueue(value);

        }
        // sortlu queue1
        int distinct = 0;
        while(!queue1.isEmpty()) {
            int value = queue1.dequeue();
            if (value != queue1.peek()){
                distinct += 1;
            }
        }

        // en altta bu var
        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "queueOut.txt" , true))) {

            String writing = "After distinctElements:";
            writer.write(writing);
            writer.newLine();
            String writing2 = "Total distinct element=" + distinct;
            writer.write(writing2);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}


