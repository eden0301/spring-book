package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.service.users.UsersService;
import org.example.web.dto.UsersSaveRequestDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UserApiController {

  private final UsersService usersService;

  @GetMapping("/api/v1/users")
  public Long save(@RequestBody UsersSaveRequestDto requestDto) {
    return usersService.save(requestDto);
  }
}
