package caseModun4.repository.an;

import caseModun4.model.PageStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPageStatus extends CrudRepository<PageStatus, Long> {

}
