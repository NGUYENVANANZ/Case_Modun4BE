package caseModun4.controller.an;


import caseModun4.model.Account;
import caseModun4.model.Cmt;
import caseModun4.model.LikeCmt;
import caseModun4.model.Page;
import caseModun4.repository.an.IComment;
import caseModun4.repository.an.IPage;
import caseModun4.service.an.AnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class CommentAPI {
    @Autowired
    AnService anService;
    @Autowired
    IPage iPage;

    @Autowired
    IComment iComment;

    @GetMapping("/pageComment/{idPage}")
    public ResponseEntity<List<Cmt>> pageCmt(@PathVariable long idPage) {
        Page page = iPage.findById(idPage).get();
        List<Cmt> cmts = page.getCmts();
        return new ResponseEntity<>(cmts, HttpStatus.OK);
    }

    @GetMapping("/deleteCmt/{idPage}&{idCmt}")
    public ResponseEntity<Boolean> deleteCmt(@PathVariable long idPage, @PathVariable long idCmt) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = anService.account(userDetails.getUsername());
        Page page = iPage.findById(idPage).get();
        Cmt cmt = null;
        for (int i = 0; i < page.getCmts().size(); i++) {
            if (page.getCmts().get(i).getId() == idCmt) {
                cmt = page.getCmts().get(i);
            }
        }
        assert cmt != null;
        if (cmt.getAccounts() == account) {
            page.getCmts().remove(cmt);
            iPage.save(page);
            iComment.delete(cmt);
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.OK);
    }


    @GetMapping("/saveCmt/{idPage}&{text}")
    public ResponseEntity<Page> saveCmt(@PathVariable long idPage, @PathVariable String text) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = anService.account(userDetails.getUsername());
        List<LikeCmt> likeCmts = new ArrayList<>();
        Cmt cmt = new Cmt(text, account, likeCmts);
        iComment.save(cmt);
        Page page = iPage.findById(idPage).get();

        List<Cmt> cmts = page.getCmts();
        cmts.add(cmt);

        page.setCmts(cmts);
        iPage.save(page);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping("/edit/{idCmt}")
    public ResponseEntity<Cmt> editCmt(@PathVariable long idCmt) {
        return new ResponseEntity<>(iComment.findById(idCmt).get(), HttpStatus.OK);
    }

    @PostMapping("/edit/{idCmt}&{text}")
    public ResponseEntity<Cmt> editCmt1(@PathVariable long idCmt, @PathVariable String text) {
        Cmt cmt = iComment.findById(idCmt).get();
        cmt.setText(text);
        iComment.save(cmt);
        return new ResponseEntity<>(cmt, HttpStatus.OK);
    }
}
