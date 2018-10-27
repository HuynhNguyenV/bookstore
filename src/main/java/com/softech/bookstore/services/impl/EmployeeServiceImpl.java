package com.softech.bookstore.services.impl;

import com.softech.bookstore.models.Employee;
import com.softech.bookstore.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Employee t) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> itrbl) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public boolean existsById(Long id) {
        return false;
    }

    @Override
    public Iterable<Employee> findAll() {
        return null;
    }

    @Override
    public Iterable<Employee> findAllById(Iterable<Long> itrbl) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public <S extends Employee> S save(S s) {
        return null;
    }

    @Override
    public <S extends Employee> Iterable<S> saveAll(Iterable<S> itrbl) {
        return null;
    }
}
