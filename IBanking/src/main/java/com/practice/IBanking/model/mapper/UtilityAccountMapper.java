package com.practice.IBanking.model.mapper;

import com.practice.IBanking.model.dto.UtilityAccount;
import com.practice.IBanking.model.entity.UtilityAccounts;
import org.springframework.beans.BeanUtils;

public class UtilityAccountMapper extends BaseMapper<UtilityAccounts, UtilityAccount> {
    @Override
    public UtilityAccounts convertToEntity(UtilityAccount dto,Object... args){
        UtilityAccounts entity=new UtilityAccounts();
        if(dto!=null){
            BeanUtils.copyProperties(dto,entity);
        }
        return entity;
    }



    @Override
    public UtilityAccount convertToDto(UtilityAccounts entity,Object... args){
        UtilityAccount dto=new UtilityAccount();
        if(entity!=null){
            BeanUtils.copyProperties(dto,entity);
        }
        return dto;
    }
}
