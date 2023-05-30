package pochemon.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pochemon.enums.Action;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreTransactionDTO {
	Integer id;
	Integer userId;
	Integer cardId;
	Action action;
	Date timeSt;
}
