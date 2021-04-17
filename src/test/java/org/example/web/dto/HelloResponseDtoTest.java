package org.example.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

  @Test
  public void lombokTest() {
    // given
    String name = "test";
    int amount = 1000;

    // when
    HelloResponseDto dto = new HelloResponseDto(name, amount);

    // then
    // assertThat : 검증하고 싶은 대상을 메소드로 받음
    assertThat(dto.getName()).isEqualTo(name); // 값이 같은지
    assertThat(dto.getAmount()).isEqualTo(amount);
  }
}
