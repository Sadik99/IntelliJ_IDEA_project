package com.practice.IBanking.model.entity;

import com.practice.IBanking.model.TransactionType;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Builder
@Entity
@Getter
@Setter

@Table(name="banking_core_transaction")
@NoArgsConstructor

public class Transactions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String referenceNumber;
    private String transactionId;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="account_id",referencedColumnName = "id")
    private BankAccounts account;

}
