import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ATMTest {
    ATM atm = new ATM();

    @Test
    void doesATMWithdrawcorrectly(){
        //given
        double testWithdrawal1 =  4100;
        double testWithdrawal2 =  1900;
        double testWithdrawal3 =  1350;

        //atm should return
        double atmShouldContainTest1= 4000;
        double atmShouldContainTest2= 2100;
        double atmShouldContainTest3= 4000;

        //if withdrawal is called
        atm.withdrawal(testWithdrawal1);
        assertEquals(atmShouldContainTest1, atm.getValueOfMoney());
        atm = new ATM();

        atm.withdrawal(testWithdrawal2);
        assertEquals(atmShouldContainTest2, atm.getValueOfMoney());
        atm = new ATM();

        atm.withdrawal(testWithdrawal3);
        assertEquals(atmShouldContainTest3, atm.getValueOfMoney());
        atm = new ATM();
    }

    @Test
    void doesWithdrawalRespondCorrectly(){
        //given
        double testWithdrawal1 = 4500;
        double testWithdrawal2 = 123;
        double testWithdrawal3 = 400;
        double testWithdrawal4 = 1600;

        //atm should return
        String response1 = "ATM could not withdraw correct amount due to lack of funds. Try making a smaller withdrawal";
        String response2 = "Cannot withdraw amount not divisible by 100.";
        String response3 = "ATM could not withdraw correct amount due to lack of funds.";
        String response4 = "You have successfully withdrawn: 1600.0$. You got 1 thousand dollar bills, 1 five hundred dollar bills and 1 one hundred dollar bills.";

        //if withdrawal is called
        assertEquals(response1, atm.withdrawal(testWithdrawal1));
        atm = new ATM();

        assertEquals(response2, atm.withdrawal(testWithdrawal2));
        atm = new ATM();

            //withdraws twice to simulate atm out of one hundred dollar bills
        atm.withdrawal(testWithdrawal3);
        assertEquals(response3, atm.withdrawal(testWithdrawal3));
        atm = new ATM();

        assertEquals(response4, atm.withdrawal(testWithdrawal4));
        atm = new ATM();
    }

}