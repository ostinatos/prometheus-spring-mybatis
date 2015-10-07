package mount.olympus.prometheus.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import mount.olympus.prometheus.model.*;

@RestController
@RequestMapping("/person")
public interface IPersonService {

	@RequestMapping(value="list", method=RequestMethod.GET)
	public List<Person> queryPersonList();
	
	@RequestMapping(value="batch", method=RequestMethod.POST)
	public List<String> batchInsertPerson();
}
