package com.devsquad.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsquad.mypage.entity.MyProjectCard;

@Repository
public interface MyprojectCardRepository extends JpaRepository<MyProjectCard, Long>{

}
