import com.gyb.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Author gb
 * @Date 2020/7/5 14:05
 * @Version 1.0
 * description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:bean.xml")
public class AccountServiceTest {
    @Autowired
    private AccountService accountService;
    @Test
    public void testTransfer(){
        accountService.transfer("bbb","ccc",100f);
    }

}
