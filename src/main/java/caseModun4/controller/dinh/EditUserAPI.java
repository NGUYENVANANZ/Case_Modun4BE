package caseModun4.controller.dinh;

import caseModun4.model.Account;
import caseModun4.model.dto.AccountEdit;
import caseModun4.repository.IAccountRepo;
import caseModun4.service.an.AnService;
import caseModun4.service.dinh.profileUser.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EditUserAPI {
    @Autowired
    IProfileService iProfileService;
    @Autowired
    AnService anService;
    @Autowired
    IAccountRepo iAccountRepo;

    @GetMapping("/edit")
    public ResponseEntity<Account> edit() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return new ResponseEntity<>(anService.account(userDetails.getUsername()), HttpStatus.OK);
    }

    @PostMapping("/editAccount")
    public ResponseEntity<Account> editAccount(@RequestBody AccountEdit accountEdit) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account1 = anService.account(userDetails.getUsername());

        account1.setFullName(accountEdit.getFullName());
        account1.setAddress(accountEdit.getAddress());
        account1.setBirthday(accountEdit.getBirthday());
        account1.setGender(accountEdit.getGender());
        account1.setPhoneNumber(accountEdit.getPhoneNumber());
        account1.setImg(accountEdit.getImg());
        account1.setPassword(accountEdit.getPassword());

        iAccountRepo.save(account1);


        return new ResponseEntity<>(account1, HttpStatus.OK);
    }
}
