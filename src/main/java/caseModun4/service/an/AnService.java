package caseModun4.service.an;

import caseModun4.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnService {
    @Autowired
    IAccountRepo iAccountRepo;

    public String accountImg(String username){
        return iAccountRepo.accountImg(username);
    }
}
