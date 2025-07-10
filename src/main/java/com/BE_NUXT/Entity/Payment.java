package com.BE_NUXT.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "payments")
public class Payment {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String method; // card, mobile_money, bank_transfer

    private String status; // pending, completed, failed

    private String transactionId;

    private LocalDateTime paymentDate;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
}
