import java.util.*;
import sort.*;

public class DemoSorting {

    public static void main(String[] args) {    
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of numbers to sort");
        int n = sc.nextInt();
        int [] numbers = new int [n];
        for (int i = 0; i < n; i++){
            numbers[i] = sc.nextInt();
        }

        System.out.println("Enter the number of strings to sort");
        n = sc.nextInt();
        String [] strings = new String [n];
        for (int i = 0; i < n; i++){
            strings[i] = sc.next();
        }

        int [] sortedNumbers = sort.sortIntegers(numbers);
        String [] sortedStrings = sort.sortStrings(strings);

        System.out.println("Results after sorting");
        System.out.println("Numeric : " + Arrays.toString(sortedNumbers));
        System.out.println("Strings : " + Arrays.toString(sortedStrings));

        sc.close();
    }
}