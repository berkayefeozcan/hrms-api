package hrms.hrms.business.concretes;

import hrms.hrms.business.abstracts.UserService;
import hrms.hrms.core.utilities.results.DataResult;
import hrms.hrms.core.utilities.results.SuccessDataResult;
import hrms.hrms.dataAccess.abstracts.UserDao;
import hrms.hrms.entities.abstracts.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao ;
    @Autowired
    public UserManager(UserDao userDao){
        this.userDao = userDao;
    }
    @Override
    public DataResult<User> getByEmail(String email) {
        return new SuccessDataResult<User>(userDao.findByEmail(email));
    }
}
