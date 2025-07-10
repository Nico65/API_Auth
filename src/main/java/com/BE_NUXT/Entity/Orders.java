package com.BE_NUXT.Entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double totalPrice;

    private String status; // pending, paid, shipped, delivered, cancelled

    private String paymentStatus; // paid, unpaid, refunded

    @CreationTimestamp
    private LocalDate createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // L'utilisateur qui a passé la commande
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    // Liste des articles commandés
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderItem> items;
}
