package caseModun4.controller.linh;

import caseModun4.model.Account;
import caseModun4.model.Page;
import caseModun4.service.linh.IAccountServiceSearch;
import caseModun4.service.linh.IPageServiceSearch;
import caseModun4.service.linh.ShowPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
@CrossOrigin("*")
public class SearchAPI {

    @Autowired
    IAccountServiceSearch iAccountServiceSearch;

    @Autowired
    IPageServiceSearch iPageServiceSearch;

    @Autowired
    ShowPageService showPageService;

    @GetMapping("/{name}")
    public ResponseEntity<List<Account>> findByName(@PathVariable String name) {
        return new ResponseEntity<>(iAccountServiceSearch.findByName(name), HttpStatus.OK);
    }

    @PostMapping("/{text}")
    public ResponseEntity<List<Page>> findByText(@PathVariable String text) {
        List<Page> pages = iPageServiceSearch.findByText(text);
        return new ResponseEntity<>(pages, HttpStatus.OK);
    }

    @GetMapping("/showPageText/{id}")
    public ResponseEntity<Page> showPageText(@PathVariable Long id){
        Page page = showPageService.findPageById(id);
        return new ResponseEntity<>(page,HttpStatus.OK);
    }
//    @GetMapping("")
//    public ResponseEntity<List<Account>> getAll() {
//        return new ResponseEntity<>(iAccountServiceSearch.getAll(), HttpStatus.OK);
//    }
}

