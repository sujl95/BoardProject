package me.thewing.boardproject.domain;

import lombok.*;

@Getter
@ToString
@Builder
@AllArgsConstructor
public class BoardDto {

    private Integer seq;

    private String title;

    private String content;

    private String writer;

    private Integer password;

    private String regdate;

    private Integer cnt;

}
