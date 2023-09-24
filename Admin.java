import java.util.Objects;
import java.util.Scanner;

public class Admin {
    static int minNumDigit = 1;
    static int minLowerCase = 1;
    static int minUpperCase = 1;
    static int minSpecial = 1;
    static int minLength = 1;
    //all of these above are the requirements for the password.
    public User[] users = new User[maxNumUsers];
    public int numUsers = 0;
    static int maxNumUsers = 20;
    public String systemName;


    public boolean userValidityCheck(String userName){
        for(int i = 0; i < numUsers; i++){
            if (Objects.equals(users[i].userName, userName))
                return false;
        }
        return true;
    }

    public void addUser(User newUser) {
        if(numUsers < maxNumUsers) {
            users[numUsers++] = newUser;
        }
        else{
            System.out.println("The numbers of users already exceeded the maximum in the system.");
        }
    }


    public boolean passwordValidityCheck (String password){
        boolean a = aboveMinDigit(password);
        boolean b = aboveMinLowerCase(password);
        boolean c = aboveMinUpperCase(password);
        boolean d = aboveMinSpecial(password);
        boolean e = aboveMinLength(password);
        return a && b && c && d && e;
    }

    private int numDigit (String password){
            int count = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isDigit(password.charAt(i))) {
                    count++;
                }
            }
            return count;
        }
    private boolean aboveMinDigit (String password){
            //If the minimum number of digits is larger than the amount of digits in the password:
            // (i) Print Error message (Error: There should be at least X digits in your password.)
            // (ii) Return False
            // Else:
            // (i) Return True (continue checking other rules)
            if (minNumDigit > numDigit(password)) {
                System.out.println("Error: There should be at least " + minNumDigit + " digits in your password.");
                return false;
            } else {
                return true;
            }
        }

    private int numLowerCase (String password){
            int count = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isLowerCase(password.charAt(i))) {
                    count++;
                }
            }
            return count;
        }
    private boolean aboveMinLowerCase (String password){
            //If the minimum number of lower case is larger than the amount of lower case in the password:
            // (i) Print Error message (Error: There should be at least X lower case in your password.)
            // (ii) Return False
            // Else:
            // (i) Return True (continue checking other rules)
            if (minLowerCase > numLowerCase(password)) {
                System.out.println("Error: There should be at least " + minLowerCase + " lower case in your password.");
                return false;
            } else {
                return true;
            }
        }

    private int numUpperCase (String password){
            int count = 0;
            for (int i = 0; i < password.length(); i++) {
                if (Character.isUpperCase(password.charAt(i))) {
                    count++;
                }
            }
            return count;
        }
    private boolean aboveMinUpperCase (String password){
            //If the minimum number of upper case is larger than the amount of upper case in the password:
            // (i) Print Error message (Error: There should be at least X upper case in your password.)
            // (ii) Return False
            // Else:
            // (i) Return True (continue checking other rules)
            if (minUpperCase > numUpperCase(password)) {
                System.out.println("Error: There should be at least " + minUpperCase + " upper case in your password.");
                return false;
            } else {
                return true;
            }
        }

    private int numSpecial (String password){
            int count = 0;
            for (int i = 0; i < password.length(); i++) {
                if (!Character.isDigit(password.charAt(i))
                        && !Character.isLowerCase(password.charAt(i))
                        && !Character.isUpperCase(password.charAt(i))) {
                    count++;
                }
            }
            return count;
        }
    private boolean aboveMinSpecial (String password){
            //If the minimum number of special symbols is larger than the amount of symbols in the password:
            // (i) Print Error message (Error: There should be at least X symbols in your password.)
            // (ii) Return False
            // Else:
            // (i) Return True (continue checking other rules)
            if (minSpecial > numSpecial(password)) {
                System.out.println("Error: There should be at least " + minSpecial + " special symbols in your password.");
                return false;
            } else {
                return true;
            }
        }


    private boolean aboveMinLength (String password){
            //If the minimum number of letters is larger than the amount of letters in the password:
            // (i) Print Error message (Error: There should be at least X letters in your password.)
            // (ii) Return False
            // Else:
            // (i) Return True (continue checking other rules)
            if (minLength > password.length()) {
                System.out.println("Error: There should be at least " + minLength + " letters in your password.");
                return false;
            } else {
                return true;
            }
        }

    public boolean login() {
        System.out.println("Enter your Username for the " + systemName + " website");
        Scanner sc = new Scanner(System.in);
        String userUserName = sc.nextLine();
        System.out.println("Enter your Password: (Login)");
        String userPassword = sc.nextLine();
        for (int i = 0; i < numUsers; i++) {
            if (Objects.equals(users[i].userName, userUserName)){
                if (Objects.equals(users[i].password, userPassword)){
                    System.out.println("You have successfully login into this account.");
                    return true;
                }
                else{
                    System.out.println("Username or password is incorrect");
                    return false;
                }
            }
        }
        System.out.println("Username or password is incorrect");
        return false;
    }
    public void printUserNames () {
        for (int i = 0; i < numUsers; i++) {
            System.out.println("All available users in the " + systemName + " System: " + users[i].userName);
        }
    }
}

