import java.util.*;

public class labDa1_2 {

    static String rotate (String num){
        int len = num.length();
        String result = num.substring(len-1, len);
        for (int i = 1; i < len-1; i++){
            result += num.substring(i, i+1);
        }
        result += num.substring(0, 1);
        return result;
    }

    String getHash(String num){
        int res = 0;
        int len = num.length();
        int lastProcessed = 0;
        for (int i = 0; i < len-1; i+=2){
            int temp = Integer.parseInt(num.substring(i, i+2));
            lastProcessed = i;
            res += temp;
        }
        if (lastProcessed < len-2){
            int temp = Integer.parseInt(num.substring(len-2, len));
            res += temp;
        }
        String hash = Integer.toString(res);
        return hash.substring(1, hash.length());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to calculate the hash : ");
        String num = sc.next();
        labDa1_2 object = new labDa1_2();
        String rotated = rotate(num);
        System.out.println("Rotated : " + rotated);
        String answer = object.getHash(num);
        System.out.println("The calculated hash is : " + answer);
        sc.close();
    }
}
