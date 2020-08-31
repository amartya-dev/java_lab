import java.util.*;

public class mock1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String main = sc.next();
        String toCheck = sc.next();

        int occurences = 0;

        for (int i = 0; i < main.length(); i++){
            if (main.substring(i, i+1).equals(toCheck)){
                occurences++;
                if (occurences == 2){
                    System.out.println(i);
                    break;
                }
            }
        }
        sc.close();
    }
}
