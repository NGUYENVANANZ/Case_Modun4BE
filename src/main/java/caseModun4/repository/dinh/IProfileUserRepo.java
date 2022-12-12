package caseModun4.repository.dinh;

import caseModun4.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IProfileUserRepo extends CrudRepository<Account, Long> {
    @Query(nativeQuery = true,value = "SELECT * from account where id = :id")
    Account profileUser(@Param("id") long id);

    @Query(nativeQuery = true, value = "SELECT * from like_page where accounts_id = :id")
    List<Account> listLike(@Param("id") long id);
}
