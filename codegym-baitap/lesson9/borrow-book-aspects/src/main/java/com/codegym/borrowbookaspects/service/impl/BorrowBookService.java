package com.codegym.borrowbookaspects.service.impl;

import com.codegym.borrowbookaspects.model.Book;
import com.codegym.borrowbookaspects.service.IBorrowBookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BorrowBookService implements IBorrowBookService {

    private static List<Book> library;
    private static List<String> borrowed;
    static  {
        borrowed = new ArrayList<>();
        library = new ArrayList<>();
        library.add(new Book("1"));
        library.add(new Book("2"));
        library.add(new Book("3"));
        library.add(new Book("4"));
    }
    @Override
    public String borrow(String code) throws Exception {
        for(Book book : library){
            if(book.getCode().equals(code)){
                borrowed.add(code);
                library.remove(book);
                return "Success";
            }
        }
        throw new Exception("Ko co sach nay");
    }

    @Override
    public String bookBack(String code) throws Exception {
        for(String s : borrowed){
            if(s.equals(code)){
                library.add(new Book(code));
                borrowed.remove(s);
                return "Back success";
            }
        }
        throw new Exception("ko co sach nay");
    }


}
