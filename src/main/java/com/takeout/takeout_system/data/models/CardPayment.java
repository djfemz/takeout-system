package com.takeout.takeout_system.data.models;

import java.time.LocalDateTime;

public class CardPayment extends Payment{
    private String cardAccountNumber;
    private LocalDateTime expiryDate;
}
