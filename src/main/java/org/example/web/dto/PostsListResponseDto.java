package org.example.web.dto;

import lombok.Getter;
import org.example.domain.posts.Posts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class PostsListResponseDto {

  private Long id;
  private String title;
  private String author;
  private String content;
  private String updatedDate;

  public PostsListResponseDto(Posts entity) {
    this.id = entity.getId();
    this.title = entity.getTitle();
    this.author = entity.getAuthor();
    this.content = entity.getContent();
    this.updatedDate =  entity.getUpdatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//    int idx = entity.getUpdatedDate().toString().indexOf("T");
//    this.updatedDate = entity.getUpdatedDate().toString().substring(0, idx);
  }
}
