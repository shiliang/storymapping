package com.nju.storymapping.controller;

import com.nju.storymapping.entity.Project;
import com.nju.storymapping.entity.User;
import com.nju.storymapping.respository.ProjectRepository;
import com.nju.storymapping.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/projectlist")
    public List<Project> projectList(@RequestParam long userid) {
        Optional<User> user = userRepository.findById(userid);
        List<Project> projects = projectRepository.findAllByUser(user.get());
        return projects;
    }

    @PostMapping("/addproject")
    public String addproject(@RequestBody Project project) {
        //保存项目
        projectRepository.save(project);
        return null;
    }

    @PostMapping("/projectlist")
    public List<Project> projectList() {
        List<Project> projects = projectRepository.findAll();
        return projects;
    }

    @GetMapping("/viewproject")
    public Project viewproject(@RequestParam long id) {
        Optional<Project> pro = projectRepository.findById(id);
        return pro.get();
    }

    @GetMapping("/projectdetail")
    public Project getProjectDetail(@RequestParam long id) {
        Optional<Project> pro = projectRepository.findById(id);
        return pro.get();
    }
}
