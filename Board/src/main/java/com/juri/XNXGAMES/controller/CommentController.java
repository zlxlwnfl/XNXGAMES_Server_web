package com.juri.XNXGAMES.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juri.XNXGAMES.DTO.CommentGetListDTO;
import com.juri.XNXGAMES.DTO.CommentPutDTO;
import com.juri.XNXGAMES.service.CommentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/board/comment/*")
@AllArgsConstructor
public class CommentController {

	CommentService commentService;
	
	@PostMapping("/")
	public void insertComment(@RequestBody CommentPutDTO commentDTO) {
		commentService.insertComment(commentDTO);
	}
	
	@PutMapping("/")
	public void modifyComment(@RequestBody CommentPutDTO commentDTO) {
		commentService.modifyComment(commentDTO);
	}
	
	@GetMapping("/{postId}")
	public List<CommentGetListDTO> getCommentList(@PathVariable("postId") Long postId) {
		return commentService.getCommentList(postId);
	}
	
	@DeleteMapping("/{postId}")
	public void deleteComment(@PathVariable("postId") Long commentId) {
		commentService.deleteComment(commentId);
	}
	
}
