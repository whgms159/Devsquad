package com.devsquad.community.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsquad.community.domain.PostRequest;
import com.devsquad.community.domain.PostResponse;
import com.devsquad.community.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@Tag(name = "커뮤니티", description = "커뮤니티 관련 API")
@RequestMapping("/api/community")
public class PostController {
	private final PostService postService;
	
	// { 게시글 생성 }
	@Operation(summary = "게시글 작성", description = "게시물을 작성합니다.")
	@PostMapping("")
	public ResponseEntity<PostResponse> createPost(@ModelAttribute PostRequest post) {
		log.info("[createPost] 게시글 작성 요청 : {}", post);
		// post를 서비스로 던져서 부탁하기
		PostResponse savedPost = postService.insertPost(post);
		// 201을 반환, 반환된 객체는 저장된 게시글 정보를 포함
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPost);
	}
	
	// { 게시글 조회 }
	@Operation(summary = "게시글 목록 조회(특정 포함)", description = "모든 게시글의 목록 or 특정 게시글을 반환합니다.")
	@GetMapping("")
	public ResponseEntity<List<PostResponse>> getAllPost(@RequestParam(name="id", required = false) Long id) {
		// 게시글 목록을 담을 리스트 생성
		List<PostResponse> result = new ArrayList<>();
		// id가 null 이라면 전체 리스트
		if (id == null) {
			result = postService.getAllPost();
		// id가 넘어온다면 특정 게시물 조회
		} else {
			// postResponse 형태로 반환 받은 후
			PostResponse postResponse = postService.getPostById(id);
			// 리스트에 추가
			result.add(postResponse);
		}
		// 200을 반환, 게시글 목록을 반환
		return ResponseEntity.ok(result);
	}
	
	// { 게시글 삭제 }
	@Operation(summary = "게시글 삭제", description = "특정 게시글을 삭제합니다.")
	@DeleteMapping("/{id}")
	public ResponseEntity<PostResponse> deletePost(@PathVariable("id") Long id) {
		// id를 넘겨서 삭제 부탁
		PostResponse deletedPost = postService.deleteById(id);
		// 200을 반환, 삭제된 게시글 반환
		return ResponseEntity.ok(deletedPost);
	}
	
	// { 게시글 수정 }
	@Operation(summary = "게시글 수정", description = "특정 게시글을 수정합니다.")
	@PatchMapping("")
	public ResponseEntity<PostResponse> modifyPost(@ModelAttribute PostRequest post) {
		// post객체를 넘겨서 수정 부탁
		PostResponse updatedPost = postService.updatePost(post);
		// 200과 함께 수정된 게시글 반환
		return ResponseEntity.ok(updatedPost);
	}

}
