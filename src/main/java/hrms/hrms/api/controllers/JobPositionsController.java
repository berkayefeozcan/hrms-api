package hrms.hrms.api.controllers;

import hrms.hrms.business.abstracts.JobPositionService;
import hrms.hrms.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jobPositions")
public class JobPositionsController {
    private JobPositionService jobPositionService;

    @Autowired
    public JobPositionsController(JobPositionService jobPositionService) {
        this.jobPositionService= jobPositionService;
    }

    @GetMapping("/getall")
    public List<JobPosition> getAll(){
        return this.jobPositionService.getAll();
    }
}
