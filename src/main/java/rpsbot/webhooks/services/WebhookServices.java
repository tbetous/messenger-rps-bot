package rpsbot.webhooks.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * Created by Thomas Betous on 24/05/2016.
 */
@Component
public class WebhookServices {

    @Autowired
    Environment environment;

    public String checkCallbackUrl(String mode, String challenge, String verifyToken){
        String token = environment.getProperty("facebook.messenger.token");
        if (verifyToken.equals(token)) {
            return challenge;
        }
        throw new RuntimeException("Error while checking call back url cause of invalid token");
    }
}
