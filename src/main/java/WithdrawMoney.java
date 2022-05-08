public class WithdrawMoney {
    public static void main(String[] args) {
        ATM atm = new ATM();

        System.out.println("First withdrawal: 1500");

        System.out.println(atm.withdrawal(1500));

        System.out.println("\nSecond withdrawal: 700");

        System.out.println(atm.withdrawal(700));

        System.out.println("\nThird withdrawal: 400");

        System.out.println(atm.withdrawal(400));

        System.out.println("\nFourth withdrawal: 1100");

        System.out.println(atm.withdrawal(1100));

        System.out.println("\nFifth withdrawal: 1000");

        System.out.println(atm.withdrawal(1000));

        System.out.println("\nSixth withdrawal: 700");

        System.out.println(atm.withdrawal(700));

        System.out.println("\nSeventh withdrawal: 300");

        System.out.println(atm.withdrawal(300));
    }
}