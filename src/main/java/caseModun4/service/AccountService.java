package caseModun4.service;


import caseModun4.model.Account;
import caseModun4.model.Role;
import caseModun4.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    IAccountRepo iAccountRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = iAccountRepo.findByUsername(username);
        List<Role> roles = new ArrayList<>();
        roles.add(account.getRoles());
        if (account != null) {
            return new User(account.getUsername(), account.getPassword(), roles);
        }
        return null;
    }


    public List<Account> getAll() {
        return (List<Account>) iAccountRepo.findAll();
    }

    public Account findByName(String name) {
        return iAccountRepo.findByUsername(name);
    }

}
