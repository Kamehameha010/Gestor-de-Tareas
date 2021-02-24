package services.security;

import java.sql.SQLException;

import model.User;
import model.viewmodel.UserViewModel;

public interface IAuthService {

    User isvalid(UserViewModel model) throws SQLException;
}
