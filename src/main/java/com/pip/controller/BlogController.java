package com.pip.controller;

import com.pip.entity.Author;
import com.pip.entity.Paragraph;
import com.pip.entity.Post;
import com.pip.service.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BlogController {
    @GetMapping("/blog")
    public String home(Model theModel) {
        ServiceImpl service = new ServiceImpl();
        List<Post> posts = service.getPosts();
        theModel.addAttribute("posts", posts);
        return "blog";
    }

/*    @PostMapping("/id-post")
    public String id_post(@RequestBody Post post, Model theModel) {
        ServiceImpl service = new ServiceImpl();
        List<Paragraph> paragraphs = service.getListParagraph_byPostId(post.getId());
        theModel.addAttribute("paragraph", paragraphs);
        return "post";
    }*/

    @GetMapping("/show-post")
    public String showPost(@RequestParam("id") int id, Model theModel) {
        ServiceImpl service = new ServiceImpl();
        List<Paragraph> paragraphs = service.getListParagraph_byPostId(id);
        theModel.addAttribute("paragraphs", paragraphs);
        return "post";
    }

    @GetMapping("/search")
    public String search(@RequestParam("q") String q, Model theModel) {
        ServiceImpl service = new ServiceImpl();
        List<Post> posts = service.searchPost(q);
        theModel.addAttribute("posts", posts);
        return "search";
    }

}
