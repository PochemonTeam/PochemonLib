package com.dto;

import java.util.Date;

import com.enums.Action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
