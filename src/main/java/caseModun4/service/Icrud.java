package caseModun4.service;

import java.util.List;

public interface Icrud<E> {
    void save();
    List<E> getAll();
    void Delete(long id);
    E finByID(long id);
}
