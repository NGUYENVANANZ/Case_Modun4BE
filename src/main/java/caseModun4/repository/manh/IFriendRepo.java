package caseModun4.repository.manh;

import caseModun4.model.Account;
import caseModun4.model.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

import java.util.List;

public interface IFriendRepo extends PagingAndSortingRepository<Friend,Long> {
    @Query(nativeQuery = true,value = "SELECT * from friend where account_id = :id")
    List<Friend> findAllById(long id);

    @Query(nativeQuery = true, value = "SELECT * FROM friend WHERE full_name LIKE concat('%',:name,'%')")
    List<Friend> searchByName(@Param("name") String name);


}
