package mr.send.money.sendmoney.web;

import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.entites.RoleName;
import mr.send.money.sendmoney.entites.TxType;
import mr.send.money.sendmoney.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    private PasswordEncoder encoder;
    private UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp, PasswordEncoder encoder) {
        this.userServiceImp = userServiceImp;
        this.encoder = encoder;
    }

    @GetMapping("/users")
    public List<AppUser> users() {
        return userServiceImp.findAll();
    }

    @PostMapping("/users")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return userServiceImp.save(appUser);
    }

    // Other endpopints

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody AppUser appUser) {
        if (userServiceImp.existByUsername(appUser.getUserName())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }

        appUser.setPassword(encoder.encode(appUser.getPassword()));

        userServiceImp.save(appUser);
        userServiceImp.addRoleToUser(appUser.getUserName(), RoleName.SIMPLE_USER);

        return ResponseEntity.ok("User registered successfully!");
    }

}
