
public class CreditCard {
    private String number;
    private String titular;
    private String cvv;
    private boolean isValid;
    private double limit;

    CreditCard(String number, String titular, String cvv, double limit){
        if (cvv.length() ==3 && number.length() == 8 && limit > 0){
            this.number = number;
            this.cvv = cvv;
            isValid = true;
            this.limit = limit;
        } else {
            isValid = false;
        }
    }

    public boolean isValid(){
        return isValid;
    }

    public boolean buySomethingReturnBool(double value){
        if ((this.limit - value) > 0){
            this.limit -= value;
            return true;
        }
        return false;
    }
}
