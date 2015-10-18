package mount.olympus.prometheus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.executor.BatchResult;

import mount.olympus.prometheus.model.Person;
import mount.olympus.prometheus.model.PersonAddress;

public interface IPersonMapper {

	public List<Person> selectPerson();
	
	public void insertPerson(Person person);
	
	@Flush
	List<BatchResult> flush();
	
	public void insertPersonProfile(Person person);
	
	public void insertPersonAddressList(List<PersonAddress> personAddressList);
}
