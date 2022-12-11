package caseModun4.repository.an;

import caseModun4.model.Friend;
import caseModun4.model.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IFriend extends CrudRepository<Friend, Long> {
    @Query(nativeQuery = true,value = "SELECT * from friend where account_id = :id")
    List<Friend> listFriend(@Param("id") long id);

    @Query(nativeQuery = true,value = "SELECT * from friend where account_id = :id and account1_id = :id1")
    Friend Friend(@Param("id") long id, @Param("id1") long id1);

}
