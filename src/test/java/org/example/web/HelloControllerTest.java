package org.example.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // Spring - Junit 연결자
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

  @Autowired // Bean 주입
  private MockMvc mvc; // 시작점

  @Test
  public void hello() throws Exception {
    String hello = "hello";

    mvc.perform(get("/hello")) // MockMvc를 통해 해당 주소로 HTTP GET 요청
          .andExpect(status().isOk()) // HTTP status 검증 -> 즉 ok, 200인지 아닌지 검증
          .andExpect(content().string(hello)); // 컨드롤러에서 hello를 리턴하는데 이 값이 맞는지 검증
  }

  @Test
  public void helloDto() throws Exception {
    String name = "hello";
    int amount = 1000;

    mvc.perform(get("/hello/dto")
                .param("name", name) // API 요청 파라미터 - String만 가능
                .param("amount", String.valueOf(amount)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.name", is(name))) // JSON 응답값을 필드별로 검증
        .andExpect(jsonPath("$.amount", is(amount)));
  }
}
