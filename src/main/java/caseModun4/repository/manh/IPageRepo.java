package caseModun4.repository.manh;

import caseModun4.model.Friend;
import caseModun4.model.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPageRepo extends CrudRepository<Page,Long> {

    Page findPageById(long id);


    @Query(nativeQuery = true,value = "SELECT * from friend where account_id = :id")
    List<Friend> findAllById(long id);

//    Page deletePageById(long id);
}
