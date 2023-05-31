package pochemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import pochemon.dto.CardDTO;

import java.util.ArrayList;
import java.util.List;

public class CardWebService {

    public CardDTO getCard(Integer id) {
        return new CardDTO();
    }

    public Boolean editCard(CardDTO cardDto) {
        return true;
    }

    public Boolean removeCard(CardDTO cardDto) {
        return true;
    }

    public Boolean addCard(CardDTO cardDto) {
        return true;
    }

    public List<CardDTO> getAllCardsToSell() {
        return new ArrayList<>();
    }

    public List<CardDTO> getAllCards() {
        return new ArrayList<>();
    }

    public List<CardDTO> getAllCardsByUser(Integer id) {
        return new ArrayList<>();
    }
}
