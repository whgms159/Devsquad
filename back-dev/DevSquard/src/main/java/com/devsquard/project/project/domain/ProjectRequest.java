package com.devsquard.project.project.domain;

import java.time.LocalDate;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ProjectRequest {
    private Long id;
    private String projectName;
    private String simpleIntro;
    private String description;
    private String devStack;
    private int participaint;
    private LocalDate startedAt;
    private LocalDate endAt;
}
