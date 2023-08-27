package com.api.book.bootrestbook.controller;

import com.api.book.bootrestbook.data.transfer.object.BookDto;
import com.api.book.bootrestbook.data.transfer.object.MessageDto;
import com.api.book.bootrestbook.domain.BookDomain;
import com.api.book.bootrestbook.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;
    @GetMapping("/books")
    public ResponseEntity<List<BookDomain>> getBooks() {
        List<BookDomain> list = bookService.getAllBooks();
        if (list.size() <= 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<BookDomain> getBook(@PathVariable("id") int id) {
        BookDomain book = bookService.getBookById(id);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }
    @PostMapping("/books")
    public MessageDto addBook(@RequestBody BookDto bookDto) {
        System.out.println(bookDto.toString());
        return this.bookService.addBook(bookDto);
    }

    @DeleteMapping("/books/{bookId}")
    public MessageDto deleteBook(@PathVariable("bookId") int bookId) {
        return this.bookService.deleteBook(bookId);
    }
    @PutMapping("/books/{bookId}")
    public MessageDto updateBook(@RequestBody BookDomain book, @PathVariable("bookId") int bookId) {
        return this.bookService.updateBook(book,bookId);
    }
}