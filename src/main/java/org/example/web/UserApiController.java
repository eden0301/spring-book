package org.example.web;

import lombok.RequiredArgsConstructor;
import org.example.service.users.UsersService;
import org.example.web.dto.UsersSaveRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

  private final UsersService usersService;

  @PostMapping("/api/v1/users")
  public Long save(@RequestBody UsersSaveRequestDto requestDto) {
    return usersService.save(requestDto);
  }
}
