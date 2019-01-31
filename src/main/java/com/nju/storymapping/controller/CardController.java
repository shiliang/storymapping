package com.nju.storymapping.controller;

import com.nju.storymapping.entity.Card;
import com.nju.storymapping.respository.CardRepository;
import com.nju.storymapping.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

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

    @PostMapping("/cardlistbydate")
    public HashMap<String, Object> cardlistByDate() throws ParseException {

        LinkedList<Integer> adddata = new LinkedList<>();
        LinkedList<Integer> donedata = new LinkedList<>();
        HashMap<String, Object> map = new HashMap<>();
        Date dt = new Date();
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        Date date = rightNow.getTime();
        for (int i = 0; i < 10; i++) {
            int addcount = cardRepository.countByDateAndStatusIsAdd(date);
            int donecount = cardRepository.countByDateAndStatusIsDone(date);
            adddata.add(addcount);
            donedata.add(donecount);
            rightNow.add(Calendar.DAY_OF_MONTH, -1);
            date = rightNow.getTime();
        }
        map.put("adddt",adddata);
        map.put("donedt",donedata);
        return map;
    }

    @GetMapping("/getCardIncharge")
    public List<Card> cardInChargeList(@RequestParam long id) {
        ArrayList<Card> cardList = cardService.getCardIncharge(id);
        return cardList;
    }
}
