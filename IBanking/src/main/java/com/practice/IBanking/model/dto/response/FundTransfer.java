package com.practice.IBanking.model.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class FundTransfer {
    private String message;
    private String transactionId;

}
