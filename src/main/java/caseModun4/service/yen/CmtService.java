package caseModun4.service.yen;



import caseModun4.model.Cmt;
import caseModun4.model.Page;
import caseModun4.repository.yen.CmtRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CmtService {

    @Autowired
    CmtRepo cmtRepo;


    public void save() {

    }

    public List<Cmt> getAll() {
        return (List<Cmt>) cmtRepo.findAll();
    }


    public void Delete(long id) {
        cmtRepo.deleteById(id);
    }


    public Cmt finByID(long id) {
        return finByID(id);
    }
    public Iterable<Cmt> findAllByPage(Page page) {
        return cmtRepo.findAllByPage(page);
    }
    public Iterable<Cmt> findAll() {
        return cmtRepo.findAll();
    }
}

