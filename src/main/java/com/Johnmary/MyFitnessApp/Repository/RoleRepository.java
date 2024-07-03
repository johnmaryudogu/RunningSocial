package com.Johnmary.MyFitnessApp.Repository;

import com.Johnmary.MyFitnessApp.Model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,Long> {
    Role findByName(String name);


}
