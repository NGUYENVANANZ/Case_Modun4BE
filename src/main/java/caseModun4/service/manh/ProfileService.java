package caseModun4.service.manh;

import caseModun4.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class PageService {

  @Autowired
  IAccountRepo iAccountRepo;

  public String accounts (String username){
    return iAccountRepo.profile(username);
  }
}
