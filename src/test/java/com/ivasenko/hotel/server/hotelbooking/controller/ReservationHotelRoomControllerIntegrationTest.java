package com.ivasenko.hotel.server.hotelbooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivasenko.hotel.server.hotelbooking.HotelBookingApplication;
import com.ivasenko.hotel.server.hotelbooking.entity.HotelRooms;
import com.ivasenko.hotel.server.hotelbooking.entity.Profile;
import com.ivasenko.hotel.server.hotelbooking.entity.ReservationHotelRoom;
import com.ivasenko.hotel.server.hotelbooking.repository.HotelRoomRepository;
import com.ivasenko.hotel.server.hotelbooking.service.ProfileService;
import com.ivasenko.hotel.server.hotelbooking.service.ReservationHotelRoomService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelBookingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")
public class ReservationHotelRoomControllerIntegrationTest{

    private static final String API_CREATE_RESERVATION_ROOM = "/api/reservation";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ReservationHotelRoomService reservationHotelRoomService;

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private HotelRoomRepository hotelRoomRepository;


    public ReservationHotelRoom createReservationHotelRoom(){
        List<Profile> allProfiles = profileService.getAllProfile();
        Profile profile = allProfiles.get(5);
        List<HotelRooms> allHotelRooms = hotelRoomRepository.findAll();
        HotelRooms hotelRoom = allHotelRooms.get(1);


        ReservationHotelRoom reservationHotelRoom = new ReservationHotelRoom();
        reservationHotelRoom.setStartDate("2019-11-23");
        reservationHotelRoom.setFinishDate("2019-11-30");
        reservationHotelRoom.setPriceRoomCount(3500);
        reservationHotelRoom.setAdditionalPriceForOptionCount(406);
        reservationHotelRoom.setHotelRooms(hotelRoom);
        reservationHotelRoom.setProfiles(profile);
        return reservationHotelRoom;
    }



    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(wac)
                .build();
    }


    @Test
    public void CreateReservationHotelRoomTest() throws Exception {

        String s = objectMapper.writeValueAsString(createReservationHotelRoom());

        mockMvc.perform(post(API_CREATE_RESERVATION_ROOM)
                .contentType(MediaType.APPLICATION_JSON)
                .content(s))
                .andDo(print())
                .andExpect(status().isCreated());
    }
}
