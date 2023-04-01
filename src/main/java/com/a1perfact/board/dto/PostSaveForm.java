package com.a1perfact.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostSaveForm {

    private String title;
    private String nickname;
    private String content;
    private boolean isImportant;

}
