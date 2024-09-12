package com.devsquard.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsquard.auth.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	// 삭제되지 않은 유저 중 Eamil로 조회
	User findByEmailAndDeletedAtIsNull(String email);
	// 삭제되지 않은 유저들의 Email 중 중복이 있는지
	boolean existsByEmailAndDeletedAtIsNull(String email);

}
