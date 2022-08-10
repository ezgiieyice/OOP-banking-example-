package bankingapplication;
import java.util.Scanner;

public class MainPanel {
    
    public static void main(String[] args) {
        
        User[] users = new User[20];
        
        // Registered User in System (4 users, it doesnt exist in real life)
        users[0] = new User("Ezgi", "Eyice", 0001, "ezgieyice@gmail.com", "eee12345", "05359476289");
        users[0].addAccount(new Account(10000, 500, "5010 6242 7887 3465", "TR34 0001 0012 3157 5410 6250 01 "));
        users[0].addCredirtCard(new CreditCard(15000, "1262 5758 9741 6325", 2750, 500));
        
        users[1] = new User("Alexis", "Marin", 0002, "amarin@gmail.com", "marin123", "05356652444");
        users[1].addCredirtCard(new CreditCard(11000, "4685 2134 1758 2004", 4345, 650));
       
        users[2] = new User("John", "Murphy", 0003, "murphy@gmail.com", "jm0000", "05379961646");
        users[2].addAccount(new Account(250000, 5000, "4824 6000 2778 9636", "TR65 0002 0013 3258 4457 3610 02"));
       
        users[3] = new User("Kate","Everdane", 0004, "k.ever@gmail.com", "0kate0", "05441123685");
        users[3].addAccount(new Account(750000, 20000, "6575 2314 8547 3698", "TR82 0005 4121 3767 2889 9919 09"));
        users[3].addAccount(new Account(285000, 5000, "4432 5741 9656 8584", "TR24 0016 3465 8754 6373 1415 12"));
        users[3].addCredirtCard(new CreditCard(12500, "4717 5012 6838 2059" ,12500, 2750));
        
        Scanner input = new Scanner(System.in);

        int newUser = 4; // because thera are already 4 users in application
        int currentUser ; 
        int option ;
        
        do {
            
            System.out.println(""
                    + "====== MAIN MENU ======\n"
                    + "1-CREATE A NEW USER\n"
                    + "2-LOG IN\n"
                    + "3-EXIT");

            option = input.nextInt();

            switch (option) {

                case 1:
                    
                    createUser(users, newUser++);
                    break;

                case 2:
                    
                    currentUser = userLogin(users, newUser);
                    if(currentUser == -1) break;
                     
                        int option2;
                        do {
                            System.out.println("1-Display Account Information\n"
                                    + "2-Display Credit Card Information\n"
                                    + "3-EFT\n"
                                    + "4-Log Out");
                            option2 = input.nextInt();
                            switch (option2) {

                                case 1:
                                    showAllAccount(users, currentUser);

                                    System.out.println("1-Add a new Account\n"
                                            + "2-Back");
                                    int option5 = input.nextInt();
                                    if (option5 == 1) {
                                        addAccount(users, currentUser);
                                        break;
                                    } else {
                                        break;
                                    }

                                case 2:
                                    showAllCard(users, currentUser);

                                    System.out.println("1-Pay Debt\n"
                                            + "2-Add a new Credit Card\n"
                                            + "3-Back");
                                    int option3 = input.nextInt();
                                    if(option3 == 1){
                                        
                                        
                                        System.out.println("Which card do you want to pay cards debt ? ");
                                        int card = 0;
                                        for(int i = 0; i<users[currentUser].getNumCards();i++){
                                            
                                            System.out.println(++card + ". "+ users[currentUser].getCreditCard()[i]);
                                        }
                                        int selectCard = input.nextInt();
                                        
                                        System.out.print("How much money do you want to pay debt ?  : ");
                                        double amount = input.nextDouble();
                                        
                                        if(amount >= users[currentUser].getCreditCard()[--selectCard].getMinTotalDebt()){
                                                if(selectCard == 0){
                                                    users[currentUser].getCreditCard()[0].payDebt(amount);
                                                }
                                                else if(selectCard == 1){
                                                    users[currentUser].getCreditCard()[1].payDebt(amount);
                                                }
                                                else break;
                                        }
                                        else{
                                                System.out.println("Credit card debt payment failed. You must pay at least "
                                                        + users[currentUser].getCreditCard()[selectCard].getMinTotalDebt() +"\n");
                                                break;
                                        }
                                    
                                        
                                        System.out.println("From which account should your credit card debt be withdrawn? ");
                                        
                                        int account = 0;
                                        for(int i = 0; i<users[currentUser].getNumAccounts(); i++){
                                            
                                            System.out.println(++account +". "+ users[currentUser].getAccounts()[i]);
                                        }
                                        
                                        int selectAcc = input.nextInt();
                                        
                                        if(selectAcc == 1){                        
                                            users[currentUser].getCreditCard()[selectCard].withdraw(users[currentUser].getAccounts()[0], amount);
                                            
                                        }
                                        else if(selectAcc == 2){
                                            users[currentUser].getCreditCard()[selectCard].withdraw(users[currentUser].getAccounts()[1], amount);
                                        }
                                        else if(selectAcc == 3){
                                            users[currentUser].getCreditCard()[selectCard].withdraw(users[currentUser].getAccounts()[2], amount);
                                            
                                        }
                                        else if(selectAcc == 4){
                                            users[currentUser].getCreditCard()[selectCard].withdraw(users[currentUser].getAccounts()[3], amount);
                                            
                                        }
                                        else if(selectAcc == 5){
                                            users[currentUser].getCreditCard()[selectCard].withdraw(users[currentUser].getAccounts()[4], amount);
                                            
                                        }
                                        else break;
                                        
                                        
                                        if(users[currentUser].getNumAccounts() == 0){
                                            System.out.println("\nYou don't have a account.You should create a Bank Account for withdrawing.\n");
                                            break;
                                        }
                                        
                                        if(amount > users[currentUser].getAccounts()[--selectAcc].getBalance()){
                                            System.out.println("Insufficient Balance. Please Try Again.");
                                            break;
                                        }
                                            
                                        break;
                                        
                                        
                                    }else if(option3 == 2){
                                        addCreditCard(users,currentUser);break;
                                    }else break;

                                case 3:
                                    
                                    System.out.print("Enter the IBAN Number of Targent Account is the EFT : ");
                                    String targentAcc = input.next();
                                    System.out.print("Enter the Amount is the EFT : ");
                                    double amount = input.nextDouble();
                                    
                                    System.out.println("Which account would you like to receive the money from?");
                                    
                                    int account = 0;
                                        for(int i = 0; i<users[currentUser].getNumAccounts(); i++){
                                            
                                            System.out.println(++account +". "+ users[currentUser].getAccounts()[i]);
                                        }
                                    int select = input.nextInt();
                                    
                                    
                                    (users[currentUser].getAccounts()[--select]).eft(users[currentUser].getAccounts()[0], amount);
                                    break;
                                    
                                case 4:
                                    
                                    System.out.println("You logged out.\n");
                                    break;
                            }
                            
                        } while (option2 != 4);
                
            }
            
        } while (option != 3);
        
        System.out.println("\nYou EXIT...");
        System.out.println("Thank For Using My Application. Have a Nice Day. Good-Bye!");
    }
    
    
    public static void createUser(User users[], int newUser) {
        
        Scanner input = new Scanner(System.in);

        System.out.print("* Enter your name : ");
        String name = input.nextLine();

        System.out.print("* Enter your surname: ");
        String surname = input.nextLine();

        System.out.print("* Enter your customer number: ");
        int customerNum = input.nextInt();

        System.out.print("* Enter your email: ");
        String email = input.next();

        System.out.print("* Create a password: ");
        String password = input.next();

        System.out.print("* Enter your telephone number: ");
        String telephone = input.next();

        users[newUser] = new User(name, surname, customerNum, email, password, telephone); 
        
        System.out.println("\nRegistration was successful.\n " );
    }

    public static int userLogin(User users[], int newUser) {

        Scanner input = new Scanner(System.in);

        System.out.print("* Enter e-mail Address or Telephone Number :");
        String mailOrTel = input.nextLine();

        System.out.print("* Enter your password :");
        String password = input.nextLine();

        for (int i = 0; i < newUser; i++) {

            if (((users[i].getEmailAddress().compareTo(mailOrTel) == 0) 
                                        || 
                    (users[i].getTelephoneNum().compareTo(mailOrTel) == 0)) 
                                            &&
                    users[i].getPassword().compareTo(password) == 0) {

                System.out.println("\nSuccessful Login...  "
                                +  "Welcome "+users[i].getName().toUpperCase()+"\n");
                return i;
            }
        }
        
        System.out.println("\nINVALID e-mail/telephone number or password.\n"
                + "Please enter correct.\n");
        return -1;
    }

    public static void addAccount(User users[], int currentUser) {

        int totalAccount = users[currentUser].getNumAccounts();
        
        if (totalAccount < User.getMAX_ACCOUNT()) {

            Scanner input = new Scanner(System.in);

            System.out.print("Enter Account Number : ");  
            String accountNum = input.nextLine();

            System.out.print("Enter your Iban Number :");
            String ibanNum = input.nextLine();

            System.out.print("Create your balance : ");
            double balance = input.nextDouble();  

            System.out.print("Create your minimum balance : ");
            double minBalance = input.nextDouble(); 

            users[currentUser].addAccount(new Account(balance, minBalance, accountNum, ibanNum));
            System.out.println("\n!!! The account was addded. ( " + users[currentUser].getNumAccounts() + "/5 )\n");
        } 
        else {
            System.out.println("You can't add a new account. You have 5 account.\n");
        }

    }

    public static void addCreditCard(User users[], int currentUser) {

        int totalCard = users[currentUser].getNumCards();

        Scanner input = new Scanner(System.in);

        if (totalCard < User.getMAX_CARD()) {
            
            if(totalCard == 0)System.out.println("Total Credit Card = 0");

            System.out.print("Enter the card number :");
            String cardNum = input.nextLine();

            System.out.print("Enter a limit :");
            double limit = input.nextDouble();

            System.out.print("Create a Credit Card Debt :");
            double debt = input.nextDouble();
            
            System.out.print("Enter minimum debt :");
            double minDebt = input.nextDouble();

            users[currentUser].addCredirtCard(new CreditCard(limit, cardNum, debt, minDebt));
            System.out.println("\nThe Credit Card was added. ( " + users[currentUser].getNumCards() + "/2 )\n");
        } else {
            System.out.println("\nYou can't add a new Credit Card. You have 2 credit cards.\n");
        }
    }

    private static void showAllAccount(User users[], int currentUser) {

        if (users[currentUser].getNumAccounts() == 0) {
            System.out.println("\nYou don't have a account.You can create a new Bank Account.\n");
        }

        for (Account account : users[currentUser].getAccounts()) {
            if(account != null)
            System.out.println(account.toString());
            
        }
    }

    public static void showAllCard(User users[], int currentUser) {
        
        if(users[currentUser].getNumCards() == 0){
            System.out.println("\nYou don't have a creidt card.You can create a new Credit Card.\n");
        }
        for (CreditCard card : users[currentUser].getCreditCard()) {

            if (card != null) {
                System.out.println(card.toString());
            }
        }
    }
    
}
