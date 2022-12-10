package caseModun4.controller.dinh;

import caseModun4.model.*;
import caseModun4.repository.an.INotification;
import caseModun4.service.an.AnService;
import caseModun4.service.dinh.profileUser.IProfileService;
import caseModun4.service.dinh.profileUser.ProfileUserService;
import caseModun4.service.manh.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    INotification iNotification;

    @GetMapping("/profile/{id}")
    public ResponseEntity<Account> profileUser(@PathVariable long id) {
        Account account = anService.account(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/page/{id}")
    public ResponseEntity<List<Page>> postUser(@PathVariable long id) {
        Account account = anService.account(id);
        List<Page> pages = profileUserService.pageList(account.getId());
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/friends/{id}")
    public ResponseEntity<List<Account>> friendUser(@PathVariable long id) {
        Account account = anService.account(id);
        List<Account> accounts = anService.friends(account.getUsername());
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/addFriend/{idFriend}")
    public ResponseEntity<String> addFriend(@PathVariable long idFriend) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = anService.account(userDetails.getUsername());
        Account account1 = anService.account(idFriend);
        anService.addFriend(account, account1);
        anService.addFriend(account1, account);
        NotificationType notificationType = new NotificationType(3, "AddFriend");
        Notification notification = new Notification(account1, account, notificationType);
        iNotification.save(notification);
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }

    @PostMapping("/newFriend/{idFriend}")
    public ResponseEntity<String> newFriend(@PathVariable long idFriend) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = anService.account(userDetails.getUsername());
        Account account1 = anService.account(idFriend);
        anService.newFriend(account, account1);
        NotificationType notificationType = new NotificationType(3, "AddFriend");
        Notification notification = anService.notificationAddFriend(account1.getId(), account.getId(), notificationType.getId());
        iNotification.delete(notification);
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
    @PostMapping("/unFriend/{idFriend}")
    public ResponseEntity<String> UnFriend(@PathVariable long idFriend) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = anService.account(userDetails.getUsername());
        Account account1 = anService.account(idFriend);
        anService.unFriend(account, account1);
        NotificationType notificationType = new NotificationType(3, "AddFriend");
        Notification notification = anService.notificationAddFriend(account1.getId(), account.getId(), notificationType.getId());
        iNotification.delete(notification);
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }


}
