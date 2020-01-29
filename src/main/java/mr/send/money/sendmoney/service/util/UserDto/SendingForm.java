package mr.send.money.sendmoney.service.util.UserDto;

public class SendingForm {
    private String numAccountSender;
    private String numAccountReceiver;
    private Double amount;

    public SendingForm() {
    }

    public SendingForm(String numAccountSender, String numAccountReceiver, Double amount) {
        this.numAccountSender = numAccountSender;
        this.numAccountReceiver = numAccountReceiver;
        this.amount = amount;
    }

    public String getNumAccountSender() {
        return numAccountSender;
    }

    public void setNumAccountSender(String numAccountSender) {
        this.numAccountSender = numAccountSender;
    }

    public String getNumAccountReceiver() {
        return numAccountReceiver;
    }

    public void setNumAccountReceiver(String numAccountReceiver) {
        this.numAccountReceiver = numAccountReceiver;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
