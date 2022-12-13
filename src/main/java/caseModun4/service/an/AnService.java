package caseModun4.service.an;

import caseModun4.model.*;
import caseModun4.repository.IAccountRepo;
import caseModun4.repository.an.IFriend;
import caseModun4.repository.an.INotification;
import caseModun4.repository.an.IPage;
import caseModun4.repository.an.IPageStatus;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<Friend> friends = iFriend.listFriend2(account.getId());
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            accounts.add(iAccountRepo.findAccountById(friends.get(i).getAccount1().getId()));
        }
        return accounts;
    }

    public List<Account> friends(long id1, long id2) {
        List<Friend> friends = iFriend.listFriend(id1);
        List<Friend> friends1 = iFriend.listFriend(id2);
        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < friends.size(); i++) {
            for (int j = 0; j < friends1.size(); j++) {
                if (friends.get(i).getAccount1().getId() == friends1.get(j).getAccount1().getId()){
                    accounts.add(iAccountRepo.findAccountById(friends.get(i).getAccount1().getId()));
                }
            }
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

    public Notification notifications(long id1, long id2, long id3) {
        List<Notification> notifications = iNotification.listNotification(id1);

        for (Notification n : notifications
        ) {
            if (n.getAccount1().getId() == id2 && n.getPage().getId() == id3) {
                return n;
            }
        }
        return null;
    }

    public Notification notificationAddFriend(long id1, long id2, long id3) {
        List<Notification> notifications = iNotification.Notification(id1, id2);
        Notification notification = null;
        for (Notification n : notifications) {
            if (n.getNotificationType().getId() == id3) {
                notification = n;
            }
        }
        return notification;
    }

    public Friend addFriend(Account account, Account friend) {
        FriendStatus friendStatus = new FriendStatus(2, "NotFriend");
        Friend friends = new Friend(account, friend, friendStatus);
        return friends;
    }

    public void newFriend(Account account, Account friend) {
        FriendStatus friendStatus = new FriendStatus(1, "Friend");
        Friend friends = iFriend.Friend(account.getId(), friend.getId());
        friends.setFriendStatus(friendStatus);
        iFriend.save(friends);

        Friend friend1 = iFriend.Friend(friend.getId(), account.getId());
        friend1.setFriendStatus(friendStatus);
        iFriend.save(friend1);
    }

    public void unFriend(Account account, Account friend) {
        Friend friends = iFriend.Friend(account.getId(), friend.getId());
        iFriend.deleteById(friends.getId());

        Friend friend1 = iFriend.Friend(friend.getId(), account.getId());
        iFriend.deleteById(friend1.getId());
    }

}


