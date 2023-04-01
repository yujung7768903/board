package com.a1perfact.board.service;

import com.a1perfact.board.dto.Post;
import com.a1perfact.board.dto.PostSaveForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private List<Post> postList = new ArrayList<>();

    public List<Post> getPostList() {
        return postList;
    }

    public void savePost(PostSaveForm postSaveForm) {
        postList.add(new Post(postSaveForm));
    }

}
