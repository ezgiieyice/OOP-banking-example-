package bankingapplication;

public class Account {
    
    public double balance;
    private double minBalance;
    private String accountNum;
    private String ibanNum;
    
    public Account(){
    }
    public Account(double balance,double minBalance,String accountNum,String ibanNum){
        
        this.balance = balance;
        this.minBalance = minBalance;
        this.accountNum = accountNum;
        this.ibanNum = ibanNum;
    }
    public double getBalance(){
        return this.balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public double getMinBalance(){
        return this.minBalance;
    }
    public void setMinBalance(double minBalance){
        this.minBalance = minBalance;
    }
    
    public String getAccountNum(){
        return this.accountNum;
    }
    public void setAccountNum(String accountNum){
        this.accountNum = accountNum;
    }
    
    public String getIbanNum(){
        return this.ibanNum;
    }
    public void setIbanNum(String ibanNum){
        this.ibanNum = ibanNum;
    }
    
    public boolean hasEnaughMoney(double amount){
        return this.balance >= amount;
        
    }
    
    public void eft(Account account, double amount ){
        if(hasEnaughMoney(amount)){
            
            System.out.println("\nYou have successfully EFT.\n");
            this.balance = this.balance - amount;
            System.out.println("Sending Money is :" +amount);
            System.out.println("Your New Balance is : "+this.balance+"\n");
            
        }
        else{
            System.out.println("\nInsufficient Balance. Please Try Again.\"");
        }
     }   
    
    @Override
        public String toString(){
            
            return "Account {Current Balance = "+this.balance+"  Minimum Balance = "+this.minBalance+
                   "  Account Number = "+this.accountNum+"  Iban Number = "+this.ibanNum +"}\n";
            
       } 
    
}
