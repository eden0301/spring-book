package org.example.web;

import junit.framework.TestCase;
import org.example.domain.users.Users;
import org.example.domain.users.UsersRepository;
import org.example.web.dto.UsersSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest extends TestCase {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private UsersRepository usersRepository;

  @After
  public void tearDown() {
    usersRepository.deleteAll();
  }

  @Test
  public void 사용자_등록() {
    // given
    String name = "eden";
    UsersSaveRequestDto requestDto = UsersSaveRequestDto.builder()
                                                        .name(name)
                                                        .build();
    String url = "http://localhost:" + port + "/api/v1/users";

    // when
    ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

    // then
    assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(responseEntity.getBody()).isGreaterThan(0L);
    List<Users> all = usersRepository.findAll();
    assertThat(all.get(0).getName()).isEqualTo(name);
  }
}