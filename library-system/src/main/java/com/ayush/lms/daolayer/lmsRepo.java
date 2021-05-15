package com.ayush.lms.daolayer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ayush.lms.model.book;

@Repository
public interface lmsRepo extends CrudRepository<book, Long> {

}
