package caseModun4.repository.linh;

import caseModun4.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISearchRepo extends PagingAndSortingRepository<Account, Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE full_name LIKE concat('%',:name,'%')")
    List<Account> findByName(@Param("name") String name);
}
