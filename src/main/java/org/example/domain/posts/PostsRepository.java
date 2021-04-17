package org.example.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// Dao 같은 DB Layer 접근자 => <Entity명, PK타입>
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
