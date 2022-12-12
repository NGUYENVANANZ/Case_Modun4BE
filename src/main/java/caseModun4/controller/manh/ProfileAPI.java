package caseModun4.controller.manh;

import caseModun4.model.Account;
import caseModun4.model.Page;
import caseModun4.model.PageStatus;
import caseModun4.model.dto.PageDTO;
import caseModun4.repository.IAccountRepo;
import caseModun4.repository.an.IPage;
import caseModun4.repository.an.IPageStatus;
import caseModun4.service.JwtService;
import caseModun4.service.an.AnService;
import caseModun4.service.manh.IFriendService;
import caseModun4.service.manh.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/profiles")
public class ProfileAPI {
  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  JwtService jwtService;

  @Autowired
  IAccountRepo iAccountRepo;

  @Autowired
  ProfileService profileService;
  @Autowired
  IFriendService iFriendService;

  @Autowired
  IPageStatus iPageStatus;

  @Autowired
  IPage iPage;


  @GetMapping("/profile")
  public  ResponseEntity<Account> findById() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Account account = profileService.findaccountsbyname(userDetails.getUsername());
    return new ResponseEntity<>(account ,HttpStatus.OK);
  }


  @GetMapping("/pageProfile")
  public  ResponseEntity<List<Page>> postProfile() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Account account = profileService.findaccountsbyname(userDetails.getUsername());
    List<Page> page = profileService.pageList(account.getId());
    return new ResponseEntity<>(page ,HttpStatus.OK);
  }


  @PostMapping("/post")
  public ResponseEntity<Page> checkUser(@RequestBody Page page ){
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Account account = profileService.findaccountsbyname(userDetails.getUsername());
    Page page1 = page;
    page1.setAccount(account);
    page1.setTime(LocalDateTime.now());
    page1.setCmts(null);
    page1.setLikePages(null);
    iPage.save(page);
    return new ResponseEntity<>(page ,HttpStatus.OK);
  }

  @GetMapping("/deletepost/{id}")
  public ResponseEntity<Page> delete (@PathVariable long id){
    profileService.deletePageById(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/geteditpost/{id}")
  public ResponseEntity<Page> getPage(@PathVariable long id){
    Page page =profileService.findPageById(id);
    return new ResponseEntity<>(page,HttpStatus.OK);
  }

  @PostMapping("/edit/{id}&{idStatus}")
  public ResponseEntity<Page> edit(@RequestBody PageDTO page2, @PathVariable long id, @PathVariable long idStatus){
    Page page1 = profileService.findPageById(id);
    PageStatus pageStatus = iPageStatus.findById(idStatus).get();

    page1.setText(page2.getText());
    page1.setImg(page2.getImg());
    page1.setTime(LocalDateTime.now());
    page1.setPageStatus(pageStatus);

    iPage.save(page1);
    return new ResponseEntity<>(page1,HttpStatus.OK);
  }
}
