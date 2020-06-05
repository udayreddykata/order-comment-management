package com.task.demo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.exception.RecordNotFoundException;
import com.task.demo.model.CommentReply;
import com.task.demo.service.CommentReplyService;

@RestController
@RequestMapping("/commentReply")
public class CommentReplyController {

	@Autowired
	CommentReplyService service;
	
	@PostMapping
	public ResponseEntity<CommentReply> createOrUpdateEmployee(@RequestBody CommentReply comment)
			throws RecordNotFoundException {
		CommentReply updated = service.createOrUpdateCommentReply(comment);
		return new ResponseEntity<CommentReply>(updated, new HttpHeaders(), HttpStatus.OK);
	}
}
