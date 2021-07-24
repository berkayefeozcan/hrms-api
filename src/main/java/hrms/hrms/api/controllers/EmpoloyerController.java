package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.EmployerService;
import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.ErrorResult;
import hrms.hrms.core.utilities.results.Result;
import hrms.hrms.core.utilities.verification.abstracts.UserInfoCheckerService;
import hrms.hrms.entities.concretes.Employer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employers")
public class EmpoloyerController {
    EmployerService employerService;
    UserService userService;
    UserInfoCheckerService userInfoCheckerService;
    @Autowired
    public EmpoloyerController(EmployerService employerService,UserService userService,UserInfoCheckerService userInfoCheckerService){
        this.employerService=employerService;
        this.userService= userService;
        this.userInfoCheckerService = userInfoCheckerService;
    }
    @PostMapping(name = "addEmployer")
    public Result addEmployer( @RequestBody  Employer employer){
        if(userService.getByEmail(employer.getEmail()).getData()!=null){
            return new ErrorResult("sirketin kayitli bir emaili daha onceden var");
        }else if(!userInfoCheckerService.checkEmailIsValid(employer.getEmail())){
            return new ErrorResult("Lutfen gecerli bir email giriniz");
        }
        return this.employerService.add(employer);
    }
    @GetMapping(name = "getAll")
    public DataResult<List<Employer>> getAll(){
        return employerService.getAll();
    }
}
