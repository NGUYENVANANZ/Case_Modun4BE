package caseModun4.controller.an;

import caseModun4.model.Account;
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

    @PostMapping("/home/{token}")
    public ResponseEntity<Account> home(@PathVariable String token){
        String userName = jwtService.getUserNameFromJwtToken(token);
        Account account = anService.acount(userName);
        return new ResponseEntity<>(account ,HttpStatus.OK);
    }

    @GetMapping("/page/{token}")
    public ResponseEntity<List<Page>> pageHome(@PathVariable String token){
        String userName = jwtService.getUserNameFromJwtToken(token);
        List<Page> pages = anService.homePage(userName);
        return new ResponseEntity<>(pages,HttpStatus.OK);
    }


}
