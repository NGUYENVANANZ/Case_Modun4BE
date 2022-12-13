package caseModun4.repository.manh;

import caseModun4.model.Friend;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface IFriendRepo extends PagingAndSortingRepository<Friend,Long> {

    @Query(nativeQuery = true,value = "SELECT * from friend where account_id = :id")
    List<Friend> findAllById(long id);
}
