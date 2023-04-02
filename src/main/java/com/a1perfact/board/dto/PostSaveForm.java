package com.a1perfact.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostSaveForm {

    private String title;
    private String nickname;
    private String content;
    private Boolean isImportant;

}
