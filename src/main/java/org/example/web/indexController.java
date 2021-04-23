package org.example.web;

import com.sun.org.apache.xpath.internal.operations.Mod;
import lombok.RequiredArgsConstructor;
import org.example.domain.posts.Posts;
import org.example.service.posts.PostsService;
import org.example.service.users.UsersService;
import org.example.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class indexController {

  private final PostsService postsService;
  private final UsersService usersService;

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("posts", postsService.findAllDesc());
    model.addAttribute("users", usersService.findAllDesc());
    return "index";
  }

  @GetMapping("posts/save")
  public String postsSave() {
    return "posts/posts-save";
  }

  @GetMapping("users/insert")
  public String insertUser() {
    return "users/insert";
  }

  @GetMapping("posts/update/{id}")
  public String pustsUpdate(@PathVariable Long id, Model model) {
    PostsResponseDto posts = postsService.findById(id);
    model.addAttribute("posts", posts);
    return "posts/posts-update";
  }
}
