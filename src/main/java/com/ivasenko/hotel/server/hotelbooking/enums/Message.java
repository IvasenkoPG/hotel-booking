package com.ivasenko.hotel.server.hotelbooking.enums;

/**
 * Represents api response messages.
 */

public enum Message {
    PROFILE_ALREADY_EXISTS("Profile already exists!"),
    PROFILE_NOT_FOUND("Profile not found!"),
    PROFILES_NOT_FOUND("Profiles not found!"),
    HOTEL_ROOMS_NOT_FOUND("Hotel Rooms not found!"),
    HOTEL_ROOMS_RESERVED_NOT_FOUND("Hotel Rooms reserved not found!"),
    HOTEL_ROOMS_BY_PROFILE_NOT_FOUND("Hotel Rooms by profile not found!"),
    HOTEL_ROOMS_OCCUPIED_FOUND("Hotel Rooms OCCUPIED!");



    private final String msgBody;

    Message(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getMsgBody() {
        return msgBody;
    }
}
