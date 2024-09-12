package com.devsquad.community.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsquad.auth.entity.User;
import com.devsquad.auth.repository.UserRepository;
import com.devsquad.community.domain.PostRequest;
import com.devsquad.community.domain.PostResponse;
import com.devsquad.community.entity.Post;
import com.devsquad.community.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostService {
	private final PostRepository postRepository; 
	private final UserRepository userRepository;
	
	// { 게시글 전체 조회 }
	public List<PostResponse> getAllPost() {
		// Repo를 통해 post들을 찾아 List에 넣고
		List<Post> postList = postRepository.findAll();
		// 만약 List에 Post가 있다면
		if (postList.size() > 0) {
			// 해당 List를 PostResponse형태로 변경해서 리스트화 후 리턴
			List<PostResponse> postResponseList = postList.stream().map(PostResponse::toDTO).toList();
			return postResponseList;
		// 없다면
		} else {
			// 빈 List 리턴
			return new ArrayList<>();
		}
	}

	// { 특정 게시물 조회 }
	public PostResponse getPostById(Long id) {
		// id에 해당하는 post를 찾아 postResponse로 변환 후 반환
		Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("없는 글입니다."));
		PostResponse postResponse = PostResponse.toDTO(post);
		return postResponse;
	}

	// { 게시글 삭제 }
	public PostResponse deleteById(Long id) {
	    // 1. 삭제하려는 게시물 조회
	    Post post = postRepository.findById(id)
	        .orElseThrow(() -> new IllegalArgumentException("해당 게시물을 찾을 수 없음"));

	    // 2. 게시물 삭제
	    postRepository.deleteById(id);

	    // 3. 삭제된 게시물 정보를 PostResponse로 변환하여 반환
	    return PostResponse.toDTO(post);
	}
	
	// { 게시글 작성 }
	public PostResponse insertPost(PostRequest postDTO) {
		 // 유저를 찾아서
		log.info("유저 ID 정보 : {}", postDTO.getUserId());
		User user = userRepository.findById(postDTO.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 유저가 없습니다."));
		Post post = postDTO.toEntity(user);
		Post savedPost = postRepository.save(post);
		
		// 타입 변환해서 result로 저장
		PostResponse result = PostResponse.toDTO(savedPost);
		// 반환
		return result;
	}

	public PostResponse updatePost(PostRequest postDTO) {
		// id를 통해 해당 게시물 찾아오기
		Post post = postRepository.findById(postDTO.getId()).orElseThrow(() -> new IllegalArgumentException("해당 게시물을 찾을 수 없음"));
		
		// 만약 변경사항이 있다면 찾은 post에 변경된 내용을 업데이트
		if (postDTO.getTitle() != null) post.setTitle(postDTO.getTitle());
		if (postDTO.getClass() != null) post.setContent(postDTO.getContent());
		
		// 해당 게시물을 저장해주고
		Post updatedPost = postRepository.save(post);
		// 반환타입 변환 후
		PostResponse result = PostResponse.toDTO(updatedPost);
		// 반환
		return result;
	}

}
