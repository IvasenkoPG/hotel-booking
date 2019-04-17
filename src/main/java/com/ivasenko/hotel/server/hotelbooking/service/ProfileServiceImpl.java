package com.ivasenko.hotel.server.hotelbooking.service;

import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import com.ivasenko.hotel.server.hotelbooking.repository.ProfileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class represents ProfileService implementation.
 */

@Service
public class ProfileServiceImpl implements ProfileService{

    private static final Logger LOG = LoggerFactory.getLogger(ProfileServiceImpl.class);


    private final ProfileRepository profileRepository;

    @Autowired
    public ProfileServiceImpl(final ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @Override
    public List<Profile> getAllProfile() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to get all Profiles");
        }
        return profileRepository.findAll();
    }

    @Override
    public Profile getProfileByPassport(String passport) {
        return null;
    }

    /**
     * Method save new profile to database.
     *
     * @param profile new profile
     * @return Profile
     */
    @Override
    public Profile createProfile(Profile profile) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to add Profile : {}", profile);
        }
        return profileRepository.saveAndFlush(profile);
    }



    @Override
    public boolean existsByEmail(Profile profile) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to add Profile : {}", profile);
        }
        return profileRepository.existsByEmail(profile.getEmail());
    }

    @Override
    public Profile findByPassport(Profile profile) {
        return profileRepository.findByPassport(profile.getPassport());
    }

    @Override
    public int updateProfile(Profile profile) {
        return 0;
    }

    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }


}
