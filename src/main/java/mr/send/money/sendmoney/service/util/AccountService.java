package mr.send.money.sendmoney.service.util;

import mr.send.money.sendmoney.entites.Account;

import java.util.List;

public interface AccountService {

    Account save(Account account);

    List<Account> findAll();

    Account findOne(Long id);

    void delete(Long id);

    Account getCurrentUserAccount();

}
