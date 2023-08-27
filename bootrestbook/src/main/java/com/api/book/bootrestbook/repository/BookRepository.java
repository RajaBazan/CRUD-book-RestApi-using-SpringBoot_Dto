package com.api.book.bootrestbook.repository;

import com.api.book.bootrestbook.domain.BookDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookDomain, Integer> {
//    public Book findByID(int id);
}
