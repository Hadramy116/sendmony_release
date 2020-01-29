package mr.send.money.sendmoney.web;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.service.imp.AccountServiceImp;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountServiceImp accountServiceImp;

    public AccountController(AccountServiceImp accountServiceImp) {
        this.accountServiceImp = accountServiceImp;
    }

    @GetMapping("/")
    public List<Account> accounts() {
        return accountServiceImp.findAll();
    }

    @GetMapping("/{numAccount}")
    public Account findAccount(@PathVariable("numAccount") String numAccount) {
        return accountServiceImp.findAccountByNumber(numAccount);
    }

    @PostMapping("/user_accounts")
    public List<Account> findUserAccount(@RequestBody @NotNull @Valid String userName) {
        return accountServiceImp.getUserAccounts(userName);
    }

    @PostMapping("/")
    public Account addAccount(@NotNull @Valid Account account) {
        return accountServiceImp.save(account);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable @NotNull Integer id) {
         accountServiceImp.delete(id);
         return "Deleted";
    }

}
