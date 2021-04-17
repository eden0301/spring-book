package org.example.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가
@Entity
// Entity 클래스에서는 절대 'setter'를 만들지 않음
public class Posts { // DB와 매칭될 클래스 == Entity 클래스

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // @Column 굳이 사용하는 이유? 기본값 외에 추가로 수정할 사항이 있을 경우
  // VARCHAR(255) -> 500 등
  @Column(length = 500, nullable = false)
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  private String author;

  @Builder // 해당 클래스의 빌더 패턴 클래스 생성
  // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
  public Posts(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
