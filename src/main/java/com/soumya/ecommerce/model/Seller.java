package com.soumya.ecommerce.model;

import com.soumya.ecommerce.domain.AccountStatus;
import com.soumya.ecommerce.domain.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    private String sellerName;

    private String mobile;

    @Column(unique = true, nullable = true)
    private String email;

    @Embedded
    private BusinessDetails businessdetails;

    @Embedded
    private BankDetails bankDetails;

    @OneToOne(cascade = CascadeType.ALL)
    private Address pickupAddress;

    private String GSTIN;

    private UserRole role = UserRole.ROLE_SELLER;

    private boolean isEmailVerified=false;

    private AccountStatus accountStatus = AccountStatus.PENDING_VERIFICATION;

}
