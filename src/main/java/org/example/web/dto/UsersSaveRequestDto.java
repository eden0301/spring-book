package org.example.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.users.Users;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
  private String name;
  private Integer age;

  @Builder
  public UsersSaveRequestDto(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public Users toEntity() {
    return Users.builder()
                .name(name)
                .age(age)
                .build();
  }
}
