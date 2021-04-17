package org.example.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.domain.users.Users;

@Getter
@NoArgsConstructor
public class UsersSaveRequestDto {
  private String name;

  @Builder
  public UsersSaveRequestDto(String name) {
    this.name = name;
  }

  public Users toEntity() {
    return Users.builder()
                .name(name)
                .build();
  }
}
