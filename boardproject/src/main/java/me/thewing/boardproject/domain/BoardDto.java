package me.thewing.boardproject.domain;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class BoardDto {

    private Integer seq;

    @Length(min=2, message = "제목은 2자 이상 입력하세요")
    private String title;

    @NotEmpty(message = "내용을 입력하세요")
    private String content;

    @NotEmpty(message = "작성자을 입력하세요")
    private String writer;

    private Integer password;

    private String regdate;

    private Integer cnt;

}
