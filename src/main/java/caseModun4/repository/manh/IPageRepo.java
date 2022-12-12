package caseModun4.repository.manh;

import caseModun4.model.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPageRepo extends CrudRepository<Page,Long> {

    Page findPageById(long id);

//    Page deletePageById(long id);
}
