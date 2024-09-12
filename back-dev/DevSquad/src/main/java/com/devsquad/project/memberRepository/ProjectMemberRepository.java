<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/member/repository/ProjectMemberRepository.java
package com.devsquard.project.member.repository;
========
package com.devsquad.project.memberRepository;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/memberRepository/ProjectMemberRepository.java

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

<<<<<<<< HEAD:back-dev/DevSquard/src/main/java/com/devsquard/project/member/repository/ProjectMemberRepository.java
import com.devsquard.project.member.entity.ProjectMember;
========
import com.devsquad.project.memberEntity.ProjectMember;
>>>>>>>> c6ffdaa0de915e0bfd251556b822503846878995:back-dev/DevSquad/src/main/java/com/devsquad/project/memberRepository/ProjectMemberRepository.java

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long>{

}
