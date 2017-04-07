package annotation;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhanghe on 2017/3/30.
 * 业务层实现类
 */

/**@Transactional注解中的属性：
 * propagation   ：事务传播行为
   isolation     ：事务隔离级别
   read-only     ：只读
   rollbackFor   ：发生哪些异常回滚
   noRollbackFor ：发生哪些异常不会滚
   noRollbackForClassName  : 类的名字，也可以通过名称进行设置
 不写则是默认值
 *
 */
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
public class AccountServiceImpl implements AccountService {
    //注入dao
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * @param out   转出账号
     * @param in    转入账号
     * @param money 转账金额
     */
    @Override
    public void transfer(String out, String in, Double money) {

        accountDao.outMoney(out, money);
        int i = 1/0;
        accountDao.inMoney(in, money);

    }
}
