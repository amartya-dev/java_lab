import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

class CountVotes implements Runnable {
    int [] votes;
    int start, end;
    int counts [];

    CountVotes(int [] votes, int start, int end, int numStudents) {
        this.votes = votes;
        this.start = start;
        this.end = end;
        this.counts = new int [numStudents];
    }

    public void run () {
        for (int i = start; i < end; i++){
            counts[votes[i]-1] += 1;
        }
    }
}

public class multiThreading {

    public static int [] generateVotes(int n, int numStudents){
        int [] votes = new int [n];
        ArrayList<Integer> students = new ArrayList<Integer>();
        Random random = new Random();

        // Create the list of students to chose from
        for (int student = 0; student < numStudents; student++){
            students.add(student+1);
        }

        // Randomly generate votes
        for (int i = 0; i < n; i++){
            votes[i] = students.get(random.nextInt(students.size()));
        }

        return votes;
    }

    public static void main(String[] args) {
        // Generate 240 random votes for three students
        int [] votes = generateVotes(240, 3);

        // Create 4 threads for counting different parts of the array
        CountVotes counter1 = new CountVotes(votes, 0, 61, 3);
        CountVotes counter2 = new CountVotes(votes, 61, 121, 3);
        CountVotes counter3 = new CountVotes(votes, 121, 181, 3);
        CountVotes counter4 = new CountVotes(votes, 181, 240, 3);

        Thread t1 = new Thread(counter1);
        Thread t2 = new Thread(counter2);
        Thread t3 = new Thread(counter3);
        Thread t4 = new Thread(counter4);

        // Start all threads
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        int [] finalCounts = new int [3];

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }
        catch (Exception ex){
            System.out.println("Error encountered : " + ex + "\n");
        }

        synchronized(finalCounts){
            for (int i = 0; i < 3; i++){
                finalCounts[i] += counter1.counts[i] + counter2.counts[i] + counter3.counts[i] + counter4.counts[i];
            }
        }

        System.out.println(Arrays.toString(finalCounts));
    }
}
