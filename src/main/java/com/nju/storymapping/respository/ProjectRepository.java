package com.nju.storymapping.respository;


import com.nju.storymapping.entity.Plan;
import com.nju.storymapping.entity.Project;
import com.nju.storymapping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {


    @Query(value = "select p from Project p where p.user = ?1")
    List<Project> findAllByUser(User user);
}
