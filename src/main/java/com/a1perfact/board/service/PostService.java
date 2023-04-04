package com.a1perfact.board.service;

import com.a1perfact.board.dto.Post;
import com.a1perfact.board.dto.PostSaveForm;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PostService {

    private Map<Integer, Post> postMap = new HashMap<>();
    private Integer postId = 1;
    private String autoCompleteNickname = "";

    public Map<Integer, Post> getPostList() {
        return postMap;
    }

    public Post getPost(Integer postId) {
        return postMap.get(postId);
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
