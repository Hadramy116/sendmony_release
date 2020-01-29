package mr.send.money.sendmoney.service.util;

import mr.send.money.sendmoney.entites.Account;

import java.util.List;
import java.util.Optional;

public interface AccountService {

    Account save(Account account);

    List<Account> findAll();

    Optional<Account> findOne(Integer id);

    void delete(Integer id);

    List<Account> getUserAccounts(String userName);

}
