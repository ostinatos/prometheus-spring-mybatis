package mount.olympus.prometheus.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mount.olympus.prometheus.model.Person;
import mount.olympus.prometheus.model.PersonAddress;
import mount.olympus.prometheus.model.PersonProfile;

@SpringApplicationConfiguration(classes = mount.olympus.prometheus.Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/applicationContext.xml")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)  
@Transactional
public class MapperTest {

	@Inject
	IPersonMapper personMapper;
	
	private static Logger logger = Logger.getLogger(MapperTest.class);
	
	@Test
	public void testSelectPerson(){
		personMapper.selectPerson();
	}
	
	@Test
	public void testInsertPerson(){
		Person p = new Person();
		p.setName("James Blackshaw");
		personMapper.insertPerson(p);
		logger.debug("insert person test, person id:" +p.getPid());
	}
	
	@Test
	public void testInsertCompositePerson(){
		Person p = new Person();
		p.setName("Lazar Berman");
		personMapper.insertPerson(p);
		
		logger.debug("person id:" + p.getPid());
		
		//insert profile
		PersonProfile pp = new PersonProfile();
		pp.setPid(p.getPid());
		pp.setGender("m");
		pp.setIntro("I am a pianist.");
		pp.setNickName("The Birdman");
		p.setPersonProfile(pp);
		
		//insert address
		List<PersonAddress> addList = new ArrayList<PersonAddress>();
		for (int i=0;i<3;i++){
			PersonAddress address = new PersonAddress();
			address.setPid(p.getPid());
			address.setAddDesc("mock address "+ i);
			addList.add(address);
		}

		personMapper.insertPersonAddressList(addList);
		
		personMapper.insertPersonProfile(p);
		
		//query composite person object
		List<Person> lp = personMapper.selectPerson();
		for(Person person:lp){
			logger.debug("Person Name:" + person.getName());
			logger.debug("Person Profile: " + person.getPersonProfile().getIntro() + "\t" + person.getPersonProfile().getNickName());
			logger.debug("personal address:");
			for(PersonAddress pa:person.getAddressList()){
				logger.debug(pa.getAddDesc());
			}
		}
	}
	
}
