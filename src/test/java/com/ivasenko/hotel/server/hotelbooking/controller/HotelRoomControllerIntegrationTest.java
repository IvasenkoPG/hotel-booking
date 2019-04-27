package com.ivasenko.hotel.server.hotelbooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivasenko.hotel.server.hotelbooking.HotelBookingApplication;
import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import com.ivasenko.hotel.server.hotelbooking.service.ProfileService;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelBookingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")
public class HotelRoomControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ProfileService profileService;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

//    public Profile addProfile(){
//        Profile profile = new Profile();
//        profile.setLastName("Scot");
//        profile.setFirstName("Mark");
//        profile.setPassport("BK123456");
//        profile.setEmail("mark@mark.com");
//        profile.setAddress("Vena");
//        profile.setTelephone("380501234567");
//        return profile;
//    }

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }
    @Test
    public void whenGetAllHotelRoomsByTypeRoom() throws Exception{
        mockMvc.perform(get("/api/hotelRooms?typeRoom=comfort"))
                .andExpect(status().isOk());

    }

    @Test
    public void whenGetAllHotelRoomsReservedByTypeRoom() throws Exception{
        mockMvc.perform(get("/api/hotelRooms/reserved?status=true"))
                .andExpect(status().isOk());

    }

    @Test
    public void whenGetAllHotelRooms() throws Exception{
        mockMvc.perform(get("/api/hotelAllRooms"))
                .andExpect(status().isOk());

    }

//    @Test
//    public void whenGetHotelRoomByPassport() throws Exception{
//        Profile profile = profileService.createProfile(addProfile());
//
//        mockMvc.perform(get("/api/hotelRooms/profile?passport={passport}", profile.getPassport()))
//                .andExpect(status().isOk());
//
//        profileService.deleteProfile(profile.getId());
//    }

}
