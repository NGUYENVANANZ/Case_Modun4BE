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

    @Query(nativeQuery = true,value = "SELECT * from notification where account_id = :id and account1_id = :id1")
    List<Notification> Notification(@Param("id") long id,@Param("id1") long id1);

    @Query(nativeQuery = true,value = "SELECT * from notification where account_id = :account_id and page_id = :idPage")
    List<Notification> getNotificationBy(@Param("account_id") long account_id,@Param("idPage") long idPage);

    @Query(nativeQuery = true,value = "SELECT * from notification where page_id = :id")
    List<Notification> listNotification1(@Param("id") long id);

}
