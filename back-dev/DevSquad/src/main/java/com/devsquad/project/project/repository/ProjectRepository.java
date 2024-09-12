package com.devsquad.project.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsquad.project.project.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
