package lab_1;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("ЧАСТЬ 1: Методы и вычисления");

        int x = 7;
        int y = 2;
        System.out.println("Сумма: " + MathOperations.add(x, y));
        System.out.println("Разность: " + MathOperations.subtract(x, y));
        System.out.println("Произведение: " + MathOperations.multiply(x, y));
        System.out.println("Частное: " + MathOperations.divide(x, y));
        System.out.println();

        System.out.println("Максимум (10, 5): " + MathOperations.findMax(10, 5));
        System.out.println("Максимум (3, 8): " + MathOperations.findMax(3, 8));
        System.out.println();

        int side = 5;
        System.out.println("Площадь квадрата: " + MathOperations.squareArea(side));
        System.out.println("Периметр квадрата: " + MathOperations.squarePerimeter(side));
        System.out.println();

        System.out.println("Гипотенуза (3, 4): " + MathOperations.findHypotenuse(3, 4));
        System.out.println("Гипотенуза (5, 12): " + MathOperations.findHypotenuse(5, 12));
        System.out.println();

        System.out.println("Процент: " + MathOperations.calculatePercentage(25, 200));
        System.out.println("Процент: " + MathOperations.calculatePercentage(45, 150));
        System.out.println();

        System.out.println("ЧАСТЬ 2: Проектирование класса Банковский счёт");

        BankAccount account1 = new BankAccount("Анна", 100000.0);
        BankAccount account2 = new BankAccount("Борис", 10000.0);

        account1.deposit(50000.0);
        System.out.println("Владелец: " + account1.getOwner() + ", баланс:" + account1.getBalance()+ ", богатый счёт: " + account1.isRich());
        account2.withdraw(15000.0);
        account2.withdraw(5000.0);
        account2.deposit(5000.0);
        System.out.println("Владелец: " + account2.getOwner() + ", баланс:" + account2.getBalance()+ ", богатый счёт: " + account2.isRich());


    }
}
