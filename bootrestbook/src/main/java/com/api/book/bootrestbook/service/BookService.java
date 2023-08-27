package com.api.book.bootrestbook.service;
import com.api.book.bootrestbook.data.transfer.object.BookDto;
import com.api.book.bootrestbook.data.transfer.object.MessageDto;
import com.api.book.bootrestbook.domain.AuthorDomain;
import com.api.book.bootrestbook.repository.BookRepository;
import com.api.book.bootrestbook.domain.BookDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service

public class BookService {
@Autowired
    private BookRepository bookRepository;
    public List<BookDomain> getAllBooks()
    {
       List<BookDomain> list= (List<BookDomain>)this.bookRepository.findAll();
        return list;
    }
//    GET single book
    public BookDomain getBookById(int id){
        BookDomain book = null;
        try {
            this.bookRepository.findById(id);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    return book;
}
    public MessageDto addBook(BookDto bookDto){
        BookDomain bookDomain = new BookDomain();
        AuthorDomain authorDomain = new AuthorDomain();
        authorDomain.setAuthorId(bookDto.getAuthorDto().getAuthorId());
        authorDomain.setFirstname(bookDto.getAuthorDto().getFirstName());
        authorDomain.setLastname(bookDto.getAuthorDto().getLastName());
        authorDomain.setLanguage(bookDto.getAuthorDto().getLanguage());
        bookDomain.setId(bookDto.getId());
        bookDomain.setTitle(bookDto.getTitle());
        bookDomain.setAuthorDomain(authorDomain);
        this.bookRepository.save(bookDomain);
        return new MessageDto("User has been added with id:"+bookDomain.getId());
    }

    public MessageDto deleteBook(int bookDomainId) {
        bookRepository.deleteById(bookDomainId);
        return new MessageDto("User has been deleted with id: "+bookDomainId);
    }

    public MessageDto updateBook(BookDomain bookDomain, int bookDomainId){
    bookDomain.setId(bookDomainId);
    bookRepository.save(bookDomain);
    return new MessageDto("user has been updated with id:"+bookDomainId);
    }
}
