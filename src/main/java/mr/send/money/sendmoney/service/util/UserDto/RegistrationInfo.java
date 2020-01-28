package mr.send.money.sendmoney.service.util.UserDto;

import javax.validation.constraints.NotNull;

public class RegistrationInfo {
    @NotNull
    private String userName;
    @NotNull
    private String password;
    @NotNull
    private String rePassword;

    public RegistrationInfo() {
    }

    public RegistrationInfo(@NotNull String userName, @NotNull String password, @NotNull String rePassword) {
        this.userName = userName;
        this.password = password;
        this.rePassword = rePassword;
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

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }
}
