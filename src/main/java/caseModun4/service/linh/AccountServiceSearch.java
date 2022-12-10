package caseModun4.service.linh;

import caseModun4.model.Account;
import caseModun4.repository.IAccountRepo;
import caseModun4.repository.linh.ISearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceSearch implements IAccountServiceSearch {
    @Autowired
    ISearchRepo iSearchRepo;


    @Override
    public List<Account> findByName(String name) {
        return iSearchRepo.findByName(name);
    }

    @Override
    public List<Account> getAll() {
        return (List<Account>) iSearchRepo.findAll() ;
    }
}
