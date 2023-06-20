package com.example.bookcatalogservice.entity;

import org.springframework.lang.Nullable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookAssigned {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	@Column(nullable = false)
	String bookId;
	@Column(nullable = false)
	String userId;
}
