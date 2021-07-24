package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.CandidateService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.results.*;
import hrms.hrms.core.utilities.verification.abstracts.UserInfoCheckerService;
import hrms.hrms.core.utilities.verification.abstracts.UserVerificationService;
import hrms.hrms.entities.concretes.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    CandidateService candidateService;
    UserService userService ;
    UserInfoCheckerService userInfoCheckerService;
    UserVerificationService userVerificationService;
    @Autowired
    public CandidateController(CandidateService candidateService,UserService userService,
                               UserInfoCheckerService userInfoCheckerService,UserVerificationService userVerificationService){
        this.candidateService = candidateService;
        this.userService=userService;
        this.userInfoCheckerService = userInfoCheckerService;
        this.userVerificationService=userVerificationService;
    }

    @PostMapping(name = "addCandidate")
    public Result addCandidate(@RequestBody Candidate candidate){
        boolean emailIsExists =  userService.getByEmail(candidate.getEmail()).getData() !=null;
        boolean idendentityNumberIsExists = candidateService.findByIdentityNumber(candidate.getIndentityNumber()).getData() !=null;
        boolean userIsValid = userVerificationService.checkPersonIsValid(candidate.getIndentityNumber(),
                candidate.getFirstname(),candidate.getSurname(),candidate.getBirthOfDate());

        if ( emailIsExists ){
            return  new ErrorResult("email daha once kayitli");

        }else if(!userIsValid){
            return  new ErrorResult("Kullanici dogrulamadi");

        }else if (!userInfoCheckerService.checkEmailIsValid(candidate.getEmail())){
            return  new ErrorResult("Lutfen gecerli bir email adresi giriniz");

        }
        else if (idendentityNumberIsExists){
            return  new ErrorResult("kimlik numarasi ile daha once kayitli kullanici var");
        }

        return  candidateService.addCandidate(candidate);
    }
    @GetMapping(name = "getAll")
    public DataResult<List<Candidate>> getAll(){
        return candidateService.getAll();
    }
}
