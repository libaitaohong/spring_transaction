package demo1;

/**
 * Created by zhanghe on 2017/3/30.
 * 转账案例DAO层接口
 */
public interface AccountDao {
    /**
     *
     * @param out :转出账号
     * @param money ：转账金额
     */
    public void outMoney(String out, Double money);

    /**
     *
     * @param in  ：转入账号
     * @param money ：转入金额
     */
    public void inMoney(String in, Double money);
}
