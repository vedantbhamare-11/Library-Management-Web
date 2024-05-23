package com.example.librarymanagement.controller;

import com.example.librarymanagement.model.Book;
import com.example.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public String listBooks(@RequestParam(name = "bookId", required = false) Integer bookId, Model model) {
        if (bookId != null) {
            Book book = bookService.getBookById(bookId);
            if (book != null) {
                model.addAttribute("book", book);
            } else {
                model.addAttribute("errorMessage", "Book not found with ID: " + bookId);
            }
        }
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/viewAllBooks")
    public String viewAllBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }

    @PostMapping("/addBook")
    public String addBook(@RequestParam String title, @RequestParam String author, 
                          @RequestParam int quantity, @RequestParam int subjectId, Model model) {
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAuthor(author);
        newBook.setQuantity(quantity);
        newBook.setSubjectId(subjectId);
        bookService.saveBook(newBook);
        model.addAttribute("successMessage", "Book added successfully.");
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @PostMapping("/deleteBook")
    public String deleteBook(@RequestParam int bookId, Model model) {
        bookService.deleteBookById(bookId);
        model.addAttribute("successMessage", "Book deleted successfully.");
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }

    @GetMapping("/getBook")
    @ResponseBody
    public Map<String, Object> getBook(@RequestParam int bookId) {
        Map<String, Object> response = new HashMap<>();
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            response.put("editBook", book);
        } else {
            response.put("errorMessage", "Book not found with ID: " + bookId);
        }
        return response;
    }

    @PostMapping("/editBook")
    public String editBook(@RequestParam int id, @RequestParam String title, @RequestParam String author,
                           @RequestParam int quantity, @RequestParam int subjectId, Model model) {
        Book book = bookService.getBookById(id);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setQuantity(quantity);
            book.setSubjectId(subjectId);
            bookService.saveBook(book);
            model.addAttribute("successMessage", "Book updated successfully.");
        } else {
            model.addAttribute("errorMessage", "Book not found with ID: " + id);
        }
        model.addAttribute("books", bookService.getAllBooks());
        return "books";
    }
}
