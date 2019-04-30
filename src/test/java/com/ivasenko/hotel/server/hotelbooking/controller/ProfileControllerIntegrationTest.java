package com.ivasenko.hotel.server.hotelbooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ivasenko.hotel.server.hotelbooking.HotelBookingApplication;
import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import com.ivasenko.hotel.server.hotelbooking.repository.ProfileRepository;
import com.ivasenko.hotel.server.hotelbooking.service.ProfileService;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelBookingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")
public class ProfileControllerIntegrationTest {

    private static final String API_CREATE_PROFILE = "/api/profile";
    private static final String API_GET_PROFILES = "/api/profiles";
    private static final String API_GET_PROFILE_BY_PASSPORT = "/api/profiles/{passport}";
    private static final String API_DELETE_PROFILE_BY_PASSPORT = "/api/profile/{passport}";
    private static final String API_UPDATE_PROFILE = "/api/profile";


    @Autowired
    private MockMvc mockMvc;
    @InjectMocks
    private ProfileController profileController;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private WebApplicationContext wac;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    Gson gson;


    private Profile profile;


    public Profile addProfile(){
        Profile profile = new Profile();
        profile.setLastName("Scot");
        profile.setFirstName("Mark");
        profile.setPassport("BK123456");
        profile.setEmail("mark@mark.com");
        profile.setAddress("Vena");
        profile.setTelephone("380501234567");
        return profile;
    }


    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }


    @Test
    public void CreateProfileTest() throws Exception{
        String s = objectMapper.writeValueAsString(addProfile());
        mockMvc.perform(post(API_CREATE_PROFILE)
       .contentType(MediaType.APPLICATION_JSON)
       .content(s))
       .andDo(print())
       .andExpect(status().isCreated());

        JSONObject jsonObject = (JSONObject) JSONValue.parse(s);
        String passport = (String) jsonObject.get("passport");

        Profile byPassport = profileRepository.findByPassport(passport);
        assertEquals("BK123456", byPassport.getPassport());
        profileService.deleteProfile(byPassport.getId());
    }

    @Test
    public void GetAllProfileTest() throws Exception{
        mockMvc.perform(get(API_GET_PROFILES))
                .andExpect(status().isOk());

    }

    @Test
    public void getProfileByPassportTest() throws Exception {
        Profile profile = profileService.createProfile(addProfile());
        MvcResult result = mockMvc.perform(get(API_GET_PROFILE_BY_PASSPORT, profile.getPassport())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(gson.toJson(profile)))
                .andReturn();

        String str = result.getResponse().getContentAsString();
        assertTrue(str.contains("passport\":\"" + profile.getPassport()));
        profileService.deleteProfile(profile.getId());
    }

    @Test
    public void updateProfileTest() throws Exception {
        Profile profile = profileService.createProfile(addProfile());
        Profile profileUpdate = profileService.findByPassport(profile.getPassport());
        profileUpdate.setFirstName("Bill");
        String s = objectMapper.writeValueAsString(profileUpdate);
        MockHttpServletRequestBuilder builder =
                MockMvcRequestBuilders.put(API_UPDATE_PROFILE)
                .contentType(MediaType.APPLICATION_JSON)
                .content(s);
        mockMvc.perform(builder)
                .andExpect(MockMvcResultMatchers.status().isCreated());
        Profile byPassport = profileService.findByPassport(profileUpdate.getPassport());
        assertEquals("Bill", byPassport.getFirstName());
        profileService.deleteProfile(profileUpdate.getId());
    }

    @Test
    public void deleteProfileTest() throws Exception {
        Profile profile = profileService.createProfile(addProfile());
        mockMvc.perform(delete(API_DELETE_PROFILE_BY_PASSPORT, profile.getPassport()))
                .andExpect(status().isOk());
        boolean byPassport = profileService.existsByPassport(profile.getPassport());

        assertEquals(false, byPassport);
    }

    @Test
    public void existsByPassportTest() throws Exception {
        Profile profile = profileService.createProfile(addProfile());
        boolean byPassport = profileService.existsByPassport(profile.getPassport());

        assertEquals(true, byPassport);
        profileService.deleteProfile(profile.getId());
    }

}
