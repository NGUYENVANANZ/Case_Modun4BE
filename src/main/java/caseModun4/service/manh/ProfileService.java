package caseModun4.service.manh;

import caseModun4.model.Account;
import caseModun4.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class ProfileService {

  @Autowired
  IAccountRepo iAccountRepo;


  public String accounts (String username){
    return iAccountRepo.profile(username);
  }


}
