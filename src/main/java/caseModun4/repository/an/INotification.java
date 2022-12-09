package caseModun4.repository.an;

import caseModun4.model.Friend;
import caseModun4.model.Notification;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface INotification extends CrudRepository<Notification, Long> {
    @Query(nativeQuery = true,value = "SELECT * from notification where account_id = :id")
    List<Notification> listNotification(@Param("id") long id);
}
