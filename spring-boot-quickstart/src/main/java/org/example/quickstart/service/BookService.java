package org.example.quickstart.service;

import org.example.quickstart.DTO.BookDTO;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.List;

@Service
public class BookService {
    public List<BookDTO> getAllBooks() {
        return List.of(
                new BookDTO(1L,"Java Programming","Alice",29.99),
                new BookDTO(2L,"Spring Boot in Action","Bob",34.99)
        );
    }
}
