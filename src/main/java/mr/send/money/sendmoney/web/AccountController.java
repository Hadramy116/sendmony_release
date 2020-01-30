package mr.send.money.sendmoney.web;

import mr.send.money.sendmoney.entites.Account;
import mr.send.money.sendmoney.secure.payload.response.MessageResponse;
import mr.send.money.sendmoney.service.imp.AccountServiceImp;
import mr.send.money.sendmoney.service.imp.UserServiceImp;
import mr.send.money.sendmoney.service.util.UserDto.AccountForm;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private AccountServiceImp accountServiceImp;
    private UserServiceImp userServiceImp;

    public AccountController(AccountServiceImp accountServiceImp, UserServiceImp userServiceImp) {
        this.accountServiceImp = accountServiceImp;
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
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
    public ResponseEntity<?> addAccount(@NotNull @Valid AccountForm account) {
        if (!userServiceImp.existByUsername(account.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: User not found"));
        }
        accountServiceImp.save(account);

        return ResponseEntity.ok(new MessageResponse("Account registered !"));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable @NotNull Integer id) {
         accountServiceImp.delete(id);
         return "Deleted";
    }

}
