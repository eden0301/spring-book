package org.example.service.users;

import lombok.RequiredArgsConstructor;
import org.example.domain.users.UsersRepository;
import org.example.web.dto.UsersSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UsersService {
  private final UsersRepository usersRepository;

  @Transactional
  public Long save(UsersSaveRequestDto requestDto) {
    return usersRepository.save(requestDto.toEntity()).getId();
  }
}
