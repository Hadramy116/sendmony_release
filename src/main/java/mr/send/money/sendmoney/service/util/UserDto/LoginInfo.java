package mr.send.money.sendmoney.service.util.UserDto;

import javax.validation.constraints.NotNull;

public class LoginInfo {

    @NotNull
    private String userName;
    @NotNull
    private String password;

    public LoginInfo() {
    }

    public LoginInfo(@NotNull String userName, @NotNull String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
