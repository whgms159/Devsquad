package com.devsquad.mypage.service;

import org.springframework.stereotype.Service;

import com.devsquad.mypage.repository.MyProfileCardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MyProfileCardService {
	private final MyProfileCardRepository myProfileCardRepository;

//	@Transactional
//	public MyProfileCardDTO getUserById(Long id) {
//
//		User user = myProfileCardRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("회원 정보가 없습니다"));
//		Set<LocalDate> streakDates = user.getStreakDates();
//		streakDates.size();
//		return new MyProfileCardDTO(user.getNickName(), user.getLanguage(), user.getStreakCount(), user.getIntro(),
//				streakDates);
//	}
}
