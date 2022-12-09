package caseModun4.service.linh;

import caseModun4.model.Account;
import caseModun4.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceSearch implements IAccountServiceSearch {
    @Autowired
    IAccountRepo iAccountRepo;


    @Override
    public List<Account> findByName(String name) {
        return (List<Account>) iAccountRepo.findAll();
    }

    @Override
    public List<Account> getAll() {
        return null;
    }
}
