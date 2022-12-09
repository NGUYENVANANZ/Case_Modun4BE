package caseModun4.controller.dinh;

import caseModun4.model.LikePage;
import caseModun4.service.JwtService;
import caseModun4.service.dinh.impl.ILikePageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

    @PostMapping("/Page/{id}")
    public ResponseEntity<LikePage> likePage(@RequestBody LikePage likePage){
        iLikePageService.save(likePage);
        return new ResponseEntity<>(likePage, HttpStatus.OK);
    }


    @GetMapping("/Page/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable long id){
        iLikePageService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
