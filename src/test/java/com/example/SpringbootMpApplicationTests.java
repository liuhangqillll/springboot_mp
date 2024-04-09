package com.example;

import com.example.mapper.AccountMapper;
import com.example.pojo.Account;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMpApplicationTests {

    @Autowired
    private AccountMapper accountMapper;

    @Test //新增记录
    public void insertAccount() {
        Account account = new Account();
        //account.setId(8);
        account.setUsername("SpringBoot");
        account.setBalance(200.01);
        accountMapper.save(account);
    }

    @Test //依据id删除
    public void deleteAccount() {
        accountMapper.delete(124);
    }

    @Test //改
    public void testUpdate() {
        Account account = new Account();
        account.setId(123);
        account.setUsername("zhangsan");
        account.setBalance(1111.01);
        accountMapper.update(account);
    }

    @Test //查单个
    public void testGetByid() {

        Account account = accountMapper.findById(1);
        System.out.println(account);
        //allAccounts.forEach(account -> System.out.println(account));
    }

    @Test //查所有
    public void testGetAll() {
        List<Account> allAccounts = accountMapper.findAll();
        allAccounts.forEach(account -> System.out.println(account));
    }



    @Test //分页查询
    public void testPageHelper() {
        //1.分页参数，pagenum：当前页 pagesize：每页显示几条信息
        PageHelper.startPage(2,3);
        //2. 执行查询
        List<Account> allAccounts = accountMapper.findAll();
        //3. 将查询到的结果分页
        PageInfo<Account> accountPageInfo = new PageInfo<>(allAccounts);
        //4. 清除分页信息
        PageHelper.clearPage();
        //5. 获取当前页数据
        List<Account> list = accountPageInfo.getList();
        System.out.println(list);
    }

}
