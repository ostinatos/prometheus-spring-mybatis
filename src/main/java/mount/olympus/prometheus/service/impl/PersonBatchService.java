package mount.olympus.prometheus.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import mount.olympus.prometheus.mapper.IPersonMapper;
import mount.olympus.prometheus.model.Person;
import mount.olympus.prometheus.service.IPersonService;

@Named("personService")
public class PersonBatchService implements IPersonService {

	@Inject
	private SqlSession sqlSessionForBatch;
	
	private static Logger logger = Logger.getLogger(PersonBatchService.class);

	@Override
	public List<Person> queryPersonList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<String> batchInsertPerson() {

		// insert person
		List<Person> pl = new ArrayList<Person>();

		List<String> result = new ArrayList<String>();

		for (int i = 0; i < 10000; i++) {
			Person p = new Person();
			p.setName("BatchRobot#" + i);
			pl.add(p);
		}

		IPersonMapper mapper = sqlSessionForBatch.getMapper(IPersonMapper.class);
		
		long start = System.currentTimeMillis();
		
		for(Person p:pl){
			mapper.insertPerson(p);
			logger.debug("inserted Pid: " + p.getPid());
			//sqlSessionForBatch.insert("mount.olympus.prometheus.mapper.IPersonMapper.insertPerson", p);
			
		}
		
		List<BatchResult> br = mapper.flush();//flush will cause batched statement to commit
		
		logger.debug("insertion duration: " + (System.currentTimeMillis()-start));
		
		//sqlSessionForBatch.commit();//remember to commit
		
		for(Person p:pl){
			result.add("" + p.getPid());
		}
		
		return result;
	}

}
