package com.devsquad.mypage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsquad.mypage.service.MyProfileCardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/devsquad/mypage")
@RequiredArgsConstructor
public class MyProfileCardController {
	private final MyProfileCardService myProfileCardService;

//	@GetMapping("/{id}")
//	public MyProfileCardDTO getUserById(@PathVariable("id") Long id) {
//		return myProfileCardService.getUserById(id);
//	}
}
