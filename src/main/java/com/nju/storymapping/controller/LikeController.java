package com.nju.storymapping.controller;

import com.nju.storymapping.entity.HostHolder;
import com.nju.storymapping.entity.User;
import com.nju.storymapping.utility.EntityType;
import com.nju.storymapping.utility.JedisAdapter;
import com.nju.storymapping.utility.RedisKeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
public class LikeController {
    @Autowired
    JedisAdapter jedisAdapter;
    @Autowired
    HostHolder hostHolder;

    @RequestMapping(value = "/likeCard", method = RequestMethod.POST)
    @ResponseBody
    public long likeHandle(@RequestParam(value = "cardId") long cardId) {
        User user = hostHolder.getUser();
        long count = 0;
        count = like((int) user.getId(), EntityType.CARD.getIndex(), (int) cardId);
        return count;
    }

    @RequestMapping(value = "/dislikeCard", method = RequestMethod.POST)
    @ResponseBody
    public long dislikeHandle(@RequestParam(value = "cardId") long cardId) {
        User user = hostHolder.getUser();
        long count = 0;
        count = disLike((int) user.getId(), EntityType.CARD.getIndex(), (int) cardId);
        return count;
    }

    @RequestMapping(value = "/likeCardCount", method = RequestMethod.POST)
    @ResponseBody
    public long getLikeCount(@RequestParam(value = "cardId") long cardId) {
        String likeKey = RedisKeyUtil.getLikeKey(EntityType.CARD.getIndex(), (int) cardId);
        return jedisAdapter.scard(likeKey);

    }

    @RequestMapping(value = "/disLikeCardCount", method = RequestMethod.POST)
    @ResponseBody
    public long getdisLikeCount(@RequestParam(value = "cardId") long cardId) {
        String disLikeKey = RedisKeyUtil.getDislikeKey(EntityType.CARD.getIndex(), (int) cardId);
        return jedisAdapter.scard(disLikeKey);

    }


    //返回喜欢的人数
    public long like(int userId, int entityType, int entityId) {
        String likeKey = RedisKeyUtil.getLikeKey(entityType, entityId);
        jedisAdapter.sadd(likeKey, String.valueOf(userId));

        String disLikeKey = RedisKeyUtil.getDislikeKey(entityType, entityId);
        jedisAdapter.srem(disLikeKey, String.valueOf(userId));

        return jedisAdapter.scard(likeKey);
    }



    //返回不喜欢的人数
    public long disLike(int userId, int entityType, int entityId) {
        String disLikeKey = RedisKeyUtil.getDislikeKey(entityType, entityId);
        jedisAdapter.sadd(disLikeKey, String.valueOf(userId));

        String likeKey = RedisKeyUtil.getLikeKey(entityType, entityId);
        jedisAdapter.srem(likeKey, String.valueOf(userId));

        return jedisAdapter.scard(likeKey);
    }

}
