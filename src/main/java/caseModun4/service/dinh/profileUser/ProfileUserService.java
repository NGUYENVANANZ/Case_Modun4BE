package caseModun4.service.dinh.profileUser;

import caseModun4.model.Account;
import caseModun4.model.Page;
import caseModun4.repository.an.IPage;
import caseModun4.repository.dinh.IProfileUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileUserService implements IProfileService {
    @Autowired
    IProfileUserRepo iProfileUserRepo;
    @Autowired
    IPage iPage;


    public Account getAll1(long id) {
        return iProfileUserRepo.profileUser(id);
    }

    public List<Account> listLike(long id){
        return  (List<Account>) iProfileUserRepo.listLike(id);
    }

    @Override
    public Account getAll() {
        return null;
    }

    @Override
    public Account findById(long id) {
        return iProfileUserRepo.findById(id).get();
    }

    @Override
    public void save(Account account) {
        iProfileUserRepo.save(account);
    }

    public List<Page> pageList(long id){
        return iPage.Page3(id);
    }
}
