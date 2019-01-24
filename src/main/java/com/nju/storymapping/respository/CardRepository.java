package com.nju.storymapping.respository;

import com.nju.storymapping.entity.Card;
import com.nju.storymapping.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {

}
