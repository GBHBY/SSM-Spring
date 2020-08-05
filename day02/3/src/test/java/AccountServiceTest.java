import com.GYB.Dao.IAccountDao;
import com.GYB.domain.Account;
import com.GYB.service.IAccountService;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceTest {

    IAccountService iAccountService;
    IAccountDao iAccountDao;

    @Before
    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        iAccountService = (IAccountService) applicationContext.getBean("accountService", IAccountService.class);
        iAccountDao = (IAccountDao) applicationContext.getBean("accountDao", IAccountDao.class);
    }


    @Test
    public void listFindAllAccount() {
        List<Account> accounts = iAccountService.listFindAllAccount();
        for(Account account : accounts){
            System.out.println(account);
        }
    }

    @Test
    public void findAccountById() {
    }

    @Test
    public void saveAccount() {
    }

    @Test
    public void upData() {
    }

    @Test
    public void delete() {
    }


}
