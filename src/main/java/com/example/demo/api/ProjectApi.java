package com.example.demo.api;

import com.example.demo.dto.ProjectInfo;
import com.example.demo.entity.ProjectEntity;
import com.example.demo.service.impl.ProjectServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProjectApi {
    @Autowired
    private ProjectServiceImpl projectService;
    @GetMapping("/project/{id}")
    public List<ProjectInfo> getProject(@PathVariable("id")Integer id) {
        return projectService.getById(id);
    }
}
