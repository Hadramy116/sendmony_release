package mr.send.money.sendmoney.service.util.UserDto;

public class CreditOrDebitForm {

    private String numAccount;
    private Double Amount;

    public CreditOrDebitForm(String numAccount, Double amount) {
        this.numAccount = numAccount;
        Amount = amount;
    }

    public String getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }
}
