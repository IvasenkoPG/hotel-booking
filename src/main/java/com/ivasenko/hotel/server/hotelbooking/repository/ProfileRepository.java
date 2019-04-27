package com.ivasenko.hotel.server.hotelbooking.repository;

import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Represents Profile repository interface.
 */

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

    boolean existsByPassport(String passport);
    Profile findByPassport(String passport);
}
