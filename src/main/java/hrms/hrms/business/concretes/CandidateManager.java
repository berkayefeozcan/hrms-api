package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.dataAccess.abstracts.CandidateDao;
import hrms.hrms.entities.concretes.Candidate;
import hrms.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateManager implements CandidateService {
    private CandidateDao candidateDao;

    @Autowired
    public CandidateManager(CandidateDao candidateDao){
        this.candidateDao = candidateDao;
    }
    @Override
    public DataResult<Candidate> findByIdentityNumber(String identityNumber) {
        return new SuccessDataResult<Candidate>(candidateDao.findByIndentityNumber(identityNumber));
    }

    @Override
    public Result addCandidate(Candidate candidate) {
        try{

            candidateDao.save(candidate);
            return new SuccessResult("Aday basarili bir sekilde eklendi");
        }catch (Exception e ){
            return  new ErrorResult("aday veri tabanina eklenirken bir sorun olustu "+ e);
        }

    }

    @Override
    public DataResult<List<Candidate>> getAll() {

        try{
            return new SuccessDataResult<List<Candidate>>(candidateDao.findAll());
        }catch (Exception e ){
            return new ErrorDataResult<List<Candidate>>("Employerler listelenirken hata"+e);
        }
    }
}
