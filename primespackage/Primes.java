package primespackage;

public class Primes {
    public static boolean checkForPrime(int elem){
        for (int i = 2; i < elem; i++){
            if (elem % i == 0){
                return false;
            }
        }
        return true;
    }
}
