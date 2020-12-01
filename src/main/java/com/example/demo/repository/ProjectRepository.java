package com.example.demo.repository;

import com.example.demo.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Integer> {

    @Query(value = "select NAME, USER_NAME, SKILL_NAME from PROJECT p inner join USERS U on p.ID = U.PROJECT_ID inner join SKILL S on S.ID = U.SKILL_ID where p.ID = :id", nativeQuery = true)
    Map<String, Map<String, String>> findById(@Param("id") Long id);

}
