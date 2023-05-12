package com.app.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.demo.entity.Category;
@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
