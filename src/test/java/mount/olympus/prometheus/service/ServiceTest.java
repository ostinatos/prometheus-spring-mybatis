package mount.olympus.prometheus.service;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@SpringApplicationConfiguration(classes = mount.olympus.prometheus.Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
@Transactional
public class ServiceTest {

	@Inject
	public IPersonService personService;
	
	@Test
	public void testPersonService(){
		personService.batchInsertPerson();
	}
}
