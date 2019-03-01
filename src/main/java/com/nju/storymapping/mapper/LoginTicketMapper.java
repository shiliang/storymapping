package com.nju.storymapping.mapper;

import com.nju.storymapping.entity.LoginTicket;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface LoginTicketMapper {

    @Insert("INSERT INTO login_ticket(userid, expired, status, ticket)" +
            "VALUES (#{userId},#{expired},#{status},#{ticket})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addTicket(LoginTicket ticket);

    @Select("SELECT id,userid, expired, status, ticket FROM login_ticket  " +
            "WHERE ticket = #{ticket}")
    LoginTicket selectByTicket(String ticket);

    @Update("UPDATE login_ticket SET status = #{status} WHERE ticket=#{ticket}")
    void updateStatus(@Param("ticket") String ticket, @Param("status") int status);

    @Select("SELECT ticket FROM login_ticket WHERE userid = #{userId}")
    String getTicketByUserId(@Param("userId") long userId);
}
