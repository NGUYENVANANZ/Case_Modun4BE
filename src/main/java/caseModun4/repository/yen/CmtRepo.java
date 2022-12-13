package caseModun4.repository.yen;



import caseModun4.model.Cmt;
import caseModun4.model.Page;
import caseModun4.model.PageStatus;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CmtRepo extends PagingAndSortingRepository<Cmt,Long> {
    @Query(nativeQuery = true, value = "select * from cmt order by id DESC ;")
//    List<Cmt> findALlByTimeDESC(PageStatus pageStatus);
//    Iterable<Cmt> findAllByPageStatus(PageStatus pageStatus);
    Iterable<Cmt> findAllByPage(Page page);
}
