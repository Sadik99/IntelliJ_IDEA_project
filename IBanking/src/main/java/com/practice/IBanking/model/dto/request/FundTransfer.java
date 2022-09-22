package com.practice.IBanking.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FundTransfer {
    private String fromAccount;
    private String toAccount;
    private BigDecimal amount;
}
