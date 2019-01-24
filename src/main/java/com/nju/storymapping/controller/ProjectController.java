package com.nju.storymapping.controller;

import com.nju.storymapping.entity.Project;
import com.nju.storymapping.respository.ProjectRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @PostMapping("/addproject")
    public String addProject(@RequestBody Project project) {
        //保存计划
       projectRepository.save(project);
       return null;
    }

    @PostMapping("/projectlist")
    public List<Project> projectList() {
        List<Project> projects = projectRepository.findAll();
        return projects;
    }

    @GetMapping("/viewproject")
    public Project viewProject(@RequestParam long id) {
        Optional<Project> pro = projectRepository.findById(id);
        return pro.get();
    }
}
