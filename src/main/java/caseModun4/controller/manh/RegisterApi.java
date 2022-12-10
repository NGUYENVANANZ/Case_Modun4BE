package caseModun4.controller.manh;


import caseModun4.model.Account;
import caseModun4.model.Role;
import caseModun4.repository.IAccountRepo;
import caseModun4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/registers")
public class RegisterApi {

  @Autowired
  IAccountRepo iAccountRepo;

  @Autowired
  AccountService accountService;

  @PostMapping("/register")
  public ResponseEntity<Account> register(@RequestBody Account account){
    Role role = new Role();
    role.setName("ROLE_ADMIN");
    role.setId(1);
    account.setRoles(role);
    iAccountRepo.save(account);
    return new ResponseEntity<>(account, HttpStatus.OK);
  }


}
