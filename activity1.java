import java.util.*;
//activity 1
//question 1

public class activity1 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;//number of batches
		System.out.print("Enter number of batches: ");
		n = sc.nextInt();
		int arr[][] = new int[n][];
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter number of students for batch " + (i + 1) + ": ");
			double t = sc.nextDouble();
			arr[i] = new int[(int)Math.ceil(t / 4)];
			for (int j = 0; j < arr[i].length; j++) {
				if (t >= 4)
					arr[i][j] = 4;
				else
					arr[i][j] = (int)t;
				t -= 4;
			}
		}
		int classoffour = 0;
		System.out.println("Contents of 2D Jagged Array");
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
				if (arr[i][j] == 4)
					classoffour++;
			}
			System.out.print("\n");
		}
		System.out.println("Number of tutors with 4 students are: " + classoffour );
		sc.close();
	}
}
