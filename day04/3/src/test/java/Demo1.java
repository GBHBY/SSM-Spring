import com.gyb.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @Author gb
 * @Date 2020/8/15 22:04
 * @Version 1.0
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class Demo1 {
    @Resource
    private IAccountService accountService;

    @Test
    public void test1() {
        accountService.transfer("bbb", "ccc", 100f);

    }
}
