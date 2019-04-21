package com.ivasenko.hotel.server.hotelbooking.controller;

import com.ivasenko.hotel.server.hotelbooking.HotelBookingApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HotelBookingApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations="classpath:application.properties")
public class HotelRoomControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGetAllHotelRoomsByTypeRoom() throws Exception{
        mockMvc.perform(get("/api/hotelRooms?typeRoom=comfort"))
                .andExpect(status().isOk());

    }

    @Test
    public void whenGetAllHotelRoomsReservedByTypeRoom() throws Exception{
        mockMvc.perform(get("/api/hotelRooms/reserved?typeRoom=comfort"))
                .andExpect(status().isOk());

    }

    @Test
    public void whenGetAllHotelRooms() throws Exception{
        mockMvc.perform(get("/api/hotelAllRooms"))
                .andExpect(status().isOk());

    }

}
