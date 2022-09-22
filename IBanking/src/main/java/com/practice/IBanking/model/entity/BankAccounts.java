package com.practice.IBanking.model.entity;

import com.practice.IBanking.model.AccountStatus;
import com.practice.IBanking.model.AccountType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Setter
@Getter
@Table(name = "banking_core_account")
public class BankAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    @Enumerated(EnumType.STRING)
    private AccountType type;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

    private BigDecimal availableBalance;

    private BigDecimal actualBalance;
    @ManyToOne
    @JoinColumn(name="user_id")
    private Users user;
}
