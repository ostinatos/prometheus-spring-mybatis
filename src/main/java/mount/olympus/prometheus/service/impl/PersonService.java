package mount.olympus.prometheus.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import mount.olympus.prometheus.mapper.IPersonMapper;
import mount.olympus.prometheus.model.Person;
import mount.olympus.prometheus.service.IPersonService;

//@Named
public class PersonService implements IPersonService {

	@Inject
	private IPersonMapper personMapper;

	@Override
	public List<Person> queryPersonList() {
		return personMapper.selectPerson();
	}

	@Override
	public List<String> batchInsertPerson() {

		// insert person
		List<Person> pl = new ArrayList<Person>();
		
		List<String> result = new ArrayList<String>();

		for (int i = 0; i < 5; i++) {
			Person p = new Person();
			p.setName("Robot#" + i);
			pl.add(p);
		}
		
		for(Person p:pl){
			personMapper.insertPerson(p);
		}
		
		for(Person p:pl){
			result.add("" + p.getPid());
		}
		
		return result;
	}

}
