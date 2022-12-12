package caseModun4.controller.dinh;

import caseModun4.model.Account;
import caseModun4.model.LikePage;
import caseModun4.model.Page;
import caseModun4.repository.an.IPage;
import caseModun4.service.dinh.impl.LikePageService;
import caseModun4.service.dinh.profileUser.ProfileUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ListAccountLike {
    @Autowired
    ProfileUserService profileUserService;
    @Autowired
    LikePageService likePageService;
    @Autowired
    IPage iPage;

    @GetMapping("/likePage/{id}")
    public ResponseEntity<List<LikePage>> listLike(@PathVariable long id){
        Page page = iPage.Page1(id);
        return new ResponseEntity<>(page.getLikePages(),  HttpStatus.OK);
    }
}
