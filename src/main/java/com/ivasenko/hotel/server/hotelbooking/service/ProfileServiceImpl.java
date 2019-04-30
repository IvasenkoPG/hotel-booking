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


    /**
     * Method Returns all profiles for the database.
     *
     * @return List Profile
     */
    @Override
    public List<Profile> getAllProfile() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request to get all Profiles");
        }
        return profileRepository.findAll();
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

    /**
     * Method checks if profile with passport exists in database.
     *
     * @param passport passport
     * @return boolean true if profile exists, false otherwise
     */
    @Override
    public boolean existsByPassport(String passport) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Request the confirmation profile by passport : {}", passport);
        }
        return profileRepository.existsByPassport(passport);
    }

    /**
     * Method search for profile by passport.
     *
     * @param passport passport
     * @return Profile
     */
    @Override
    public Profile findByPassport(String passport) {
        return profileRepository.findByPassport(passport);
    }

    /**
     * Method update profile to database.
     *
     * @param profile new profile
     * @return Profile
     */
    @Override
    public Profile updateProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    /**
     * Method  profile from the database.
     *
     * @param id profile id
     */
    @Override
    public void deleteProfile(Long id) {
        profileRepository.deleteById(id);
    }
}
