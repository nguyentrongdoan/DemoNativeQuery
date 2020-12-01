//package com.example.demo.repository.impl;
//
//import com.example.demo.dto.ProjectInfo;
//import com.example.demo.repository.ProjectRepository;
//import org.hibernate.Session;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//@Repository
//public class ProjectRepositoryImpl implements ProjectRepository {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public ProjectInfo findById(Long id) {
//        Session session = entityManager.unwrap(org.hibernate.Session.class);
//        String sql = "select p.name, U.userName, S.skillName from ProjectEntity p inner join UserEntity U on p.id = U.projectId inner join SkillEntity S on S.id = U.skillId where p.id = :id";
//        ProjectInfo projectInfo = (ProjectInfo)session.createQuery(sql).setParameter("id", id);
//        return projectInfo;
//    }
//}
