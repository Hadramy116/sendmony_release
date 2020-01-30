package mr.send.money.sendmoney.service.util.UserDto;

import mr.send.money.sendmoney.entites.Account;

import javax.validation.constraints.NotNull;

public class AccountForm {

    @NotNull
    private String userName;
    @NotNull
    private String numAccount;

    public AccountForm() {
    }

    public AccountForm(@NotNull String userName, @NotNull String numAccount) {
        this.userName = userName;
        this.numAccount = numAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNumAccount() {
        return numAccount;
    }

    public void setNumAccount(String numAccount) {
        this.numAccount = numAccount;
    }
}
