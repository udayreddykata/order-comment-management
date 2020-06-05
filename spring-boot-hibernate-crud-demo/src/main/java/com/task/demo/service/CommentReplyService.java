package com.task.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.demo.exception.RecordNotFoundException;
import com.task.demo.model.CommentEntity;
import com.task.demo.model.CommentReply;
import com.task.demo.repository.CommentReplyRepository;
import com.task.demo.repository.CommentRepository;

@Service
public class CommentReplyService {

	@Autowired
	CommentReplyRepository repo;

	@Autowired
	CommentRepository commentRepo;

	public CommentReply createOrUpdateCommentReply(CommentReply entity) throws RecordNotFoundException {
		Optional<CommentEntity> comment = commentRepo.findById(entity.getCommentID());
		if (comment.isPresent()) {
			CommentReply response = repo.save(entity);
			return response;
		} else {
			throw new RecordNotFoundException("No comment record exist for given comment id");
		}
	}

	public CommentReply getCommentReplyById(Long id) throws RecordNotFoundException {
		Optional<CommentReply> comment = repo.findById(id);

		if (comment.isPresent()) {
			return comment.get();
		} else {
			throw new RecordNotFoundException("No record exist for given id");
		}
	}

	public List<CommentReply> getCommentRepliesByCommentId(Long id) throws RecordNotFoundException {
		List<CommentReply> comment = repo.findCommentReplyBycommentID(id);

		return comment;
	}

}
