package com.nju.storymapping.respository;

import com.nju.storymapping.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Query("select count(c) from Card c where c.date <= ?1")
    int countByDate(Date date);

    @Query("select count(c) from Card c where c.date <= ?1 and c.status = 'end'")
    int countByDateAndStatusIsDone(Date date);

    @Query("select count(c) from Card c where c.date <= ?1 and c.status = 'add'")
    int countByDateAndStatusIsAdd(Date date);
}
