package caseModun4.repository.dinh;

import caseModun4.model.LikeCmt;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ILikeCmtRepo extends CrudRepository<LikeCmt, Long> {
//    @Query(nativeQuery = true, value = "SELECT id.LikeCmt FROM Cmt c WHERE c.id = :id ")
}
