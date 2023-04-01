package com.a1perfact.board.controller;

import com.a1perfact.board.dto.Post;
import com.a1perfact.board.dto.PostSaveForm;
import com.a1perfact.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public String getPostList(Model model) {
        List<Post> postList = postService.getPostList();
        model.addAttribute("postList", postList);
        return "post-list";
    }

    @GetMapping("/post/new")
    public String writePost() {
        return "post-write";
    }

    @PostMapping("/post")
    public String savePost(PostSaveForm postSaveForm) {
        postService.savePost(postSaveForm);
        return "redirect:/";
    }
}
