package lab_1;

public class BankAccount
{
    private String owner;
    private double balance;

    public BankAccount(String owner, double balance)
    {
        this.owner =owner;
        this.balance = balance;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount)
    {
        if(amount<=0){System.out.println("Ошибка: сумма пополнения должна быть положительной");}
        else balance+=amount;
    }
    public void withdraw(double amount)
    {
        if(amount<=0){System.out.println("Ошибка: сумма снятия должна быть положительной");}
        else if(amount>balance){System.out.println("Ошибка: недостаточно средств");}
        else balance-=amount;
    }
    public boolean isRich()
    {
        return balance>100000;
    }
}
