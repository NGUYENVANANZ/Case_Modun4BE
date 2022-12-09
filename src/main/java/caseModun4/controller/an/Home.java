package caseModun4.controller.an;

import caseModun4.model.Account;
import caseModun4.model.Friend;
import caseModun4.model.Page;
import caseModun4.service.AccountService;
import caseModun4.service.JwtService;
import caseModun4.service.an.AnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class Home {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtService jwtService;

    @Autowired
    AccountService accountService;

    @Autowired
    AnService anService;

    @PostMapping("/home")
    public ResponseEntity<Account> home(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity<>(anService.account(userDetails.getUsername()) ,HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<List<Page>> pageHome(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Page> pages = anService.homePage(userDetails.getUsername());
        return new ResponseEntity<>(pages,HttpStatus.OK);
    }

    @GetMapping("/friends")
    public ResponseEntity<List<Account>> friendHome(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Account> accounts = anService.friends(userDetails.getUsername());
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }




}
