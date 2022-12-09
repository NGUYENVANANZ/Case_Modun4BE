package caseModun4.service.dinh.impl;

import caseModun4.model.LikePage;
import caseModun4.repository.dinh.ILikePageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikePageService implements ILikePageService{
    @Autowired
    ILikePageRepo iLikePageRepo;

    @Override
    public void save(LikePage likePage) {
        iLikePageRepo.save(likePage);
    }

    @Override
    public void delete(long id) {
        iLikePageRepo.deleteById(id);
    }
}
