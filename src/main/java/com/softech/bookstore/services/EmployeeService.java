package com.softech.bookstore.services;

import com.softech.bookstore.models.Employee;

import java.util.Optional;


public interface EmployeeService {
    long count();

    void delete(Employee t);

    void deleteAll();

    void deleteAll(Iterable<? extends Employee> itrbl);

    void deleteById(Long id);

    boolean existsById(Long id);

    Iterable<Employee> findAll();

    Iterable<Employee> findAllById(Iterable<Long> itrbl);

    Optional<Employee> findById(Long id);

    <S extends Employee> S save(S s);

    <S extends Employee> Iterable<S> saveAll(Iterable<S> itrbl);
}
