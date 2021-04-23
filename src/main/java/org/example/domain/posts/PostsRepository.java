package org.example.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// Dao 같은 DB Layer 접근자 => <Entity명, PK타입>
public interface PostsRepository extends JpaRepository<Posts, Long> {

  @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
  List<Posts> findAllDesc();
}
