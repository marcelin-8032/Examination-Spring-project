package com.examination.project.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.Accessors;

import static lombok.AccessLevel.PRIVATE;

@Accessors(fluent = true)
@AllArgsConstructor(access = PRIVATE)
public enum Module {

	MODULE_1 ("Module1"),
	MODULE_2 ("Module2"),
	MODULE_3 ("Module3");

	@Getter
	private String message;


}
