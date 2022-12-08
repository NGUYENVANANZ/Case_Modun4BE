package caseModun4.repository.manh;


import caseModun4.model.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepo extends CrudRepository<Account, Long> {

    @Query(nativeQuery = true,value = "SELECT img from account where username = :username")
    String accountImg(@Param("username") String username);
    Account findByUsername(String username);
}
