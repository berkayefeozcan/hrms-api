package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.entities.concretes.Employer;

import java.util.List;

public interface EmployerService {
     Result add(Employer employer);
     DataResult<List<Employer>> getAll();
}
