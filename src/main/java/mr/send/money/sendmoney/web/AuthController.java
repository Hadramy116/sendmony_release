package mr.send.money.sendmoney.web;

import mr.send.money.sendmoney.entites.AppRole;
import mr.send.money.sendmoney.entites.AppUser;
import mr.send.money.sendmoney.entites.RoleName;
import mr.send.money.sendmoney.repository.RoleRepository;
import mr.send.money.sendmoney.repository.UserRepository;
import mr.send.money.sendmoney.secure.jwt.JwtUtils;
import mr.send.money.sendmoney.secure.payload.request.LoginRequest;
import mr.send.money.sendmoney.secure.payload.request.SignupRequest;
import mr.send.money.sendmoney.secure.payload.response.JwtResponse;
import mr.send.money.sendmoney.secure.payload.response.MessageResponse;
import mr.send.money.sendmoney.secure.services.UserDetailsImpl;
import mr.send.money.sendmoney.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.Encoder;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private RoleRepository roleRepository;
    private JwtUtils jwtUtils;
    private UserServiceImp userServiceImp;

    @Autowired
    PasswordEncoder passwordEncoder;

    public AuthController(AuthenticationManager authenticationManager, RoleRepository roleRepository, JwtUtils jwtUtils, UserServiceImp userServiceImp) {
        this.authenticationManager = authenticationManager;
        this.roleRepository = roleRepository;
        this.jwtUtils = jwtUtils;
        this.userServiceImp = userServiceImp;;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                roles));
    }


    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userServiceImp.existByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }


        // Create new user's account
        AppUser user = new AppUser(signUpRequest.getUsername(),
                passwordEncoder.encode(signUpRequest.getPassword()),
                null,
                null
        );

        Set<String> strRoles = signUpRequest.getRole();
        Set<AppRole> roles = new HashSet<>();


        if (strRoles == null) {
            AppRole userRole = roleRepository.findAppRoleByRoleName(RoleName.SIMPLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        AppRole adminRole = roleRepository.findAppRoleByRoleName(RoleName.ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;

                    default:
                        AppRole userRole = roleRepository.findAppRoleByRoleName(RoleName.SIMPLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        user.setAppRoles(roles);
        userServiceImp.save(user);
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }



}
