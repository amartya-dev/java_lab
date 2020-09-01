import java.util.Arrays;
import java.util.Random;

class CountNegative implements Runnable {
    int [] numbers;
    int num = 0;

    CountNegative(int [] numbers) {
        this.numbers = numbers;
    }

    public void run () {
        for (int i = 0; i < numbers.length; i ++){
            num = numbers[i] < 0 ? num+1 : num;
        }
    }
}

class CountPositiveEven implements Runnable {
    int [] numbers;
    int num = 0;

    CountPositiveEven(int [] numbers) {
        this.numbers = numbers;
    }

    public void run () {
        for (int i = 0; i < numbers.length; i ++){
            num = (numbers[i] > 0 && numbers[i] % 2 == 0) ? num+1 : num;
        }
    }
}

class CountPositiveOdd implements Runnable {
    int [] numbers;
    int num = 0;

    CountPositiveOdd(int [] numbers) {
        this.numbers = numbers;
    }

    public void run () {
        for (int i = 0; i < numbers.length; i ++){
            num = (numbers[i] > 0 && numbers[i] % 2 != 0) ? num+1 : num;
        }
    }
}

public class CountNumbers {

    public static int generatRandomPositiveNegitiveValue(int max , int min) {
        Random random = new Random();
        int generated = random.nextInt(max - min) + min;
        return generated;
    }

    public static int [] generateNumbers(int n){
        int [] numbers = new int [n];

        // Randomly generate votes
        for (int i = 0; i < n; i++){
            numbers[i] = generatRandomPositiveNegitiveValue(10, -10);
        }

        return numbers;
    }

    public static void main(String[] args) {

        System.out.println("Generating random numbers");

        // Generate 20 randim numbers
        int [] numbers = generateNumbers(20);

        System.out.println(Arrays.toString(numbers));

        CountNegative nCountNegative = new CountNegative(numbers);
        CountPositiveEven pCountPositiveEven = new CountPositiveEven(numbers);
        CountPositiveOdd positiveOdd = new CountPositiveOdd(numbers);


        System.out.println("Creating three threads to count negative, positive even and positive odd ...");

        Thread negative = new Thread(nCountNegative);
        Thread pEven = new Thread(pCountPositiveEven);
        Thread pOdd = new Thread(positiveOdd);

        // Start all threads
        negative.start();
        pEven.start();
        pOdd.start();

        try {
            pEven.join();
            pOdd.join();
            negative.join();
        }

        catch (Exception ex){
            System.out.println("Error encountered : " + ex + "\n");
        }

        System.out.println("All threads have completed execution, now printing result");

        System.out.println("Final Results are: ");
        System.out.println("Negative : " + nCountNegative.num);
        System.out.println("Positive Even : " + pCountPositiveEven.num);
        System.out.println("Positive Odd : " + positiveOdd.num);
    }
}
