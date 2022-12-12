package caseModun4.controller.an;

import caseModun4.model.*;
import caseModun4.model.dto.FriendDTO;
import caseModun4.repository.an.IFriend;
import caseModun4.service.AccountService;
import caseModun4.service.JwtService;
import caseModun4.service.an.AnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
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

    @Autowired
    IFriend iFriend;

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

    @GetMapping("/pageStatus")
    public ResponseEntity<List<PageStatus>> pageStatus(){
        return new ResponseEntity<>(anService.statuses(),HttpStatus.OK);
    }

    @GetMapping("/notifications")
    public ResponseEntity<List<Notification>> Notification(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Notification> notifications = anService.notifications(userDetails.getUsername());
        notifications.sort(Comparator.comparing(Notification::getId));
        Collections.reverse(notifications);
        return new ResponseEntity<>( notifications,HttpStatus.OK);
    }

    @GetMapping("/account/{id}")
    public ResponseEntity<Account> account(@PathVariable long id){
        return new ResponseEntity<>(anService.account(id),HttpStatus.OK);
    }

    @GetMapping("/checkFriends/{idFriend}")
    public ResponseEntity<FriendDTO> checkFriend(@PathVariable long idFriend){
        FriendDTO friendDTO = new FriendDTO();
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account accounts = anService.account(userDetails.getUsername());
        List<Friend> friends = iFriend.listFriend(accounts.getId());

        for (Friend f:friends
             ) {
            if (f.getAccount1().getId() == idFriend){
                FriendStatus friendStatus = f.getFriendStatus();
                friendDTO.setIdFriend(f.getAccount1().getId());
                friendDTO.setFriendStatus(friendStatus);
            }
        }
        return new ResponseEntity<>(friendDTO,HttpStatus.OK);

    }



}
