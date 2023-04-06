package com.a1perfact.board.service;

import com.a1perfact.board.dto.Post;
import com.a1perfact.board.dto.PostSaveForm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostService {

    private Map<Integer, Post> postMap = new HashMap<>();
    private Integer postId = 1;
    private String autoCompleteNickname = "";

    public Map<Integer, Post> getPostList(Optional<String> title, Optional<String> nickname) {
        if (title.isPresent()) {
            return getPostByTitle(title.get());
        }
        if (nickname.isPresent()) {
            return getPostByNickname(nickname.get());
        }
        return postMap;
    }

    public Post getPost(Integer postId) {
        return postMap.get(postId);
    }

    public Map<Integer, Post> getPostByTitle(String title) {
        return postMap.entrySet().stream()
                .filter(entry -> entry.getValue().getTitle().equals(title))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public Map<Integer, Post> getPostByNickname(String nickname) {
        return postMap.entrySet().stream()
                .filter(entry -> entry.getValue().getNickname().equals(nickname))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public String getAutoCompleteNickname() {
        return autoCompleteNickname;
    }

    public void savePost(PostSaveForm postSaveForm) {
        postMap.put(postId, new Post(postSaveForm));
        autoCompleteNickname = postSaveForm.getNickname();
        postId++;
    }

    public void deletePost(Integer postId) {
        postMap.remove(postId);
    }

}
