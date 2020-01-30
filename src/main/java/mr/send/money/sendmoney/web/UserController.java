package mr.send.money.sendmoney.web;

import mr.send.money.sendmoney.entites.AppRole;
import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.repository.RoleRepository;
import mr.send.money.sendmoney.service.imp.UserServiceImp;
import mr.send.money.sendmoney.service.util.UserDto.LoginInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UserController {

    private UserServiceImp userServiceImp;
    @Autowired
    private RoleRepository roleRepository;
    private AuthenticationManager authenticationManager;

    public UserController(UserServiceImp userServiceImp, AuthenticationManager authenticationManager) {
        this.userServiceImp = userServiceImp;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping( "/users" )
    public List<AppUser> users() {
        return userServiceImp.findAll();
    }

    @GetMapping("/roles")
    @PreAuthorize("hasRole('ADMIN')")
    public List<AppRole> findRoles() {
        return roleRepository.findAll();
    }

    {

    }


}
