package com.CodingDojo.DojoOverflow.repositories;

import org.springframework.data.repository.CrudRepository;

import com.CodingDojo.DojoOverflow.models.Comment;

public interface CommentRepo extends CrudRepository<Comment, Long> {

}
