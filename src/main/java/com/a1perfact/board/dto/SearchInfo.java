package com.a1perfact.board.dto;

import lombok.Getter;

import java.util.Optional;

@Getter
public class SearchInfo {
    Boolean isFiltered = false;
    String searchWord = "";

    public SearchInfo(Optional<String> title, Optional<String> nickname) {
        if (title.isPresent()) {
            this.isFiltered = true;
            this.searchWord = title.get();
        }
        if (nickname.isPresent()) {
            this.isFiltered = true;
            this.searchWord = nickname.get();
        }
    }
}
