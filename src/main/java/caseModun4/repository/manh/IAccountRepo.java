package caseModun4.repository.manh;


import caseModun4.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface IAccountRepo extends CrudRepository<Account, Long> {
    Account findByUsername(String username);
}
