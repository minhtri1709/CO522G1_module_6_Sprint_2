package be.talent.service;

import be.talent.model.Role;
import be.talent.model.User;

public interface IUserService {

    User findByUsername(String name);
}
