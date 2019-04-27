package com.ivasenko.hotel.server.hotelbooking.service;

import com.ivasenko.hotel.server.hotelbooking.entity.Profile;

import java.util.List;
import java.util.Optional;

/**
 * Interface represents Profile service methods.
 */

public interface ProfileService {

    List<Profile> getAllProfile();
    Profile createProfile(Profile profile);
    boolean existsByPassport(String passport);
    Profile findByPassport(String passport);
    Profile updateProfile(Profile profile);
    void deleteProfile(Long id);



    
}
