package pochemon.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StoreOrderDTO {
	Integer id;
	Integer userId;
	Integer cardId;
	Float price;
}
