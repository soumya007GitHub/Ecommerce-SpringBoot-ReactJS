package com.soumya.ecommerce.model;

import com.soumya.ecommerce.domain.PaymentMethod;
import com.soumya.ecommerce.domain.PaymentOrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long amount;
    private PaymentOrderStatus status = PaymentOrderStatus.PENDING;
    private PaymentMethod paymentMethod;
    private String paymentLinkId;
    @ManyToOne
    private User user;
    @OneToMany
    private Set<Order> orders = new HashSet<>();
}
