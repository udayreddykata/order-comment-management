package com.task.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.demo.exception.RecordNotFoundException;
import com.task.demo.model.CommentEntity;
import com.task.demo.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepo;

	public CommentEntity createOrUpdateComment(CommentEntity entity) throws RecordNotFoundException {
		CommentEntity response = commentRepo.save(entity);
		return response;
	}

	public CommentEntity getCommentById(Long id) throws RecordNotFoundException {
		Optional<CommentEntity> comment = commentRepo.findById(id);
		if (comment.isPresent()) {
			return comment.get();
		} else {
			throw new RecordNotFoundException("No product record exist for given id");
		}
	}

	public List<CommentEntity> findCommentEntityByOrderId(Long id) throws RecordNotFoundException {
		List<CommentEntity> comments = commentRepo.findCommentEntityByOrderId(id);
		if (comments != null) {
			return comments;
		} else {
			throw new RecordNotFoundException("No comments  exist for given order id");
		}
	}

}
