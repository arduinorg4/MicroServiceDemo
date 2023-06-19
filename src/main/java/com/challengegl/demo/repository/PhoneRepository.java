package com.challengegl.demo.repository;

import com.challengegl.demo.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}
