import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class SOperations {

    Stack stack = new Stack();
    QOperations qOperations = new QOperations();


    public void readstack(String stackfile) {

        File file = new File(stackfile);

        try {

            Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name());

            while (sc.hasNextLine()) {

                String yigin = sc.nextLine();

                String yiginarray[] = yigin.split(" ");



                for (int i = 0; i < yiginarray.length; i++) {

                    int number = Integer.parseInt(yiginarray[i]);

                    stack.push(number);

                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void removeGreater(int k) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stackOut.txt" , true))) {

            String writing = "After removeGreater " + k + ":";
            writer.write(writing);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Stack stack1 = new Stack();
        int stack1length = 0;

        while (!stack.isEmpty()) {
            int value = stack.pop();

            if (k >= value) {

                stack1.push(value);

                stack1length += 1;

            }
        }

        // stack1den yazdırma ve stacke pushlama
        int i = 1;
        while (!stack1.isEmpty()) {

            int value = stack1.pop();

            stack.push(value);

            writeStack(i, value, stack1length);
            writeStackOut(i, value, stack1length);

            i += 1;


        }

    }

    public void calculateDistance(){

        ArrayList<Integer> distanceal = new ArrayList<Integer>();

        Stack stack1 = new Stack();

        while (!stack.isEmpty()) {
            int value = stack.pop();

            stack1.push(value);

            distanceal.add(value);
        }
        int totaldistance = 0;

        while (!stack1.isEmpty()) {
            int value = stack1.pop();
            stack.push(value);


            int distance = 0;

            for (int i = distanceal.size() -2; i >= 0; i--) {

                distance += Math.abs(value - distanceal.get(i));

            }
            totaldistance += distance;
            if (distanceal.size() > 1){
                distanceal.remove(distanceal.size() - 2);
            }

        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stackOut.txt" , true))) {

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

        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stackOut.txt" , true))) {

            String writing = "After addOrRemove " + number + ":";
            writer.write(writing);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }
        Stack stack1 = new Stack();
        int stack1length = 0;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            stack1.push(value);
            stack1length += 1;

        }

        if(number > 0) {

            for (int i = 0; i < number; i ++) {

                int random = (int )(Math.random() * 49 + 1 );

                stack1.push(random);
                stack1length += 1;
            }
        }
        else if(number < 0) {

            for (int i = 0; i > number ; i--) {

                stack1.pop();
                stack1length += -1;
            }
        }


        int i = 1;
        while (!stack1.isEmpty()) {

            int value = stack1.pop();

            stack.push(value);


            writeStack(i, value, stack1length);
            writeStackOut(i, value, stack1length);

            i += 1;
        }
    }

    public void writeStack(int i, int value, int stack1length) {


        if (i == 1) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stack.txt" , false))) {

                writer.write(String.valueOf(value) + " ");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (i == stack1length) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stack.txt", true))) {

                writer.write(String.valueOf(value));

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("stack.txt" , true))) {
                writer.write(String.valueOf(value) + " ");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    public void writeStackOut(int i, int value, int stack1length) {


        if (i == 1) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stackOut.txt" , true))) {

                writer.write(String.valueOf(value) + " ");

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (i == stack1length) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stackOut.txt", true))) {

                writer.write(String.valueOf(value));
                writer.newLine();

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("stackOut.txt" , true))) {
                writer.write(String.valueOf(value) + " ");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public void reverse(int k) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stackOut.txt" , true))) {

            String writing = "After reverse " + k + ":";
            writer.write(writing);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        while (!stack.isEmpty()) {
            int value = stack.pop();
            stack1.push(value);

        }

        for (int i = 0; i < k; i ++) {

            int value = stack1.pop();
            stack2.push(value);
        }

        while (!stack2.isEmpty()) {
            int value = stack2.pop();
            stack.push(value);

        }

        while (!stack1.isEmpty()) {
            int value = stack1.pop();
            stack.push(value);

        }

        int stack1length = 0;

        while (!stack.isEmpty()) {
            int value = stack.pop();
            stack1.push(value);
            stack1length += 1;
        }

        int i = 1;
        while (!stack1.isEmpty()) {

            int value = stack1.pop();

            stack.push(value);

            writeStack(i, value, stack1length);
            writeStackOut(i, value, stack1length);

            i += 1;
        }


    }

    public void sortElements() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stackOut.txt" , true))) {

            String writing = "After sortElements:";
            writer.write(writing);
            writer.newLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        Stack stack1 = new Stack();

        while (!stack.isEmpty()) {
            int value = stack.pop();
            stack1.push(value);

        }

        // Stack sorting
        while (!stack1.isEmpty()) {
            int value = stack1.pop();
            while(!stack.isEmpty() && value < stack.peek()) {
                stack1.push(stack.pop());
            }
            stack.push(value);
        }

        int stack1length = 0;

        while (!stack.isEmpty()) {
            int value = stack.pop();
            stack1.push(value);
            stack1length += 1;
        }

        int i = 1;
        while (!stack1.isEmpty()) {

            int value = stack1.pop();

            stack.push(value);

            writeStack(i, value, stack1length);
            writeStackOut(i, value, stack1length);

            i += 1;
        }




    }

    public void distinctElements() {

        Stack stack1 = new Stack();
        Stack stack2 = new Stack();

        while (!stack.isEmpty()) {
            int value = stack.pop();
            stack1.push(value);
            stack2.push(value);
        }

        // sorting
        while (!stack1.isEmpty()) {
            int value = stack1.pop();
            while(!stack.isEmpty() && value < stack.peek()) {
                stack1.push(stack.pop());
            }
            stack.push(value);
        }

        while (!stack.isEmpty()) {
            int value = stack.pop();
            stack1.push(value);

        }


        while (!stack1.isEmpty()) {
            int value = stack1.pop();

            if(stack.isEmpty()) {
                stack.push(value);
            }
            else if(!stack.isEmpty() && value != stack.peek()) {
                stack.push(value);
            }

        }

        int distinct = 0;
        while (!stack.isEmpty()) {
            int value = stack.pop();
            stack1.push(value);
            distinct += 1;

        }

        while (!stack2.isEmpty()) {
            int value = stack2.pop();
            stack.push(value);

        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter( "stackOut.txt" , true))) {

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

    public void writeOutput(String commandfile) {

        File file = new File(commandfile);

        readstack("stack.txt");
        qOperations.readqueue("queue.txt");

        try {

            Scanner sc = new Scanner(file, StandardCharsets.UTF_8.name());

            while (sc.hasNextLine()) {

                String lin = sc.nextLine();

                String line[] = lin.split(" ");

                if(line[0].equalsIgnoreCase("s")){

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
                else if (line[0].equalsIgnoreCase("Q")) {
                    if(line[1].equalsIgnoreCase("calculateDistance")){
                        qOperations.calculateDistance();

                    }
                    else if(line[1].equalsIgnoreCase("removeGreater")){
                        int k = Integer.parseInt(line[2]);
                        qOperations.removeGreater(k);

                    }
                    else if(line[1].equalsIgnoreCase("addOrRemove")){
                        int k = Integer.parseInt(line[2]);
                        qOperations.addOrRemove(k);

                    }
                    else if(line[1].equalsIgnoreCase("reverse")){
                        int k = Integer.parseInt(line[2]);
                        qOperations.reverse(k);

                    }
                    else if(line[1].equalsIgnoreCase("sortElements")){
                        qOperations.sortElements();

                    }
                    else if(line[1].equalsIgnoreCase("distinctElements")){
                        qOperations.distinctElements();

                    }
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}



