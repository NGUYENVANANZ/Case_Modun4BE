package caseModun4.service.yen;

public interface ICommentsCrudService<C> {
    void save(C c);
    void delete(long id);
}
