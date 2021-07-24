package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.Result;

import hrms.hrms.entities.concretes.Candidate;

import java.util.List;

public interface CandidateService {
    DataResult<Candidate> findByIdentityNumber(String identityNumber);
    Result addCandidate(Candidate candidate);
    DataResult<List<Candidate>> getAll();
}
