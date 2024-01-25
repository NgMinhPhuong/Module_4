package com.codegym.borrowbookaspects.service;

public interface IBorrowBookService {
    String borrow(String code) throws Exception;
    String bookBack(String code) throws Exception;
}
