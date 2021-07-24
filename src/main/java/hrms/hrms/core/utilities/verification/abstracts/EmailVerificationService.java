package hrms.hrms.core.utilities.verification.abstracts;

import hrms.hrms.entities.abstracts.User;

public interface EmailVerificationService {
    void sendVerificationEmail(String Email, User user);
}
