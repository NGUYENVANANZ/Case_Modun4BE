package caseModun4.service.linh;

import caseModun4.model.Page;
import caseModun4.repository.linh.IPageSearchRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceSearch implements IPageServiceSearch{
    @Autowired
    IPageSearchRepo iPageSearchRepo;
    @Override
    public List<Page> getAll() {
        return (List<Page>) iPageSearchRepo.findAll();
    }

    @Override
    public List<Page> findByText(String text) {
        return iPageSearchRepo.findByText(text);
    }
}
