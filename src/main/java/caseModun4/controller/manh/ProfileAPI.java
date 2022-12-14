package caseModun4.controller.manh;

import caseModun4.model.Account;

import caseModun4.model.Friend;

import caseModun4.model.Notification;

import caseModun4.model.Page;
import caseModun4.model.PageStatus;
import caseModun4.model.dto.PageDTO;
import caseModun4.repository.IAccountRepo;
import caseModun4.repository.an.INotification;
import caseModun4.repository.an.IPage;
import caseModun4.repository.an.IPageStatus;
import caseModun4.repository.linh.ISearchRepo;
import caseModun4.repository.manh.IFriendRepo;
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
import org.w3c.dom.Notation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "/profiles")
public class ProfileAPI {
  @Autowired
  ProfileService profileService;
  @Autowired
  IFriendRepo iFriendRepo;

 @Autowired
  ISearchRepo iSearchRepo;


  @Autowired
  IPageStatus iPageStatus;

  @Autowired
  IPage iPage;

  @Autowired
  INotification iNotification;


  @GetMapping("/profile")
  public ResponseEntity<Account> findById() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Account account = profileService.findaccountsbyname(userDetails.getUsername());
    return new ResponseEntity<>(account, HttpStatus.OK);
  }


  @GetMapping("/pageProfile")
  public ResponseEntity<List<Page>> postProfile() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Account account = profileService.findaccountsbyname(userDetails.getUsername());
    List<Page> page = profileService.pageList(account.getId());
    return new ResponseEntity<>(page, HttpStatus.OK);
  }


  @PostMapping("/post")
  public ResponseEntity<Page> checkUser(@RequestBody Page page) {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Account account = profileService.findaccountsbyname(userDetails.getUsername());
    Page page1 = page;
    page1.setAccount(account);
    page1.setTime(LocalDateTime.now());
    page1.setCmts(null);
    page1.setLikePages(null);
    iPage.save(page);
    return new ResponseEntity<>(page, HttpStatus.OK);
  }

  @GetMapping("/deletepost/{id}")
  public ResponseEntity<Page> delete(@PathVariable long id) {
    List<Notification> notations = iNotification.listNotification1(id);
    iNotification.deleteAll(notations);
    Page page = iPage.Page1(id);
    iPage.delete(page);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  @GetMapping("/geteditpost/{id}")
  public ResponseEntity<Page> getPage(@PathVariable long id) {
    Page page = profileService.findPageById(id);
    return new ResponseEntity<>(page, HttpStatus.OK);
  }

  @PostMapping("/edit/{id}&{idStatus}")
  public ResponseEntity<Page> edit(@RequestBody PageDTO page2, @PathVariable long id, @PathVariable long idStatus) {
    Page page1 = profileService.findPageById(id);
    PageStatus pageStatus = iPageStatus.findById(idStatus).get();
    page1.setText(page2.getText());
    page1.setImg(page2.getImg());
    page1.setTime(LocalDateTime.now());
    page1.setPageStatus(pageStatus);
    iPage.save(page1);
    return new ResponseEntity<>(page1,HttpStatus.OK);
  }

  @GetMapping("/friendProfile")

  public ResponseEntity<List<Friend>> friends() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Account account = profileService.findaccountsbyname(userDetails.getUsername());
    List<Friend> friends = iFriendRepo.findAllById(account.getId());
    List<Friend> friends1 = new ArrayList<>();
    for (int i = 0; i < friends.size(); i++) {
      if (friends.get(i).getFriendStatus().getId()==1){
        friends1.add(friends.get(i));
      }
    }
    return new ResponseEntity<>(friends1, HttpStatus.OK);
  }


  @GetMapping("/searchfriends/{name}")
  public ResponseEntity<List<Friend>> friendssearch(@PathVariable String name){
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    Account account = profileService.findaccountsbyname(userDetails.getUsername());
    List<Account> accountList = iSearchRepo.findByName(name);
    List<Friend> listfriends = iFriendRepo.findAllById(account.getId());
    List<Friend> friends1 = new ArrayList<>();
    for (int i = 0; i < listfriends.size(); i++) {
      for (int y=0 ; y<accountList.size();y++){
        if (accountList.get(y).getId()==listfriends.get(i).getAccount1().getId() && listfriends.get(i).getFriendStatus().getId()==1){
          friends1.add(listfriends.get(i));
        }
      }
    }
    return new ResponseEntity<>(friends1,HttpStatus.OK);
  }

    @PostMapping("/share/{id}")
    public ResponseEntity<Page> friendssearch(@PathVariable long id){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Account account = profileService.findaccountsbyname(userDetails.getUsername());
        Page page = iPage.Page1(id);
        Page page1 = new Page();
        page1.setTime(LocalDateTime.now());
        page1.setCmts(null);
        page1.setText(page.getText());
        page1.setImg(page.getImg());
        page1.setLikePages(null);
        page1.setAccount(account);
        page1.setPageStatus(page.getPageStatus());
        iPage.save(page1);
        return new ResponseEntity<>(page1,HttpStatus.OK);
    }
}