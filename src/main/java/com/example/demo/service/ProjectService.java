package com.example.demo.service;

import com.example.demo.dto.ProjectInfo;
import com.example.demo.entity.ProjectEntity;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
//    JSONArray getById(Long id);

    List<ProjectInfo> getById(Integer id);
}
