package com.ayush.lms.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayush.lms.daolayer.lmsRepo;
import com.ayush.lms.model.book;

@Service
public class lmsService {

	@Autowired
	private lmsRepo repo;

	public Collection<book> findAllBooks() {
		List<book> booksList = new ArrayList<book>();
		for (book b : repo.findAll()) {
			booksList.add(b);
		}
		System.out.println(booksList);
		return booksList;
	}

	public void delete(long id) {
		repo.deleteById(id);
	}

	public book findOneBook(long id) {
		book b = null;
		for (book currentBook : repo.findAll()) {
			if (currentBook.getId() == id) {
				b = currentBook;
			}
		}
		return b;
	}

	public void save(book b) {
		repo.save(b);
	}
}
