import java.util.*;

class account {
    protected String cname;
    protected int accno;
    protected String type;
    protected int bal;
    Scanner s = new Scanner(System.in);

    void input(){
    System.out.println("Enter customer name");
    cname=s.nextLine();
    System.out.println("Enter account number");
    accno=s.nextInt();
    System.out.println("Enter type of account(c for current and s for savings) ");
    type=s.next();
    System.out.println("Enter balance");
    bal=s.nextInt();
    }

    void display() {
        System.out.println("Customer name:" + cname);
        System.out.println("Account number:" + accno);
        System.out.println("Type of account:" + type);
        System.out.println("Enter balance:" + bal);
    }

    void deposit() {
        int amt;
        System.out.println("Enter the amount to deposit");
        amt = s.nextInt();
        bal = bal + amt;
    }
}

class saving extends account {
    private double i;

    int comp_int() {
        int t, r;
        r = 10;
        System.out.println("Enter time");
        t = s.nextInt();
        i = bal * (Math.pow(1 + r / 100.0, t)) - bal;
        return (int) i;
    }

    void update_bal() {
        bal = bal + comp_int();
    }

    void withdrawal() {
        int amt;
        System.out.println("Enter amount to withdrawn");
        amt = s.nextInt();
        if (bal >= amt) {
            bal = bal - amt;
        } else {
            System.out.println("The amount cannot be withdrawn");
        }
    }
}

class current extends account {
    private int penal;

    int min_bal() {
        int ret1 = 1;
        if (bal <= 500) {
            penal = 50;
            bal = bal - penal;
            ret1 = 0;
        } else {
            System.out.println("No penality imposed");
        }
        return ret1;
    }

    void withdrawal() {
        int amt;
        System.out.println("Enter the amount to withdrawn");
        amt = s.nextInt();
        int k = min_bal();
        if (k == 1) {
            if (bal >= amt)
                bal = bal - amt;
        } else {
            System.out.println("The amount cannot be withdrawn");
        }
    }
};

public class labDa1_3 {
    public static void main(String[] args) {
        current c1 = new current();
        saving s1 = new saving();
        c1.input();
        c1.display();
        c1.deposit();
        c1.display();
        c1.withdrawal();
        c1.display();
        s1.input();
        s1.display();
        s1.deposit();
        s1.display();
        s1.withdrawal();
        s1.display();
    }
}