package caseModun4.repository.dinh;

import caseModun4.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IProfileUserRepo extends CrudRepository<Account, Long> {
    @Query(nativeQuery = true,value = "SELECT * from account where id = :id")
    Account profileUser(@Param("id") long id);

}
