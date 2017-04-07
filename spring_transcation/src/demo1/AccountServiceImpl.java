package demo1;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by zhanghe on 2017/3/30.
 * 业务层实现类
 */
public class AccountServiceImpl implements AccountService{
    //注入dao
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
    //注入事务管理的模板
    private TransactionTemplate transcationTemplate;

    public void setTranscationTemplate(TransactionTemplate transcationTemplate) {
        this.transcationTemplate = transcationTemplate;
    }

    /**
     * @param out   转出账号
     * @param in    转入账号
     * @param money 转账金额
     */
    @Override
    public void transfer(String out, String in, Double money) {
        //5 编程式事务管理
        //使用模板的execute方法，里面使用一个匿名内部类
        transcationTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                //在这个函数里面进行事务的相关操作
                //转账进账已经被绑定到一个事务当中，要么一起成功，要么一起失败
                accountDao.outMoney(out, money);
                int i = 1/0;
                accountDao.inMoney(in, money);
            }
        });
    }
}
