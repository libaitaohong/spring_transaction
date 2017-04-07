package aspect_xml;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * Created by zhanghe on 2017/3/30.
 * 转账案例DAO的实现类
 * JdbcDaoSupport:spring提供了jdbc模板类
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    /**
     * @param out   :转出账号
     * @param money ：转账金额
     */
    @Override
    public void outMoney(String out, Double money) {
        String sql = "update account set money = money - ? where name = ?";
        this.getJdbcTemplate().update(sql, money, out); //调用模板执行sql语句
    }

    /**
     * @param in    ：转入账号
     * @param money ：转入金额
     */
    @Override
    public void inMoney(String in, Double money) {
        String sql = "update account set money = money + ? where name = ?";
        this.getJdbcTemplate().update(sql, money, in); //调用模板执行sql语句
    }
}
