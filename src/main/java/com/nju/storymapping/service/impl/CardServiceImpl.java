package com.nju.storymapping.service.impl;

import com.nju.storymapping.entity.Card;
import com.nju.storymapping.mapper.CardMapper;
import com.nju.storymapping.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;

    @Override
    public ArrayList<Card> getCardIncharge(long userId) {
        return cardMapper.getCardIncharge(userId);
    }
}
