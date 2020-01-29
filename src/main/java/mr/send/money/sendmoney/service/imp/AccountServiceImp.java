package mr.send.money.sendmoney.service.imp;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.repository.AccountRepository;
import mr.send.money.sendmoney.service.util.AccountService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Optional<Account> findOne(Integer id) {
        return accountRepository.findById(id);
    }

    @Override
    public void delete(Integer id) {
        accountRepository.deleteById(id);
    }

    @Override
    public List<Account> getCurrentUserAccounts() {
        return null;
    }
}
