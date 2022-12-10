package caseModun4.service.manh;

import caseModun4.model.Account;
import caseModun4.model.Page;
import caseModun4.repository.IAccountRepo;
import caseModun4.repository.an.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProfileService {

  @Autowired
  IAccountRepo iAccountRepo;

  @Autowired
  IPage iPage;


  public Account findaccountsbyname (String username){
    return iAccountRepo.findByUsername(username);
  }

  public List<Page> pageList(long id){
    return (List<Page>) iPage.Page2(id);
  }

}
