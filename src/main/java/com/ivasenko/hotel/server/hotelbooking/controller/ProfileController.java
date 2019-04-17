package com.ivasenko.hotel.server.hotelbooking.controller;


import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import com.ivasenko.hotel.server.hotelbooking.enums.Message;
import com.ivasenko.hotel.server.hotelbooking.exceptions.ProfileAlreadyExistsException;
import com.ivasenko.hotel.server.hotelbooking.exceptions.ProfileNotFoundException;
import com.ivasenko.hotel.server.hotelbooking.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * Class represents user com.ivasenko.hotel.server.hotelbooking.controller.
 */

@RestController
@RequestMapping(value = "/api")
public class ProfileController {

    private static final Logger LOG = LoggerFactory.getLogger(ProfileController.class);

    private final ProfileService profileService;

    @Autowired
    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    /**
     * Method performs registration operation for new users.
     *
     * @param profile contains user information.
     * @return ResponseEntity
     */
    @PostMapping("/profile")
    public ResponseEntity<?> addProfile(@RequestBody final Profile profile) {
        LOG.info("creating new profile: {}", profile);

        if(profileService.existsByEmail(profile)){
            LOG.info(Message.PROFILE_ALREADY_EXISTS.getMsgBody());
            throw new ProfileAlreadyExistsException(Message.PROFILE_ALREADY_EXISTS.getMsgBody());
        }
        profileService.createProfile(profile);

        return ResponseEntity.status(HttpStatus.CREATED).body(profile.getLastName() + " " + profile.getFirstName());
    }

    /**
     * Method returns registered all profiles.
     *
     * @return ResponseEntity
     */
    @GetMapping("/profiles")
    public ResponseEntity<List<Profile>> getAllProfiles(){
        if (LOG.isDebugEnabled()) {
            LOG.debug("REST request to get all Profiles");
        }
        List<Profile> profiles = profileService.getAllProfile();
        if(profiles == null || profiles.isEmpty()){
            LOG.info(Message.PROFILES_NOT_FOUND.getMsgBody());
            throw new ProfileNotFoundException(Message.PROFILES_NOT_FOUND.getMsgBody());
        }
        return ResponseEntity.status(HttpStatus.OK).body(profiles);
    }

}
