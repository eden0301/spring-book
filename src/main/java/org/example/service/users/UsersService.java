package org.example.service.users;

import lombok.RequiredArgsConstructor;
import org.example.domain.users.Users;
import org.example.domain.users.UsersRepository;
import org.example.web.dto.UsersListResposeDto;
import org.example.web.dto.UsersSaveRequestDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UsersService {
  private final UsersRepository usersRepository;

  @Transactional
  public Long save(UsersSaveRequestDto requestDto) {
    return usersRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional(readOnly = true)
  public List<UsersListResposeDto> findAllDesc() {
    return usersRepository.findAllDesc().stream()
            .map(UsersListResposeDto::new)
            .collect(Collectors.toList());
  }
}
