package com.example.mapper;

import com.example.pojo.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
 public  interface AccountMapper {
    @Insert("INSERT INTO account(username, balance) VALUES(#{username},#{balance})")
    void save(Account account);

    @Delete("DELETE FROM account WHERE id = #{id}")
    void delete(Integer id);

    @Update("UPDATE account SET username=#{username}, balance=#{balance} WHERE id =#{id}")
    void update(Account account);

    @Select("select * from account")
    List<Account> findAll();

    @Select("SELECT * FROM account WHERE id = #{id}")
    Account findById(Integer id);
}
