package com.diogo.vivo.repositories;

import com.diogo.vivo.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer> {

    @Transactional(readOnly = true)
    UserModel findByEmail(String email);
}
