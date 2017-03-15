package day8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sshek8 on 8/20/2016.
 */
public class Main {
    public static void main(String[] args) {
        List<Junction> junctions = new ArrayList<>();
        LinkedList<Junction> junctionLinkedList = new LinkedList<>();
        Scanner scan = new Scanner(System.in);
        int junctionCount = Integer.parseInt(scan.nextLine());
        int queueCount = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < queueCount; i++) {
            String[] strings = scan.nextLine().split(" ");
            int startQueue = Integer.parseInt(strings[0]);
            int endQueue = Integer.parseInt(strings[1]);
            int personInQueue = Integer.parseInt(strings[2]);
            junctions.add(new Junction(new Queue(startQueue, endQueue), personInQueue));
            junctionLinkedList.clear();
        }
        scan.close();
        System.out.println(junctions);

        // List<Junction> startingJunctions = getStartingJunctions(junctions);


    }

//    private static List<Junction> getStartingJunctions(final List<Junction> junctions) {
//
//        for(Junction jn : junctions){
//
//        }
//    }
}


class Queue {
    private final int startJunction;
    private final int endJunction;

    public Queue(int startJunction, int endJunction) {
        this.startJunction = startJunction;
        this.endJunction = endJunction;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "startJunction=" + startJunction +
                ", endJunction=" + endJunction +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Queue)) return false;

        Queue queue = (Queue) o;

        if (startJunction != queue.startJunction) return false;
        return endJunction == queue.endJunction;

    }

    @Override
    public int hashCode() {
        int result = startJunction;
        result = 31 * result + endJunction;
        return result;
    }

    public int getStartJunction() {
        return startJunction;
    }

    public int getEndJunction() {
        return endJunction;
    }
}

class Junction {
    private final Queue queue;
    private final int personCount;

    public Junction(Queue queue, int personCount) {
        this.queue = queue;
        this.personCount = personCount;
    }

    @Override
    public String toString() {
        return "\nJunction{" +
                "queue=" + queue +
                ", personCount=" + personCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Junction)) return false;

        Junction junction = (Junction) o;

        if (personCount != junction.personCount) return false;
        return !(queue != null ? !queue.equals(junction.queue) : junction.queue != null);

    }

    @Override
    public int hashCode() {
        int result = queue != null ? queue.hashCode() : 0;
        result = 31 * result + personCount;
        return result;
    }

    public Queue getQueue() {
        return queue;
    }

    public int getPersonCount() {
        return personCount;
    }
}