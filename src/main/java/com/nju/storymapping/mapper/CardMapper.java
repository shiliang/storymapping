package com.nju.storymapping.mapper;

import com.nju.storymapping.entity.Card;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@Mapper
public interface CardMapper {

    @Select("SELECT * FROM card WHERE person_in_charge_id = #{userId}")
    @Results({@Result(property = "personInChargeId", column = "person_in_charge_id"),
    @Result(property = "personCreateId", column = "person_create_id")})
    public ArrayList<Card> getCardIncharge(long userId);
}
