package caseModun4.controller.manh;


import caseModun4.model.Account;
import caseModun4.model.LikePage;
import caseModun4.model.Role;
import caseModun4.model.dto.ResetPassDTO;
import caseModun4.repository.IAccountRepo;
import caseModun4.repository.dinh.ILikePageRepo;
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
  ILikePageRepo iLikePageRepo;

  @Autowired
  AccountService accountService;

  @PostMapping("/register")
  public ResponseEntity<Account> register(@RequestBody Account account){
    Role role = new Role();
    role.setName("ROLE_USER");
    role.setId(1);
    account.setRoles(role);
    account.setStatus(true);
    iAccountRepo.save(account);
    LikePage likePage = new LikePage(account);
    iLikePageRepo.save(likePage);
    return new ResponseEntity<>(account, HttpStatus.OK);
  }


  @GetMapping("/checkUsername")
  public ResponseEntity<Account> checkUser(@RequestParam String userName) {
    Account account = accountService.findByName(userName);
    if (account==null){
      return new ResponseEntity<>(account,HttpStatus.OK);
    }else {
      return new ResponseEntity<>(account, HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/checkPhonenumber")
  public ResponseEntity<Account> checkPhoneNumber(@RequestParam String phoneNumber) {
    Account account = accountService.findbysdt(phoneNumber);
    if (account==null){
      return new ResponseEntity<>(account,HttpStatus.OK);
    }else {
      return new ResponseEntity<>(account, HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/resetpassword/{username}&{phoneNumber}")
  public  ResponseEntity<Account> resetPass(@RequestBody ResetPassDTO resetPassDTO, @PathVariable String username , @PathVariable String phoneNumber) {
    Account account1 = iAccountRepo.findAccountByPhoneNumberAndUsername(username, phoneNumber);
    if (account1 != null) {
      account1.setPassword(resetPassDTO.getPassword());
      iAccountRepo.save(account1);
      return new ResponseEntity<>(account1, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/check/{username}&{phoneNumber}")
  public  ResponseEntity<Account> check( @PathVariable String username , @PathVariable String phoneNumber){
    Account account1 = iAccountRepo.findAccountByPhoneNumberAndUsername(username, phoneNumber);
    if (account1 != null) {
      return new ResponseEntity<>(account1, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

}
