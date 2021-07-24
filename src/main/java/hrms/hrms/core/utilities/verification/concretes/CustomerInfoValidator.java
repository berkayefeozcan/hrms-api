package hrms.hrms.core.utilities.verification.concretes;

import hrms.hrms.core.utilities.verification.abstracts.UserInfoCheckerService;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Service
public class CustomerInfoValidator implements UserInfoCheckerService {
    private final String regex =  "^[A-Za-z0-9+_.-]+@(.+)$";
    private Pattern pattern = Pattern.compile(regex);

    @Override
    public boolean checkEmailIsValid(String email) {
        Matcher matcher = this.pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public boolean checkPass(String pass) {
        return pass.length()>=6;
    }

    @Override
    public boolean checkFullName(String name, String surName) {
        return name.length()>2 && surName.length()>2;
    }
}
