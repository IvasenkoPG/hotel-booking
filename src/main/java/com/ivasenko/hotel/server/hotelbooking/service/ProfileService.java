package com.ivasenko.hotel.server.hotelbooking.service;

import com.ivasenko.hotel.server.hotelbooking.entity.Profile;

import java.util.List;

/**
 * Interface represents Profile service methods.
 */

public interface ProfileService {

    List<Profile> getAllProfile();
    Profile getProfileByPassport(String passport);
    Profile createProfile(Profile profile);
    boolean existsByEmail(Profile profile);
    Profile findByPassport(Profile profile);
    int updateProfile(Profile profile);
    void deleteProfile(Long id);



    
}
