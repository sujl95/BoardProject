package me.thewing.boardproject.domain;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class BoardDto {

	private final Integer seq;

	@Length(min = 2, message = "제목은 2자 이상 입력하세요")
	private final String title;

	@NotEmpty(message = "내용을 입력하세요")
	private final String content;

	@NotEmpty(message = "작성자을 입력하세요")
	private final String writer;

	private final Integer password;

	private final String regdate;

	private final Integer cnt;

}
