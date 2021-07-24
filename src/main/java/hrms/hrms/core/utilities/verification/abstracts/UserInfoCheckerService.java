package hrms.hrms.core.utilities.verification.abstracts;

public interface UserInfoCheckerService {
    boolean checkEmailIsValid(String email);
    boolean checkPass(String pass);
    boolean checkFullName(String name,String surName);
}
