package caseModun4.service.yen;


import caseModun4.model.Cmt;
import caseModun4.model.Page;
import caseModun4.service.Icrud;

import java.util.Optional;

public interface ICmtService extends Icrud<Cmt> {
    Iterable<Cmt> findAllByPage(Page page);

    Iterable<Cmt> findAll();

    Optional<Cmt> findById(Long id);
}
