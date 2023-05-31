package pochemon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pochemon.dto.CardDTO;
import pochemon.dto.StoreOrderDTO;
import pochemon.dto.StoreTransactionDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreWebService {

    public Boolean sellCard(StoreOrderDTO storeOrderDTO) {
        return true;
    }

    public boolean buyCard(StoreOrderDTO storeOrderDTO) {
        return true;
    }

    public List<StoreTransactionDTO> getAllTransactions() {
        return new ArrayList<>();
    }

    public List<StoreOrderDTO> getAllOrders() {
        return new ArrayList<>();
    }
}
