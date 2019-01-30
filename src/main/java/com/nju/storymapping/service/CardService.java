package com.nju.storymapping.service;

import com.nju.storymapping.entity.Card;

import javax.validation.OverridesAttribute;
import java.util.ArrayList;

public interface CardService {

    ArrayList<Card> getCardIncharge(long userId);
}
