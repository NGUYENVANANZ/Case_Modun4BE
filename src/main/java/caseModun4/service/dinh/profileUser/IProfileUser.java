package caseModun4.service.dinh.profileUser;

public interface IProfileUser <A>{
    A getAll();
    A findById(long id);
    void save(A a);
}
