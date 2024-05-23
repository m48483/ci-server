package com.example.devops.global;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<Board, Long> {
    @Modifying
    @Query("delete from Board b where b.id = :id")
    int delById(@Param("id") long id);
}
