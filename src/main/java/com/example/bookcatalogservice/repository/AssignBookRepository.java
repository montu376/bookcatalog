package com.example.bookcatalogservice.repository;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.bookcatalogservice.dto.AssignBookDTO;
import com.example.bookcatalogservice.entity.BookAssigned;


@Repository
@Primary()
public interface AssignBookRepository extends JpaRepository<BookAssigned, String>{

}
