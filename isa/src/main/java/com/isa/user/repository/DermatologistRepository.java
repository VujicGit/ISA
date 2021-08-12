package com.isa.user.repository;

import com.isa.user.domain.Dermatologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DermatologistRepository extends JpaRepository<Dermatologist, Long> {

    @Query(value = "SELECT d from Dermatologist d JOIN FETCH d.address")
    List<Dermatologist> findAllWithAddress();
}
