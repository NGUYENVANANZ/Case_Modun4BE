package caseModun4.controller.manh;

import caseModun4.model.Account;
import caseModun4.model.Friend;
import caseModun4.repository.IAccountRepo;
import caseModun4.repository.manh.IFriendRepo;
import caseModun4.service.AccountService;
import caseModun4.service.JwtService;
import caseModun4.service.manh.IFriendService;
import caseModun4.service.manh.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/profiles")
public class ProfileAPI {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtService jwtService;

  @Autowired
  IAccountRepo iAccountRepo;

  @Autowired
  ProfileService profileService;
  @Autowired
  IFriendService iFriendService;

  @GetMapping("/profile")
  public  ResponseEntity<Account> findById() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Account account = profileService.findaccountsbyname(userDetails.getUsername());
    return new ResponseEntity<>(account ,HttpStatus.OK);
  }

}
