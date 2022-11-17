/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package org.example.service;

import org.example.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountService {
    @Autowired
    private AccountDAO accountDAO;

    public void transferAccount() {
        //正常执行时没有问题，出现异常后逻辑错误
        accountDAO.decreaseBalance(1);
        //制造异常
        //int i = 10/0;
        accountDAO.increaseBalance(2);

        //使用数据库事务进行解决
        //try {
            //1. 开启事务

            //2. 进行业务操作

            //3. 提交事务
        //} catch (Exception e) {
            // 4. 出现异常，进行事务回滚
        //}
    }
}
