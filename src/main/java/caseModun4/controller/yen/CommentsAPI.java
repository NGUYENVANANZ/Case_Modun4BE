package caseModun4.controller.yen;


import caseModun4.model.Account;
import caseModun4.model.Cmt;
import caseModun4.model.Page;
import caseModun4.model.dto.CmtDto;
import caseModun4.repository.an.IPage;
import caseModun4.repository.yen.CmtRepo;
import caseModun4.service.an.AnService;
import caseModun4.service.yen.CmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class CommentsAPI {

    @Autowired
    IPage iPage;

    @Autowired
    CmtRepo cmtRepo;
    @Autowired
    CmtService cmtService;

    @Autowired
    AnService anService;

    // lấy ra tất cả cmt của bài viết
    @GetMapping("/comments/{idPage}")
    public ResponseEntity<Page> getAllCmtPage(@PathVariable long idPage) {
        Page page = iPage.Page1(idPage);
//        List<Cmt> cmts = page.getCmts();
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    // comment 1 bài viết
    @PostMapping("/{idPage}")
    public ResponseEntity save(@RequestBody CmtDto cmt, @PathVariable long idPage) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = anService.account(userDetails.getUsername());

        Cmt cmt1 = new Cmt(account, cmt.getText(), null);
        cmtRepo.save(cmt1);

        Page page = iPage.Page1(idPage);
        page.getCmts().add(cmt1);
        iPage.save(page);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @GetMapping("/{name}")
//    public ResponseEntity<List<Cmt>> findByName(@PathVariable long id){
//        return new ResponseEntity<>(cmtService.findById(id), HttpStatus.OK);
//    }
}
