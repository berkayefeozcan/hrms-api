package hrms.hrms.core.utilities.verification.concretes;

import hrms.hrms.core.utilities.verification.abstracts.UserVerificationService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MernisUserValidator implements UserVerificationService {
    @Override
    public boolean checkPersonIsValid(String identityNumber,String firstName,String lastname, Date birthOfDate) {
         return true;
    }
}
