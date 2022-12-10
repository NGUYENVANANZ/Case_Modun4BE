package caseModun4.controller.linh;

import caseModun4.model.Account;
import caseModun4.service.linh.IAccountServiceSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class SearchAPI {

    @Autowired
    IAccountServiceSearch iAccountServiceSearch;

    @GetMapping("/{name}")
    public ResponseEntity<List<Account>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(iAccountServiceSearch.findByName(name), HttpStatus.OK);
    }
//    @GetMapping("")
//    public ResponseEntity<List<Account>> getAll() {
//        return new ResponseEntity<>(iAccountServiceSearch.getAll(), HttpStatus.OK);
//    }



}

