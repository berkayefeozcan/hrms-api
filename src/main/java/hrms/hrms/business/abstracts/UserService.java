package hrms.hrms.business.abstracts;

import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.entities.abstracts.User;

import java.util.List;

public interface UserService {
    DataResult<User> getByEmail(String email);
}
