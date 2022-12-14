package caseModun4.repository.linh;

import caseModun4.model.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPageSearchRepo extends PagingAndSortingRepository<Page,Long> {
    @Query(nativeQuery = true, value = "SELECT * FROM page WHERE text LIKE concat('%',:text,'%')")
    List<Page> findByText(@Param("text") String text);
}
