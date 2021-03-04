package com.pip.controller;

import com.pip.dao.ParagraphDAO;
import com.pip.entity.Author;
import com.pip.entity.Image;
import com.pip.entity.Paragraph;
import com.pip.entity.Post;
import com.pip.service.ServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class AdminRestController {
    @PostMapping(value = "/insertpost", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> add_new_post(@RequestBody Post post) throws ParseException {
        post.setDate(getCurrentTime());
        ServiceImpl service = new ServiceImpl();
        int author_id = service.getIdbyUsername(AdminController.session);
        service.CreateNewPost(post, author_id);
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    @PostMapping(value = "/add_paragraph", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> add_paragraph(@RequestBody Paragraph paragraph) {
        ServiceImpl service = new ServiceImpl();
        service.CreateNewParagraph(paragraph);
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    @PostMapping(value = "/add_image", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> add_image(@RequestBody Image image) {
        ServiceImpl service = new ServiceImpl();
        service.CreateNewImage(image);
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/updatepost", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> update_post(@RequestBody Post post) {
        ServiceImpl service = new ServiceImpl();
        service.UpdatePost(post, post.getId());
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/update_paragraph", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> update_paragraph(@RequestBody Paragraph paragraph)  {
        ServiceImpl service = new ServiceImpl();
        service.UpdateParagraph(paragraph, paragraph.getId());
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    @PutMapping(value = "/update_image", consumes = MediaType.ALL_VALUE)
    public ResponseEntity<String> update_image(@RequestBody Image image)  {
        ServiceImpl service = new ServiceImpl();
        service.UpdateImage(image, image.getId());
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }


    public Date getCurrentTime() throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();
        Date date1=new SimpleDateFormat("yyyy/MM/dd").parse(dtf.format(now));
        return date1;
    }
}
