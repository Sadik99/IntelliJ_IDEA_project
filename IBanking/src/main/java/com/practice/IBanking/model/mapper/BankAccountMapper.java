package com.practice.IBanking.model.mapper;

import com.practice.IBanking.model.dto.BankAccount;
import com.practice.IBanking.model.dto.UtilityAccount;
import com.practice.IBanking.model.entity.BankAccounts;
import com.practice.IBanking.model.entity.UtilityAccounts;
import org.springframework.beans.BeanUtils;

public  class BankAccountMapper extends BaseMapper<BankAccounts,BankAccount> {
    @Override
    public BankAccounts convertToEntity(BankAccount dto, Object... args) {
        BankAccounts entity = new BankAccounts();
        if (dto != null) {
            BeanUtils.copyProperties(dto, entity, "user");
        }
        return entity;
    }

    @Override
    public BankAccount convertToDto(BankAccounts entity, Object... args) {
        BankAccount dto = new BankAccount();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto, "user");
        }
        return dto;
    }
}
