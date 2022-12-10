package caseModun4.service.dinh.impl;

import caseModun4.model.LikeCmt;
import caseModun4.repository.dinh.ILikeCmtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeCmtService implements ILikeCmtService {
    @Autowired
    ILikeCmtRepo iLikeCmtRepo;


    @Override
    public void save(LikeCmt likeCmt) {
        iLikeCmtRepo.save(likeCmt);
    }



    public void delete(long id) {
        iLikeCmtRepo.deleteById(id);
    }
}
