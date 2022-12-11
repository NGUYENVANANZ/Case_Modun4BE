package caseModun4.controller.dinh;

import caseModun4.model.Account;
import caseModun4.service.dinh.profileUser.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class EditUser {
    @Autowired
    IProfileService iProfileService;

    @GetMapping("/edit/{id}")
    public ResponseEntity<Account> edit(@PathVariable long id){
        return new ResponseEntity<>(iProfileService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/edit")
    public ResponseEntity<Account> edit(@RequestBody Account account){
        iProfileService.save(account);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }
}
