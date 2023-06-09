package com.a1perfact.board.controller;

import com.a1perfact.board.dto.Post;
import com.a1perfact.board.dto.PostSaveForm;
import com.a1perfact.board.dto.SearchInfo;
import com.a1perfact.board.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/")
    public String getPostList(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam("title") Optional<String> title,
            @RequestParam("nickname") Optional<String> nickname,
            Model model
    ) {
        model.addAttribute("postMap", postService.getPostList(page, title, nickname));
        model.addAttribute("searchInfo", new SearchInfo(title, nickname));
        model.addAttribute("pageList", postService.getPageList());
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
    public String savePost(@Valid final PostSaveForm postSaveForm, final BindingResult bindingResult, final ModelMap map) {
        if (!bindingResult.hasErrors()) {
            postService.savePost(postSaveForm);
        }
        map.clear();
        return "redirect:/";
    }

    @DeleteMapping("/post/{postId}")
    public String deletePost(@PathVariable Integer postId) {
        postService.deletePost(postId);
        return "redirect:/";
    }
}
