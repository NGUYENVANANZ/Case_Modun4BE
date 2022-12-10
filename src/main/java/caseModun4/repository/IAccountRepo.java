package caseModun4.repository;


import caseModun4.model.Account;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAccountRepo extends CrudRepository<Account, Long> {

    Account findByUsername(String username);

    Account findAccountById(long id);


}
