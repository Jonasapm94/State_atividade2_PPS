package models;

public class CreditCard {
    private String number;
    private String titular;
    private String cvv;
    private boolean isValid;
    private float limit;

    public CreditCard(String number, String titular, String cvv, float limit){
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

    public boolean buySomethingReturnBool(float value){
        if ((this.limit - value) >= 0){
            this.limit -= value;
            return true;
        }
        return false;
    }
}
