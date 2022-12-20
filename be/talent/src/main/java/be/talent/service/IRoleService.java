package be.talent.service;

import be.talent.model.Role;

public interface IRoleService {
    Role findByUsername(String name);
}
