import java.util.Scanner;

public class User {
    public String userName;
    public String password;

    public void register(Admin theAdmin) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Registration: Register for a " + theAdmin.systemName + " account");
        System.out.println("Enter your Username: (Register)");
        String tempUserName = sc.nextLine();
        if (theAdmin.userValidityCheck(tempUserName)) {
            for (; true; ) {
                System.out.println("Enter your Password: (Register)");
                String tempPassword = sc.nextLine();
                if (theAdmin.passwordValidityCheck(tempPassword)) {
                    User newUser = new User();
                    newUser.userName = tempUserName;
                    newUser.password = tempPassword;
                    theAdmin.addUser(newUser);
                    break;
                }
            }
        } else {
            System.out.println("The Username has been taken");
        }
    }
}

