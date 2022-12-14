package caseModun4.service.linh;


import caseModun4.model.Page;
import caseModun4.repository.an.IPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;

@Service
public class ShowPageService {

    @Autowired
    IPage iPage;

    public Page findPageById(long id){
        return iPage.Page1(id);
    }
}
