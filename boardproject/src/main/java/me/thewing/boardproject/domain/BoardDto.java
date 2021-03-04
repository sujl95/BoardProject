package me.thewing.boardproject.domain;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class BoardDto {

	private Integer seq;

	@Length(min = 2, message = "제목은 2자 이상 입력하세요")
	private String title;

	@NotEmpty(message = "내용을 입력하세요")
	private String content;

	@NotEmpty(message = "작성자을 입력하세요")
	private String writer;

	private Integer password;

	private String regdate;

	private Integer cnt;

}

