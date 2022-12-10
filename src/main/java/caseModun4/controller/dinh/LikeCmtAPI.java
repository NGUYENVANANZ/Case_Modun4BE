package caseModun4.controller.dinh;

import caseModun4.model.LikeCmt;
import caseModun4.model.LikePage;
import caseModun4.service.JwtService;
import caseModun4.service.dinh.impl.ILikeCmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class LikeCmtAPI {
    @Autowired
    JwtService jwtService;

    @Autowired
    ILikeCmtService iLikeCmtService;

    @PostMapping("/Cmt")
    public ResponseEntity<LikeCmt> likePage(@RequestBody LikeCmt likeCmt){
        iLikeCmtService.save(likeCmt);
        return new ResponseEntity<>(likeCmt, HttpStatus.OK);
    }


    @GetMapping("/Cmt/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable long id){
        iLikeCmtService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
