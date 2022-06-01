package com.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    FetchData repository;


    List<UserModel> findAllEmployees(){
        return repository.findAll();
    }

    List<UserModel> findEmployeesSorting(String field) {
        return repository.findAll(Sort.by(Sort.Direction.ASC, field));
    }

    Page<UserModel> employeeWithPagination(int offset,int pageSize){
        Page<UserModel> employees = repository.findAll(PageRequest.of(offset,pageSize));
        return employees;
    }

    Page<UserModel> findTopSalariedEmployees() {
        Page<UserModel> getTop10= repository.findAll(PageRequest.of(0,10,Sort.by("salary").descending()));
        return getTop10;
    }

}
