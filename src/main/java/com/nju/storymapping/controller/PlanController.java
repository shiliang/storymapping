package com.nju.storymapping.controller;

import com.nju.storymapping.entity.Plan;
import com.nju.storymapping.respository.PlanRepository;
import com.nju.storymapping.respository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PlanController {

    @Autowired
    private PlanRepository planRepository;


    @PostMapping("/addplan")
    public String addPlan(@RequestBody Plan plan) {
        //保存计划
       planRepository.save(plan);
       return null;
    }

    @PostMapping("/planlist")
    public List<Plan> planList() {
        List<Plan> plans = planRepository.findAll();
        return plans;
    }

    @GetMapping("/viewplan")
    public Plan viewPlan(@RequestParam long id) {
        Optional<Plan> pro = planRepository.findById(id);
        return pro.get();
    }
}
