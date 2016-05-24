package rpsbot.webhooks.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import rpsbot.webhooks.services.WebhookServices;


@Controller
@RequestMapping("/")
public class WebhookController {

    @Autowired
    private WebhookServices webhookServices;

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public String checkCallbackUrl(@RequestParam("hub.mode") String mode,
                                 @RequestParam("hub.challenge") String challenge,
                                 @RequestParam("hub.verify_token") String verify_token) {
        return webhookServices.checkCallbackUrl(mode, challenge, verify_token);
    }
}
