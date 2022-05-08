import lombok.Data;

import java.util.ArrayList;

@Data
public class ATM {
    private ArrayList<Banknote> moneyInATM = new ArrayList<>();
    private double valueOfMoney;
    private double toWithdraw=0;

    public ATM(){
        for (int i = 0; i < 2; i++) {
            moneyInATM.add(Banknote.THOUSAND);
        }

        for (int i = 0; i < 3; i++) {
            moneyInATM.add(Banknote.FIVE_HUNDRED);
        }

        for (int i = 0; i < 5; i++) {
            moneyInATM.add(Banknote.ONE_HUNDRED);
        }

        for (Banknote bill: moneyInATM) {
            valueOfMoney += bill.value;
        }
    }

    public String withdrawal(double amount){
        int thousands;
        int fiveHundreds;
        int oneHundreds;


        if(amount>valueOfMoney){
            return "ATM could not withdraw correct amount due to lack of funds. Try making a smaller withdrawal";
        }


        if(amount%100!=0){
            return "Cannot withdraw amount not divisible by 100.";
        } else {
            toWithdraw=amount;
        }

        ArrayList<Banknote> notesInATMbeforeWithdrawal = new ArrayList<>();
        notesInATMbeforeWithdrawal.addAll(moneyInATM);
        double amountInATMbeforeWithdrawal = valueOfMoney;

        thousands = iterateThroughMoney(Banknote.THOUSAND);

        fiveHundreds = iterateThroughMoney(Banknote.FIVE_HUNDRED);

        oneHundreds = iterateThroughMoney(Banknote.ONE_HUNDRED);

        if(toWithdraw==0){
            return "You have successfully withdrawn: " + amount + "$. You got " + thousands
                    +  " thousand dollar bills, " + fiveHundreds + " five hundred dollar bills and "
                    + oneHundreds + " one hundred dollar bills.";
        } else {
            valueOfMoney = amountInATMbeforeWithdrawal;
            moneyInATM = notesInATMbeforeWithdrawal;
            toWithdraw=0;
            return "ATM could not withdraw correct amount due to lack of funds.";
        }
    }

    public void removeBanknote(Banknote bill, int amountToWithdraw){
        for (int i = 0; i < amountToWithdraw; i++) {
            moneyInATM.remove(bill);
            valueOfMoney-=bill.value;
        }
    }

    private int iterateThroughMoney(Banknote note){
        int billsToRemove=0;

        if(toWithdraw>=note.value){
            for (Banknote bill: moneyInATM) {
                if(bill.value==note.value){
                    if(toWithdraw>=note.value){
                        billsToRemove++;
                        toWithdraw-=note.value;
                    } else {
                        break;
                    }
                }
            }
        }
        removeBanknote(note, billsToRemove);

        return billsToRemove;
    }


}