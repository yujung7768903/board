package com.a1perfact.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Post {

    private String title;
    private String nickname;
    private String content;
    private boolean isImportant;

    public Post(PostSaveForm postSaveForm) {
        this.title = postSaveForm.getTitle();
        this.nickname = postSaveForm.getNickname();
        this.content = postSaveForm.getContent();
        this.isImportant = postSaveForm.getIsImportant();
    }

}
