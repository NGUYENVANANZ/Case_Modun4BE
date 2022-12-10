package caseModun4.service.dinh.profileUser;

import caseModun4.model.Account;
import caseModun4.repository.dinh.IProfileUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileUserService implements IProfileService {
    @Autowired
    IProfileUserRepo iProfileUserRepo;


    public Account getAll1(long id) {
        return iProfileUserRepo.profileUser(id);
    }

    @Override
    public Account getAll() {
        return null;
    }
}
