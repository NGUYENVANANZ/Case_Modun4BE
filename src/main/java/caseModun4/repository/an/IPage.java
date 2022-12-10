package caseModun4.repository.an;

import org.springframework.stereotype.Repository;

import caseModun4.model.Account;
import caseModun4.model.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPage extends CrudRepository<Page, Long> {
    @Query(nativeQuery = true,value = "SELECT * from page where account_id = :id and (page_status_id = 1 or page_status_id = 2)")
    List<Page> Page(@Param("id") long id);


    @Query(nativeQuery = true,value = "SELECT * from page where id = :id")
    Page Page1(@Param("id") long id);



}
