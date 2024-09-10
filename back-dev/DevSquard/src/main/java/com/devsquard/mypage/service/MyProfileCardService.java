package com.devsquard.mypage.service;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsquard.auth.entity.User;
import com.devsquard.mypage.dto.MyProfileCardDTO;
import com.devsquard.mypage.repository.MyProfileCardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyProfileCardService {
	private final MyProfileCardRepository myProfileCardRepository;

	@Transactional
	public MyProfileCardDTO getUserById(Long id) {

		User user = myProfileCardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("회원 정보가 없습니다"));
		Set<LocalDate> streakDates = user.getStreakDates();
		streakDates.size();
		return new MyProfileCardDTO(user.getNickName(), user.getLanguage(), user.getStreakCount(), user.getIntro(),
				streakDates);
	}
}
