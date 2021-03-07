package bankingapplication;
/**
 *
 * @author Ezgi
 */
public class User {
    
    private String name;
    private String surname;
    private int customerNum;
    private String eMailAddress;
    private String password;
    private String telephoneNum;
    
    private Account accounts[]; 
    private CreditCard[] cards;
    
    private int numAccounts = 0;
    private int numCards = 0;
    
    private static final int MAX_ACCOUNT = 5;
    private static final int MAX_CARD = 2;
    
    public User(){
    }
    public User(String name,String surname,int customerNum,String eMailAddress,String password,String telephoneNum){
        
        this.name = name;
        this.surname = surname;
        this.customerNum = customerNum;
        this.eMailAddress = eMailAddress;
        this.password = password;
        this.telephoneNum = telephoneNum;
        
        this.accounts = new Account[MAX_ACCOUNT];
        this.cards = new CreditCard[MAX_CARD];
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    
    public int getCustomerNum(){
        return this.customerNum;
    }
    public void setCustomerNum(int customerNum){
        this.customerNum = customerNum;
    }
    
    public String getEmailAddress(){
        return this.eMailAddress;
    }
    public void setEmailAddress(String eMailAddress){
        this.eMailAddress = eMailAddress;
    }
    
    public String getPassword(){
        return this.password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getTelephoneNum(){
        return this.telephoneNum;
    }
    public void setTelephoneNum(String telephoneNum){
        this.telephoneNum = telephoneNum;
    }
    
    public Account[] getAccounts(){
        return accounts;
    }
    
    public CreditCard[] getCreditCard(){
        return cards;
    }
    
    
    public int getNumAccounts(){
        return numAccounts;
    }
    
    public int getNumCards(){
        return numCards;
    }
    
    public static int getMAX_ACCOUNT(){
        return MAX_ACCOUNT;
    }
    public static int getMAX_CARD(){
        return MAX_CARD;
    }
    
    public void addAccount(Account accounts){
        this.accounts[numAccounts] = accounts;
        numAccounts++;
    }
    public void addCredirtCard(CreditCard cards){
        this.cards[numCards] = cards;
        numCards++;
    }
    
}
