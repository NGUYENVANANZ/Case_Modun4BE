package caseModun4.controller.dinh;

import caseModun4.model.Account;
import caseModun4.model.Page;
import caseModun4.service.an.AnService;
import caseModun4.service.dinh.profileUser.IProfileService;
import caseModun4.service.dinh.profileUser.ProfileUserService;
import caseModun4.service.manh.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ProfileUserAPI {

    @Autowired
    AnService anService;
    @Autowired
    ProfileUserService profileUserService;
    @Autowired
    IProfileService iProfileService;
    @Autowired
    ProfileService profileService;

    @GetMapping("/profile/{id}")
    public ResponseEntity<Account> profileUser(@PathVariable long id){
        Account account = anService.account(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/page/{id}")
    public ResponseEntity<List<Page>> postUser(@PathVariable long id){
        Account account = anService.account(id);
        List<Page> pages = profileUserService.pageList(account.getId());
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/friends/{id}")
    public ResponseEntity<List<Account>> friendUser(@PathVariable long id){
        Account account = anService.account(id);
        List<Account> accounts = anService.friends(account.getUsername());
        return new ResponseEntity<>(accounts,HttpStatus.OK);
    }


}
