package com.task.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.task.demo.model.CommentEntity;
import com.task.demo.model.CommentReply;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{

	List<CommentEntity> findCommentEntityByOrderId(Long id);
}
