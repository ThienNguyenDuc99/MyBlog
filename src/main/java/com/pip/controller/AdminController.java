package com.pip.controller;


import com.pip.entity.Author;
import com.pip.entity.Image;
import com.pip.entity.Paragraph;
import com.pip.entity.Post;
import com.pip.service.ServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@SessionAttributes("author")
public class AdminController {

    public static String session = "";
    public static Author sessionAuthor;

    @GetMapping("/")
    public String home() {
        if(!session.equals("")){
            return "new-post";
        }
        else return "home";
    }

    @GetMapping("/listpost")
    public String listpost(Model theModel) {
        ServiceImpl service = new ServiceImpl();
        int author_id = service.getIdbyUsername(AdminController.session);
        List<Post> posts = service.getListPost(author_id);
        theModel.addAttribute("posts", posts);
        return "list-post";
    }

    @GetMapping("/new-post")
    public String newPost(@SessionAttribute("author") Author author, Model theModel) {
        session = author.getUsername();
        theModel.addAttribute("author", author);
        return "new-post";
    }

    @GetMapping("/logout")
    public String logout() {
        session = "";
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login(Model theModel) {
        Author author = new Author();
        theModel.addAttribute("author", author);
        return "login";
    }

    @PostMapping("/adminlogin")
    public String adminlogin(@ModelAttribute("author") Author author) {
        sessionAuthor = author;
        ServiceImpl service = new ServiceImpl();
        boolean check = service.login(author.getPassword(), author.getUsername());
        if (check) return "redirect:/new-post";

        else return "login";
    }

    @GetMapping("/delete_post/")
    public String deletePost(@RequestParam("postId") int id) {

        ServiceImpl service = new ServiceImpl();
        // delete the customer
        service.deletePost(id);

        return "redirect:/listpost";
    }

    @GetMapping("/editpost")
    public String updatePost(@RequestParam("postId") int id, Model theModel) {

        ServiceImpl service = new ServiceImpl();
        List<Post> posts = service.getPost_byID(id);
        List<Image> images = service.getListPost_byPostId1(id);
        List<Paragraph> paragraphs = service.getListParagraph_byPostId(id);
        theModel.addAttribute("posts", posts);
        theModel.addAttribute("images", images);
        theModel.addAttribute("paragraphs", paragraphs);

        return "edit-post";
    }

    @ModelAttribute("author")
    public Author session() {
        return new Author();
    }

}
