package caseModun4.service.linh;

import caseModun4.model.Account;


import java.util.List;

public interface IAccountServiceSearch extends ICRUD_Service<Account> {
    List<Account> findByName(String name);
}
