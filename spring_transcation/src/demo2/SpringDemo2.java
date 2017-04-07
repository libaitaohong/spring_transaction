package demo2;

import demo1.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import javax.annotation.Resource;

/**
 * Created by zhanghe on 2017/4/6.
 * 测试Spring的声明式的事务管理
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config2.xml") //引入配置文件
public class SpringDemo2 {
    //测试业务层类,注入代理类
    @Resource(name = "accountServiceProxy") //通过注解注入
    private AccountService accountService;

    @Test
    /**
     * 转账案例
     */
    public void demo1(){
        accountService.transfer("aaa","bbb", 200d);
    }

}
