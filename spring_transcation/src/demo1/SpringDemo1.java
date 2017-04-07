package demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by zhanghe on 2017/3/31.
 * 转账案例测试测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-config.xml") //引入配置文件
public class SpringDemo1 {

    //测试业务层类
    @Resource(name = "accountService") //通过注解注入
    private AccountService accountService;

    @Test
    public void demo1(){
        accountService.transfer("aaa","bbb", 200d);
    }

}
