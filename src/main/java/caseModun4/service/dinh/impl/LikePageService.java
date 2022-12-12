package caseModun4.service.dinh.impl;

import caseModun4.model.LikeCmt;
import caseModun4.model.LikePage;
import caseModun4.model.Page;
import caseModun4.repository.an.IPage;
import caseModun4.repository.dinh.ILikePageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikePageService implements ILikePageService{
    @Autowired
    ILikePageRepo iLikePageRepo;

    @Autowired
    IPage iPage;

    @Override
    public void save(LikePage likePage) {
        iLikePageRepo.save(likePage);
    }


    public void delete(long id) {
       iLikePageRepo.likePage(id);
    }

    public LikePage likePage(long id) {
        return iLikePageRepo.likePage(id);
    }

    public Page newLike(long id){
        return iPage.Page1(id);
    }

    public List<LikePage> listLikePage (long id_page){
        return iPage.Page1(id_page).getLikePages();
    }
}
