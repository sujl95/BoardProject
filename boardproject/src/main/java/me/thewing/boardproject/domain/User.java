package me.thewing.boardproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Long id;
	private String userId;
	private NameAndNickName nameAndNickName;
}