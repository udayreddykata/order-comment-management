package com.task.demo.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.demo.exception.RecordNotFoundException;
import com.task.demo.model.CommentEntity;
import com.task.demo.model.CommentReply;
import com.task.demo.model.OrderEntity;
import com.task.demo.service.CommentReplyService;
import com.task.demo.service.CommentService;
import com.task.demo.service.OrderService;

@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	CommentService service;

	@Autowired
	CommentReplyService replyService;
	
	@Autowired
	OrderService orderService;

	@PostMapping
	public ResponseEntity<CommentEntity> createOrUpdateComment(@RequestBody CommentEntity comment)
			throws RecordNotFoundException {
		orderService.getOrderById(comment.getOrderId());
		CommentEntity updated = service.createOrUpdateComment(comment);
		return new ResponseEntity<CommentEntity>(updated, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/getByID/{id}")
	public Map<String,Object> getCommentById(@PathVariable("id") Long id) throws RecordNotFoundException {
		CommentEntity entity = service.getCommentById(id);
		String stg="";
		Map<String,Object> obj=new HashMap<String,Object>();
		obj.put("comment", entity);
		if (entity != null) {
			List<CommentReply> list = replyService.getCommentRepliesByCommentId(id);
			if (list != null && !list.isEmpty()) {
				//entity.setReplies(list);
				
				obj.put("replies", list);
			}
		}
		return obj;
	}

}
