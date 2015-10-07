package mount.olympus.prometheus.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Flush;
import org.apache.ibatis.executor.BatchResult;

import mount.olympus.prometheus.model.Person;

public interface IPersonMapper {

	List<Person> selectPerson();
	
	void insertPerson(Person person);
	
	@Flush
	List<BatchResult> flush();
}
