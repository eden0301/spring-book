package org.example.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users, Long> {

  @Query("SELECT u FROM Users u ORDER BY u.id DESC")
  List<Users> findAllDesc();
}
