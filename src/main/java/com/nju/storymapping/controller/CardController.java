package com.nju.storymapping.controller;

import com.nju.storymapping.entity.Card;
import com.nju.storymapping.respository.CardRepository;
import com.nju.storymapping.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CardService cardService;

    @PostMapping("/addcard")
    public String addCard(@RequestBody Card newCard) {
        cardRepository.save(newCard);
        return null;
    }

    @GetMapping("/editcard")
    public String editCard(@RequestParam long id) {
        Optional<Card> oldCard = cardRepository.findById(id);
        return null;

    }

    @GetMapping("/delcard")
    public String delCard(@RequestParam long id) {
        cardRepository.deleteById(id);
        return null;
    }

    @GetMapping("/viewcard")
    public Card viewCard(@RequestParam long id) {
        Optional<Card> card = cardRepository.findById(id);
        return card.get();
    }

    @PostMapping("/cardlist")
    public List<Card> cardList() {
        List<Card> cardList = cardRepository.findAll();
        return cardList;
    }

    @GetMapping("/getCardIncharge")
    public List<Card> cardInChargeList(@RequestParam long id) {
        ArrayList<Card> cardList = cardService.getCardIncharge(id);
        return cardList;

    }
}
