package me.thewing.boardproject.domain;

import lombok.*;

@Getter
@ToString
@Builder
public class BoardDto {

    private String title;

    private String content;

    private String writer;

    private Integer password;

    private String regdate;

    private Integer cnt;

}
