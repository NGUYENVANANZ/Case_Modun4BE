package caseModun4.controller.dinh;

import caseModun4.model.Account;
import caseModun4.service.an.AnService;
import caseModun4.service.dinh.profileUser.IProfileService;
import caseModun4.service.dinh.profileUser.ProfileUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class ProfileUserAPI {

    @Autowired
    AnService anService;
    @Autowired
    ProfileUserService profileUserService;
    @Autowired
    IProfileService iProfileService;

    @GetMapping("/profile/{id}")
    public ResponseEntity<Account> profileUser(@PathVariable long id){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = anService.account(userDetails.getUsername());

        return new ResponseEntity<>(profileUserService.getAll1(id), HttpStatus.OK);
    }
}
