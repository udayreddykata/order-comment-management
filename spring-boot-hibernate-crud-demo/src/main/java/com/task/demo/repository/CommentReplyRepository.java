package com.task.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.demo.model.CommentReply;

public interface CommentReplyRepository extends JpaRepository<CommentReply, Long> {

	List<CommentReply> findCommentReplyBycommentID(Long id);
}
