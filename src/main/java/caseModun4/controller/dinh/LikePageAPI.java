package caseModun4.controller.dinh;

import caseModun4.model.Account;
import caseModun4.model.LikePage;
import caseModun4.model.Page;
import caseModun4.model.dto.PostDTO;
import caseModun4.repository.an.IPage;
import caseModun4.service.JwtService;
import caseModun4.service.an.AnService;
import caseModun4.service.dinh.impl.ILikePageService;
import caseModun4.service.dinh.impl.LikePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LikePageAPI {
    @Autowired
    JwtService jwtService;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    ILikePageService iLikePageService;
    @Autowired
    AnService anService;

    @Autowired
    LikePageService likePageService;

    @Autowired
    IPage iPage;

    @PostMapping("/page/{id_page}")
    public ResponseEntity<PostDTO> likePage(@PathVariable long id_page) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = anService.account(userDetails.getUsername());

        LikePage likePage = likePageService.likePage(account.getId());

        Page page = likePageService.newLike(id_page);


        for (int i = 0; i < page.getLikePages().size(); i++) {
            if (likePage == page.getLikePages().get(i)) {
                PostDTO postDTO = new PostDTO(page, false);
                page.getLikePages().remove(i);
                iPage.save(page);
                return new ResponseEntity<>(postDTO, HttpStatus.OK);
            }
        }
        PostDTO postDTO = new PostDTO(page, true);
        page.getLikePages().add(likePage);
        iPage.save(page);
        return new ResponseEntity<>(postDTO, HttpStatus.OK);
    }

}
