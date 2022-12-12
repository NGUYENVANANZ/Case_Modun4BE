package caseModun4.repository;


import caseModun4.model.Account;
import caseModun4.model.Friend;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepo extends CrudRepository<Account, Long> {


    @Query(nativeQuery = true,value = "SELECT img from account where username = :username")
    String accountImg(@Param("username") String username);

    @Query(nativeQuery = true,value = "SELECT * from account where username = :username")
    String profile(@Param("username") String username);

    @Query(nativeQuery = true,value = "SELECT * from account where phone_number = :phoneNumber")
    Account findByPhoneNumber(String phoneNumber);
    Account findByUsername(String username);

    Account findAccountById(long id);


}
