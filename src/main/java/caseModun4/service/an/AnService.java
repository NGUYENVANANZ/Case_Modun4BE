package caseModun4.service.an;

import caseModun4.model.*;
import caseModun4.repository.IAccountRepo;
import caseModun4.repository.an.IFriend;
import caseModun4.repository.an.INotification;
import caseModun4.repository.an.IPage;
import caseModun4.repository.an.IPageStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AnService {
    @Autowired
    IAccountRepo iAccountRepo;

    @Autowired
    IPage iPage;

    @Autowired
    IFriend iFriend;

    @Autowired
    IPageStatus iPageStatus;

    @Autowired
    INotification iNotification;


    public Account account(String username) {
        return iAccountRepo.findByUsername(username);
    }

    public Account account(long id) {
        return iAccountRepo.findAccountById(id);
    }


    public List<Account> friends(String username) {
        Account account = iAccountRepo.findByUsername(username);
        List<Friend> friends = iFriend.listFriend(account.getId());
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            accounts.add(iAccountRepo.findAccountById(friends.get(i).getAccount1().getId()));
        }
        return accounts;
    }


    public List<Page> homePage(String username) {
        Account account = iAccountRepo.findByUsername(username);
        List<Page> pages = iPage.Page(account.getId());
        List<Friend> friends = iFriend.listFriend(account.getId());
        for (int i = 0; i < friends.size(); i++) {
            pages.addAll(iPage.Page(friends.get(i).getAccount1().getId()));
        }
        pages.sort(Comparator.comparing(Page::getTime));
        Collections.reverse(pages);
        return pages;
    }


    public List<PageStatus> statuses() {
        return (List<PageStatus>) iPageStatus.findAll();
    }

    public List<Notification> notifications(String username) {
        Account account = iAccountRepo.findByUsername(username);
        return iNotification.listNotification(account.getId());

    }

<<<<<<< HEAD
=======

>>>>>>> 5b9faf81485697a304ca13a6364d5dc2730d903d
}


