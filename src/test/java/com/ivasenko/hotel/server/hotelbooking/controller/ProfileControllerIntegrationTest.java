package com.ivasenko.hotel.server.hotelbooking.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivasenko.hotel.server.hotelbooking.HotelBookingApplication;
import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import com.ivasenko.hotel.server.hotelbooking.repository.ProfileRepository;
import com.ivasenko.hotel.server.hotelbooking.service.ProfileService;
import com.ivasenko.hotel.server.hotelbooking.utils.JsonParserUtil;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
import org.junit.After;
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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;

import static junit.framework.TestCase.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelBookingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")
public class ProfileControllerIntegrationTest {

    private static final String API_CREATE_PROFILE = "/api/profile";
    private static final String CREATE_PROFILE_REQUEST_PATH = "json/new-profile.json";

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

    private Profile profile;

    public Profile addProfile(){
        Profile profile = new Profile();
        profile.setLastName("Scot");
        profile.setFirstName("Mark");
        profile.setPassport("BK 123456");
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


    private String getJson(String pathToJsonFile) throws IOException, ParseException {
        JSONObject jsonObj = JsonParserUtil.parseJsonToObject(pathToJsonFile);
        return jsonObj.toString();
    }

    @Test
    public void whenCreateProfile() throws Exception{
//        String jsonSource = getJson(CREATE_PROFILE_REQUEST_PATH);
        String s = objectMapper.writeValueAsString(addProfile());
        mockMvc.perform(post(API_CREATE_PROFILE)
       .contentType(MediaType.APPLICATION_JSON)
       .content(s))
       .andDo(print())
       .andExpect(status().isCreated());

        JSONObject jsonObject = (JSONObject) JSONValue.parse(s);
        String passport = (String) jsonObject.get("passport");

        Profile byPassport = profileRepository.findByPassport(passport);
        assertEquals("BK 123456", byPassport.getPassport());
    }

}
