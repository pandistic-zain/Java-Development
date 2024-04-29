
package storemanagementsystem;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SentSMS 
{
    public static final String ACCOUNT_SID = "AC67beb3e8fcc27f3810d6cf5622385a3d";
    public static final String AUTH_TOKEN = "2640c0724d32413f5dc3316e83f3fff4";

    public static void sendingsms() 
    {
        // Initialize the Twilio client
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        // Your Twilio phone number (must be purchased from Twilio)
        String twilioPhoneNumber = "+12294145022";

        // Recipient's phone number
        String toPhoneNumber = "+923160583721"; // Replace with the recipient's phone number

        // Message to send
        String messageBody = "This Is Store Management System!";

        // Send the SMS
        Message message = Message.creator(
                new PhoneNumber(toPhoneNumber),
                new PhoneNumber(twilioPhoneNumber),
                messageBody)
                .create();

        // Print the SID of the sent message
        System.out.println("Message Sent with SID : " + message.getSid());
    }
}