package vn.codegym.service;

import org.springframework.stereotype.Service;
import vn.codegym.model.Student;

import java.util.List;

/**
 * (C) Copyright 2023 iHub Academy. All Rights Reserved.
 *
 * @author TrungDC
 * @version 1.0
 * @since 1/10/2024
 */
@Service
public class ABC implements IStudentService{
    @Override
    public List<Student> findAll() {
        return null;
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public List<Student> findByName(String keyword) {
        return null;
    }
}