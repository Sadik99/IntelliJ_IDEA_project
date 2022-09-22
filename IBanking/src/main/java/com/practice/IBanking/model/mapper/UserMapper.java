package com.practice.IBanking.model.mapper;

import com.practice.IBanking.model.dto.User;
import com.practice.IBanking.model.entity.Users;
import org.springframework.beans.BeanUtils;

public class UserMapper extends BaseMapper<Users, User> {
    private BankAccountMapper bankAccountMapper=new BankAccountMapper();

    @Override
    public Users convertToEntity(User dto, Object... args) {
        Users entity=new Users();
        if(dto!=null){
            BeanUtils.copyProperties(dto,entity,"accounts");
            entity.setAccounts(bankAccountMapper.convertToEntityList(dto.getBankAccounts()));
        }
        return entity;
    }
    @Override
    public User convertToDto(Users entity, Object... args) {
        User dto = new User();
        if (entity != null) {
            BeanUtils.copyProperties(entity, dto, "accounts");
            dto.setBankAccounts(bankAccountMapper.convertToDtoList(entity.getAccounts()));
        }
        return dto;
    }

}
