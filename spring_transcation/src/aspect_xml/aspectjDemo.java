package aspect_xml;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by zhanghe on 2017/4/7.
 * Spring声明式事务管理方式二：基于Aspectj的XML方式的配置
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-aspectj.xml") //引入配置文件
public class aspectjDemo {
    //测试业务层类,注入代理类
    @Resource(name = "accountService") //通过注解注入
    private AccountService accountService;

    @Test
    /**
     * 转账案例
     */
    public void demo1(){
        accountService.transfer("aaa","bbb", 200d);
    }

}