package services.security;

import model.User;
import model.viewmodel.UserViewModel;

public interface IAuthService {

    User isUserValid(UserViewModel model);
}
