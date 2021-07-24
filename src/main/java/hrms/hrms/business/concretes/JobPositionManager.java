package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.JobPositionService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.JobPositionDao;
import hrms.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobPositionManager implements JobPositionService {
    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }
    @Override
    public DataResult<List<JobPosition>> getAll() {
        return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll());
    }

    @Override
    public Result add(JobPosition jobPosition) {
        try{
            this.jobPositionDao.save(jobPosition);
            return new SuccessResult("position eklendi");
        }catch(Exception e ){
            return new ErrorResult("pozisyon eklemede problem"+e);
        }

    }
}
