package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.EmployerDao;
import hrms.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {
    private EmployerDao employerDao;
    @Autowired
    public EmployerManager(EmployerDao employerDao){
        this.employerDao = employerDao;
    }
    @Override
    public Result add(Employer employer) {
        try{
            employerDao.save(employer);
            return  new SuccessResult("employer eklendi");
        }catch (Exception e ){
            return  new ErrorResult("employer Eklemede sorun" + e);
        }

    }

    @Override
    public DataResult<List<Employer>> getAll() {
        try{
            return new SuccessDataResult<List<Employer>>(employerDao.findAll());
        }catch (Exception e ){
            return new ErrorDataResult<List<Employer>>("Employerler listelenirken hata"+e);
        }

    }

}
