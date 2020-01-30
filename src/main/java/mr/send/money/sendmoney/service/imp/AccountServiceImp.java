package mr.send.money.sendmoney.service.imp;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.repository.AccountRepository;
import mr.send.money.sendmoney.service.util.AccountService;
import mr.send.money.sendmoney.service.util.UserDto.AccountForm;
import mr.send.money.sendmoney.service.util.UserService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImp implements AccountService {

    private AccountRepository accountRepository;
    private UserServiceImp userServiceImp;

    public AccountServiceImp(AccountRepository accountRepository, UserServiceImp userServiceImp) {
        this.accountRepository = accountRepository;
        this.userServiceImp = userServiceImp;
    }

    @Override
    public Account save(AccountForm account) throws UsernameNotFoundException{
        AppUser user = userServiceImp.findUserByUsername(account.getUserName()).orElseThrow(
                () -> new UsernameNotFoundException("Not found user by this name : "+account.getUserName())
        );

        return accountRepository.save(new Account(
                account.getNumAccount(),
                0.0,
                user
        ));
    }

    public Account findAccountByNumber(String number) {
        return accountRepository.findByNumAccount(number);
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
    public List<Account> getUserAccounts(String userName) {
        AppUser user = userServiceImp.findUserByUsername(userName)
                .orElseThrow(() -> new UsernameNotFoundException("Not found user with username : "+userName));
        if (user != null) {
            return accountRepository.findAccountByAppUser(user);
        }
        return null;
    }
}
