package caseModun4.repository;


import caseModun4.model.Account;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

@Repository
public interface IAccountRepo extends CrudRepository<Account, Long> {
    @Query(nativeQuery = true, value = "select * from account where full_name like concat ('%',:name,'%');")
    Account findByUsername(String username);

}
