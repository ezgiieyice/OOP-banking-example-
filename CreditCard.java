package bankingapplication;

public class CreditCard extends Account {
    
    private double limit;
    private String creditCardNum;
    private double totalDebt;
    private double minTotalDebt;
    
    public CreditCard(){
        
    }
    public CreditCard(double limit,String creditCardNum,double totalDebt,double minTotalDebt){
        
        
        this.limit = limit;
        this.creditCardNum = creditCardNum;
        this.totalDebt = totalDebt;
        this.minTotalDebt = minTotalDebt;
    }
    
    public double getLimit(){
        return this.limit;
    }
    public void setLimit(double limit){
        this.limit = limit;
    }
    
    public String getCreditCardNum(){
        return this.creditCardNum;
    }
    public void setCreditCardNum(String creditCardNum){
        this.creditCardNum = creditCardNum;
    }
    
    public double getTotalDebt(){
        return this.totalDebt;
    }
    public void setTotalDebt(double totalDebt){
        this.totalDebt = totalDebt;
    }
    
    public double getMinTotalDebt(){
        return this.minTotalDebt;
    }
    public void setMinTotalDebt(double minTotalDebt){
        this.minTotalDebt = minTotalDebt;
    }
    
    public void withdraw(Account accountNum,double amount){
        
            double newBalance = accountNum.getBalance() - amount;
            System.out.println("Withdrawal Money :"+amount);
            this.balance = newBalance;
            System.out.println("Your New Balance is :"+this.balance+"\n");
    }
    
    public void payDebt(double amount){
        
        
            this.totalDebt = this.totalDebt - amount;
            this.limit = this.limit + amount;
            System.out.println("Remaining Debt is "+this.totalDebt);
            System.out.println("Utilizable Limit is "+this.limit+"\n");
        
        
    }
    
    @Override
    public String toString(){
        
        return "Credit Card {Cards Limit = "+this.limit+"  Cards Total Debt = "+this.totalDebt+
               "  Cards Min Debt = "+this.minTotalDebt+"  Credit Cards Number = "+this.creditCardNum+"}\n" ;
    }
    
    
    
}
