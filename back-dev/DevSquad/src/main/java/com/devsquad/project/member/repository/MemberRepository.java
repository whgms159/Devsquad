package com.devsquad.project.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsquad.project.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{

}
