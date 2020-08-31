import java.util.*;

class Batch {
    int numStudents;
    int slowLearners;
    int numTutors;
    int[] tutors;
    boolean allEqualToFour = true;

    Batch(int numStudents, int slowLearners) {
        this.numStudents = numStudents;
        this.slowLearners = slowLearners;
        this.numTutors = (slowLearners / 4) + ((slowLearners % 4 != 0) ? 1 : 0);
        tutors = new int[numTutors];
        for (int i = 0; i < (slowLearners / 4); i++) {
            tutors[i] = 4;
        }
        if (slowLearners % 4 != 0) {
            tutors[tutors.length - 1] = slowLearners % 4;
            this.allEqualToFour = false;
        }
    }
}

public class labDa1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of batches : ");
        int numBatches = sc.nextInt();
        int tutors[][] = new int[numBatches][];
        int numBatchesWithAllFour = 0;

        // Get the details of batches and compute the tutors
        for (int i = 0; i < numBatches; i++) {
            System.out.printf("Enter the number of students in batch %d : ", i+1);
            int numStudents = sc.nextInt();
            System.out.printf("Enter the number of slow learners in batch %d : ", i+1);
            int slowLearners = sc.nextInt();
            Batch currentBatch = new Batch(numStudents, slowLearners);
            numBatchesWithAllFour = (currentBatch.allEqualToFour) ? numBatchesWithAllFour+1 : numBatchesWithAllFour;
            tutors[i] = currentBatch.tutors;
        }

        // Print results use for each
        System.out.println("\nBatch wise tutor allocation details");
        for (int[] batchTutors : tutors) {
            System.out.println(Arrays.toString(batchTutors));
        }

        // Print the number of batches with all tutors having four students
        System.out.printf("Number of batches with all tutors having four students : %d\n",numBatchesWithAllFour);

        sc.close();

    }

}
