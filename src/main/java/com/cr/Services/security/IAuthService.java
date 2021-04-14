package com.cr.Services.security;

import com.cr.model.User;
import com.cr.model.viewmodel.UserViewModel;

public interface IAuthService {

    User isUserValid(UserViewModel model);
}
