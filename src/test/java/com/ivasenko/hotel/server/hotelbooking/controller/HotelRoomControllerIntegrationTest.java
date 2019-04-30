package com.ivasenko.hotel.server.hotelbooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ivasenko.hotel.server.hotelbooking.HotelBookingApplication;
import com.ivasenko.hotel.server.hotelbooking.dto.HotelRoomProfileCostDto;
import com.ivasenko.hotel.server.hotelbooking.entity.HotelRooms;
import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import com.ivasenko.hotel.server.hotelbooking.service.HotelRoomService;
import com.ivasenko.hotel.server.hotelbooking.service.ProfileService;
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

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelBookingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")
public class HotelRoomControllerIntegrationTest{

    private static final String API_FIND_ALL_HOTEL_ROOMS = "/api/hotelAllRooms";
    private static final String API_FIND_HOTEL_ROOMS_BY_TYPE_ROOM = "/api/hotelRooms?typeRoom={typeRoom}";
    private static final String API_FIND_HOTEL_ROOM_PROFILE = "/api/hotelRooms/profile?passport={passport}";
    private static final String API_FIND_COST_HOTEL_ROOM_PROFILE = "/api/hotelRooms/cost/profile?passport={passport}";
    private static final String API_FIND_FREE_HOTEL_ROOM = "/api/hotelRooms/free?startDateClient={startDateClient}&finishDateClient={finishDateClient}";

    private String typeRoom = "comfort";
    private String startDateClient = "2019-09-05";
    private String finishDateClient = "2019-09-13";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ProfileService profileService;

    @Autowired
    HotelRoomService hotelRoomService;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    Gson gson;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }


    @Test
    public void GetAllHotelRoomsTest() throws Exception {
        mockMvc.perform(get(API_FIND_ALL_HOTEL_ROOMS))
                .andExpect(status().isOk());

    }

    @Test
    public void getAllHotelRoomsFreeByDatesTest() throws Exception {
        List<HotelRooms> allHotelRoomsFreeByDates = hotelRoomService.findAllHotelRoomsFreeByDates(startDateClient, finishDateClient);
        String s = objectMapper.writeValueAsString(allHotelRoomsFreeByDates);
        mockMvc.perform(get(API_FIND_FREE_HOTEL_ROOM, startDateClient, finishDateClient))
                .andExpect(status().isOk())
                .andExpect(content().json(s));

    }


    @Test
    public void GetAllHotelRoomsByTypeRoomTest() throws Exception {
        mockMvc.perform(get(API_FIND_HOTEL_ROOMS_BY_TYPE_ROOM, typeRoom))
                .andExpect(status().isOk());

    }


    @Test
    public void GetHotelRoomByPassportTest() throws Exception {

        List<Profile> allProfile = profileService.getAllProfile();
        Profile profile = allProfile.get(4);
        mockMvc.perform(get(API_FIND_HOTEL_ROOM_PROFILE, profile.getPassport()))
                .andExpect(status().isOk());
    }

    @Test
    public void getHotelRoomCostByPassportTest() throws Exception {
        List<Profile> allProfile = profileService.getAllProfile();
        Profile profile = allProfile.get(1);
        HotelRoomProfileCostDto hotelRoomCost = hotelRoomService.findHotelRoomCost(profile.getPassport());
        String s = objectMapper.writeValueAsString(hotelRoomCost);

        this.mockMvc.perform(get(API_FIND_COST_HOTEL_ROOM_PROFILE, profile.getPassport()))
                .andExpect(status().isOk())
                .andExpect(content().json(s));

    }
}
