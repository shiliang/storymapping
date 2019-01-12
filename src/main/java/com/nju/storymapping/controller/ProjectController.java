package com.nju.storymapping.controller;

import com.nju.storymapping.domain.Project;
import com.nju.storymapping.respository.ProjectRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping("/project")
    public String addProject(@RequestBody Project project) {
        //保存计划
       Project pro =  projectRepository.save(project);

       return "hello project";
//               ResponseEntity.created(new URI("/api/project" + pro.getId()))
//               .headers().body(pro);

    }
}
