<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/project/repository/ProjectRepository.java
package com.devsquard.project.project.repository;
========
package com.devsquad.project.repository;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/repository/ProjectRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/project/repository/ProjectRepository.java
import com.devsquard.project.project.entity.Project;
========
import com.devsquad.project.entity.Project;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/repository/ProjectRepository.java

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{

}
