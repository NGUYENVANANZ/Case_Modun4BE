package caseModun4.service.manh;

import caseModun4.model.Account;
import caseModun4.model.Page;
import caseModun4.repository.IAccountRepo;
import caseModun4.repository.an.IPage;
import caseModun4.repository.manh.IPageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class ProfileService {

  @Autowired
  IAccountRepo iAccountRepo;

  @Autowired
  IPage iPage;

  @Autowired
  IPageRepo iPageRepo;


  public Account findaccountsbyname (String username){
    return iAccountRepo.findByUsername(username);
  }

  public List<Page> pageList(long id){
    return (List<Page>) iPage.Page2(id);
  }


  public Page findPageById(long id){
    return iPageRepo.findPageById(id);
  }

  public void deletePageById(long id){
    iPageRepo.deleteById(id);
  }


}
