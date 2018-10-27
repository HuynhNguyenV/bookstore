package com.softech.bookstore.repositories;

import com.softech.bookstore.models.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
