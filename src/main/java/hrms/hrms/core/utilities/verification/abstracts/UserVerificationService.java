package hrms.hrms.core.utilities.verification.abstracts;


import java.util.Date;

public interface UserVerificationService {
    boolean checkPersonIsValid(String identityNumber,String firstName,String lastname, Date birthOfDate);
}
