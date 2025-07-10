package com.BE_NUXT.Entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private String description;
	@Column(nullable = true)
	private Double price;
	@Column(nullable = true)
	private int stock_quantity;
	
//	private String sku; (référence)
	@Column(nullable = true)
	private int status;
	@CreationTimestamp
	private LocalDateTime created_at;
	@UpdateTimestamp
	private LocalDateTime updated_at;
	
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category_id;
}
