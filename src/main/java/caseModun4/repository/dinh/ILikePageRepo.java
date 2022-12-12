package caseModun4.repository.dinh;

import caseModun4.model.LikePage;
import caseModun4.model.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ILikePageRepo extends CrudRepository<LikePage, Long> {
    @Query(nativeQuery = true,value = "SELECT * from like_page where accounts_id = :id")
    LikePage likePage(@Param("id") long id);


}

