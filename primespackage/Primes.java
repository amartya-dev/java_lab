package primespackage;

public class Primes {
    public static boolean checkForPrime(int elem){
        for (int i = 2; i < elem; i++){
            if (elem % 2 == 0){
                return false;
            }
        }
        return true;
    }
}
