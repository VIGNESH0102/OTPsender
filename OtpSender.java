package project_task01;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import java.util.Random;
import java.util.Scanner;

public class OtpSender {

    public static final String ACCOUNT_SID = "ACc4af331adfb7cd2c062a9d478ec4f632";
    public static final String AUTH_TOKEN = "1577c7835a0250855ce371d73419a619";
    public static final String TWILIO_PHONE_NUMBER = "‪+14122264818";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter phone number with country code: ");
        String phoneNumber = scanner.nextLine();

        String otp = String.format("%06d", new Random().nextInt(1000000));

        
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        
        Message.creator(
            new com.twilio.type.PhoneNumber(phoneNumber),
            new com.twilio.type.PhoneNumber(TWILIO_PHONE_NUMBER),
            "Your OTP is: " + otp
        ).create();

        System.out.println("OTP sent successfully to " + phoneNumber);

        
        System.out.print("Enter the OTP you received: ");
        String enteredOtp = scanner.nextLine();

        if (otp.equals(enteredOtp)) {
            System.out.println("✅ OTP Verified Successfully! Access Granted.");
        } else {
            System.out.println("❌ Incorrect OTP! Access Denied.");
        }

        scanner.close();
    }
}