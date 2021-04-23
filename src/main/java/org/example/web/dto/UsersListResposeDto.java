package org.example.web.dto;

import lombok.Getter;
import org.example.domain.users.Users;

import java.time.format.DateTimeFormatter;

@Getter
public class UsersListResposeDto {

  private Long id;
  private String name;
  private Integer age;
  private String updatedDate;

  public UsersListResposeDto(Users entity) {
    this.id = entity.getId();
    this.name = entity.getName();
    this.age = entity.getAge();
    this.updatedDate = entity.getUpdatedDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
  }



}
