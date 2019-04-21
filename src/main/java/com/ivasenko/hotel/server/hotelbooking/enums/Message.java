package com.ivasenko.hotel.server.hotelbooking.enums;

/**
 * Represents api response messages.
 */

public enum Message {
    USER_WITH_EMAIL_NOT_EXIST("User with current email doesn't exist!"),
    PROFILE_ALREADY_EXISTS("Email already exists!"),
    HOTEL_ROOMS_NOT_FOUND("Hotel Rooms not found!"),
    HOTEL_ROOMS_RESERVED_NOT_FOUND("Hotel Rooms reserved not found!"),
    PROFILES_NOT_FOUND("Profiles not found!"),
    WALLET_CREATION_LIMIT("You can create only 3 different wallets!"),
    LOW_BALANCE("Your balance is not enough to perform the transfer operation!"),
    EMPTY_AMOUNT("Invalid or empty amount value!"),
    WALLET_WITH_CURRENCY_ALREADY_EXISTS("You've already created a wallet with this currency!"),
    UNAUTHORIZED_ACCESS("You're not authorized to access this resource!"),
    BALANCE_ADD_OPERATION_SUCCESSFUL("Balance addBalance operation successful!"),
    BALANCE_REDUCE_OPERATION_SUCCESSFUL("Balance reduce operation successful!"),
    BALANCE_REPLENISH_OPERATION_SUCCESSFUL("Balance replenish operation successful!"),
    WALLET_SUCCESSFULLY_REMOVED("Wallet was successfully removed!"),
    WALLET_NOT_FOUND("Wallet not found!"),
    OPERATION_IS_NOT_ALLOWED("Operation not allowed! You try to replenish balance between " +
            "multi currency wallets! Please change the flag 'isMultiCurrency' to true to allow such transactions!");

    private final String msgBody;

    Message(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getMsgBody() {
        return msgBody;
    }
}
