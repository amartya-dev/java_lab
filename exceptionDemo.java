import java.util.*;

public class exceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the mobile number");
        String mobileNumber = sc.next();
        System.out.println("Enter the registration number");
        String registrationNumber = sc.next();

        sc.close();

        try {
            Integer.parseInt(mobileNumber);
            if (mobileNumber.length() != 9){
                throw new IllegalArgumentException("The length of mobile number should be strictly 9");
            }
            if (!registrationNumber.matches("[a-zA-Z0-9]*")){
                throw new NoSuchElementException("The registration number should only contain letters or numbers");
            }
            System.out.println("Valid");
        }
        catch (IllegalArgumentException exception){
            System.out.println("The mobile number is invalid");
            System.out.println("Error " + exception.getMessage());
        }
        catch (NoSuchElementException exception){
            System.out.println("The registration number is invalid");
            System.out.println("Error " + exception.getMessage());
        }
        catch (Exception exception){
            System.out.println("One of the entered values is invalid");
            System.out.println("Error " + exception.getMessage());
        }
    }
}
