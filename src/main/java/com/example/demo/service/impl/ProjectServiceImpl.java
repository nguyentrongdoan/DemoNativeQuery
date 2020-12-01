package com.example.demo.service.impl;

import com.example.demo.dto.ProjectInfo;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import org.hibernate.Session;
import org.hibernate.transform.AliasToBeanResultTransformer;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EntityManager em;
//    @Override
//    public ProjectInfo getById(Long id) {
//        Map<String, Map<String, String>> objects = projectRepository.findById(id);
//        ProjectInfo projectInfo = new ProjectInfo();
//        return null;
//    }

    public List<ProjectInfo> getById(Integer id) {
//         em.createNativeQuery(
//                "select NAME, USER_NAME, SKILL_NAME from PROJECT p inner join USERS U on p.ID = U.PROJECT_ID inner join SKILL S on S.ID = U.SKILL_ID where p.ID = :id" )
//                .setParameter("id", id)
//                .getResultList().stream();



        List<ProjectInfo> results = ((Session)this.em.getDelegate()).createSQLQuery("select   NAME as name , USER_NAME as userName, SKILL_NAME as skillName from PROJECT p inner join USERS U on p.ID = U.PROJECT_ID inner join SKILL S on S.ID = U.SKILL_ID where p.ID = :id").setParameter( "id",id)
                .addScalar("name").addScalar("userName").addScalar("skillName")
                .setResultTransformer(new AliasToBeanResultTransformer(ProjectInfo.class)).list();
        return results;

    }

//    @Override
//    public Optional<ProjectEntity> getById(Long id) {
//        return projectRepository.findById(id);
//    }

//    private static final String SELECT_CUSTOMER_NAME = "select project.name, user.userName, ";

//    @Override
//    public JSONArray getById(Long id) {
//        return null;
//    }
}
