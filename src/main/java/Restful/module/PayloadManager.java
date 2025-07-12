package Restful.module;

import Restful.payload.Booking;
import Restful.payload.Bookingdates;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PayloadManager {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String CreatePayload() throws JsonProcessingException {

        Booking booking = new Booking();
        booking.setFirstname("Vijay");
        booking.setLastname("Bajaj");
        booking.setTotalprice(55000);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Breakfast,Lunch");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-05-05");
        bookingdates.setCheckout("2018-05-14");

        booking.setBookingdates(bookingdates);
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;

    }

    public String UpdatePayload() throws JsonProcessingException {

        Booking booking = new Booking();
        booking.setFirstname("Rajiv");
        booking.setLastname("Sharma");
        booking.setTotalprice(65000);
        booking.setDepositpaid(false);
        booking.setAdditionalneeds("Breakfast,Dinner");

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-04-10");
        bookingdates.setCheckout("2025-04-14");

        booking.setBookingdates(bookingdates);
        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;

    }

}
