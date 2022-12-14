package caseModun4.repository.an;

import caseModun4.model.Cmt;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IComment extends CrudRepository<Cmt, Long> {
}
