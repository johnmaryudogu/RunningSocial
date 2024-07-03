package com.Johnmary.MyFitnessApp.Repository;

import com.Johnmary.MyFitnessApp.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel , Long> {

    UserModel findByEmail(String email);
    UserModel findByUsername(String userName);


}
