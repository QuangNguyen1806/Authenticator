public class Main {

    public static void main(String[] args) {
        Admin faceBookAdmin = new Admin();
        faceBookAdmin.systemName = "facebook";
        Admin googleAdmin = new Admin();
        googleAdmin.systemName = "google";
        User theUser = new User();
        User theUser2 = new User();
        theUser.register(faceBookAdmin);
        theUser.register(googleAdmin);
        theUser2.register(faceBookAdmin);
        theUser2.register(googleAdmin);
        faceBookAdmin.login();
        faceBookAdmin.printUserNames();
        googleAdmin.login();
        googleAdmin.printUserNames();


    }
}
