package com.a1perfact.board.service;

import com.a1perfact.board.dto.Post;
import com.a1perfact.board.dto.PostSaveForm;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PostService {

    private Map<Integer, Post> postMap = new HashMap<>();
    private int postId = 1;
    private int maxPostPerPage = 10;
    private String autoCompleteNickname = "";

    public Map<Integer, Post> getPostList(int page, Optional<String> title, Optional<String> nickname) {
        if (title.isPresent()) {
            return getPostOnPage(filterPostByTitle(title.get()), page);
        }
        if (nickname.isPresent()) {
            return getPostOnPage(filterPostByNickname(nickname.get()), page);
        }
        return getPostOnPage(postMap, page);
    }

    public int[] getPageList() {
        return IntStream.rangeClosed(1, (int) (Math.ceil(postMap.size() / 11.0))).toArray();
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

    private Map<Integer, Post> filterPostByTitle(String title) {
        return postMap.entrySet().stream()
                .filter(entry -> entry.getValue().getTitle().equals(title))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<Integer, Post> filterPostByNickname(String nickname) {
        return postMap.entrySet().stream()
                .filter(entry -> entry.getValue().getNickname().equals(nickname))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private Map<Integer, Post> getPostOnPage(Map<Integer, Post> map, int page) {
        int start = maxPostPerPage * (page - 1);
        int end = Math.min(maxPostPerPage * page, map.size());
        Map<Integer, Post> postMapOnPage = new HashMap<>();
        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = start; i < end; i++) {
            postMapOnPage.put(keys.get(i), map.get(keys.get(i)));
        }
        return postMapOnPage;
    }
}
