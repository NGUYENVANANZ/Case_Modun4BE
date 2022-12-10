package caseModun4.service.manh;

import caseModun4.model.Friend;
import caseModun4.repository.manh.IFriendRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FriendService implements IFriendService{

    @Autowired
    IFriendRepo iFriendRepo;
    @Override
    public void save(Friend friend) {

    }

    @Override
    public List<Friend> getAll() {
        return (List<Friend>) iFriendRepo.findAll();
    }

    @Override
    public void Delete(long id) {

    }

    @Override
    public Friend finByID(long id) {
        return null;
    }
}
