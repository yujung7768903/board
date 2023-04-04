package com.a1perfact.board.controller;

import com.a1perfact.board.dto.Post;
import com.a1perfact.board.dto.PostSaveForm;
import com.a1perfact.board.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Map;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public String getPostList(Model model) {
        Map<Integer, Post> postMap = postService.getPostList();
        model.addAttribute("postMap", postMap);
        return "post-list";
    }

    @GetMapping("/post/{postId}")
    public String getPost(@PathVariable Integer postId, Model model) {
        Post post = postService.getPost(postId);
        model.addAttribute("post", post);
        return "post-read";
    }

    @GetMapping("/post/new")
    public String writePost(final PostSaveForm postSaveForm, Model model) {
        String autoCompleteNickname = postService.getAutoCompleteNickname();
        model.addAttribute("autoCompleteNickname", autoCompleteNickname);
        return "post-write";
    }

    @PostMapping("/post")
    public String savePost(final PostSaveForm postSaveForm, final BindingResult bindingResult, final ModelMap map) {
        if (bindingResult.hasErrors()) {
            return "post-write";
        }
        postService.savePost(postSaveForm);
        map.clear();
        return "redirect:/";
    }

    @DeleteMapping("/post/{idListStr}")
    public String deletePost(@PathVariable String idListStr) {
        String[] idList = idListStr.split(",");
        return "redirect:/";
    }
}
