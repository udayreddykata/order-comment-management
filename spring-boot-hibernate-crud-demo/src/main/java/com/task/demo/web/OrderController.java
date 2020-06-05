package com.task.demo.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService service;

	@Autowired
	CommentService commentService;

	@Autowired
	CommentReplyService replyService;

	@GetMapping("/getByID/{id}")
	public Map<String, Object> getOrderById(@PathVariable("id") Long id) throws RecordNotFoundException {
		OrderEntity order = service.getOrderById(id);
		Map<String, Object> obj = new HashMap<String, Object>();
		obj.put("order", order);
		if (order != null) {
			List<CommentEntity> comments = commentService.findCommentEntityByOrderId(order.getOrderID());
			obj.put("comments", comments);
			if (comments != null) {
				List<CommentReply> list = new ArrayList<CommentReply>();
				for (int i = 0; i < comments.size(); i++) {
					List<CommentReply> repliesPerComment = replyService.getCommentRepliesByCommentId(id);
					list.addAll(repliesPerComment);
				}
				if (list != null && !list.isEmpty()) {
					// entity.setReplies(list);
					obj.put("replies", list);
				}
			}
		}
		return obj;
	}

	@GetMapping
	public List<OrderEntity> getAllOrders() throws RecordNotFoundException {
		List<OrderEntity> orders = service.getAllOrders();
		return orders;
	}

}
