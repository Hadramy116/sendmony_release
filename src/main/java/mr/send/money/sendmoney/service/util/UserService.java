package mr.send.money.sendmoney.service.util;

import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.service.util.UserDto.LoginInfo;
import mr.send.money.sendmoney.service.util.UserDto.RegistrationInfo;

public interface UserService {

    AppUser getUserByUsername(String username);

    void loginUser(LoginInfo loginInfo);

    AppUser registerUser(RegistrationInfo registrationInfo);
}
