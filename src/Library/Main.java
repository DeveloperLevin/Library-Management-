package Library;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Database database;

    public static void main(String[] args) {
        database = new Database();

        int EntryChoice = -1;
        do {
            System.out.println("Welcome to Library Management System\n" +
                    "0. Exit\n1. Login\n2. New user");

            // Get user input from console
            EntryChoice = sc.nextInt();

            // perform actions based on user input
            switch(EntryChoice) {
                case 0:
                    System.exit(0);
                case 1:
                    login();
                    break;
                case 2:
                    newuser();
                    break;
                default:
                    System.out.println("This Option does not exist");
            }
        }while (EntryChoice != 0);
    }

    // methods for login and generating new user
    private static void login() {
        System.out.println("Enter name: ");
        String loginName = sc.next();
        System.out.println("Enter email: ");
        String loginEmail = sc.next();
        System.out.println("Enter phone number: ");
        String loginPhone = sc.next();

        // check if the user is a registered user
        int userId = database.login(loginPhone, loginEmail);
        if (userId != -1){
            User user = database.getUser(userId);
            System.out.println("Welcome! " + user.getName());
        }else {
            System.out.println("Account does not exist");
        }
    }
    private static void newuser() {
        System.out.println("Enter name: ");
        String RegisterName = sc.next();
        System.out.println("Enter email: ");
        String RegisterEmail = sc.next();
        System.out.println("Enter phone number: ");
        String RegisterPhone = sc.next();

        // permission to create admin account or common account
        System.out.println("1. Admin\n2. Normal User");
        int accountType = sc.nextInt();

        if (accountType == 1) {
            User admin = new Admin(RegisterName, RegisterEmail, RegisterPhone);
            database.AddUser(admin);
        }
        else if (accountType == 2) {
            User user = new NormalUser(RegisterName, RegisterEmail, RegisterPhone);
            database.AddUser(user);
        }
        else { System.out.println("No such option is available, Try again!"); }

        System.out.println("Account Created Successfully");
    }
}
