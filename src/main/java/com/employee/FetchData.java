package com.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface FetchData extends JpaRepository<UserModel,Integer> {

}
