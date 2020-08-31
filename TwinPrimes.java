import primespackage.*;
import java.util.*;

public class TwinPrimes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the start limit : ");
        int start = sc.nextInt();
        System.out.println("Enter the end limit : ");
        int end = sc.nextInt();

        LinkedList<Integer> primes = new LinkedList<Integer>();

        for (int i = start; i < end; i++){
            if (i == 2){
                continue;
            }
            if (i == 1){
                continue;
            }
            else{
                if (Primes.checkForPrime(i)){
                    primes.addLast(i);
                }
            }
        }

        for (int i = 0; i < primes.size()-1; i++){
            if (Math.abs(primes.get(i) - primes.get(i+1)) == 2){
                System.out.printf("%d %d\n", primes.get(i), primes.get(i+1));
            }
        }

        sc.close();
    }
}
