package com.BE_NUXT.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_images")
public class ProductImages {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
		 
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
}
