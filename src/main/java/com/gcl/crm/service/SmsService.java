package com.gcl.crm.service;

import com.gcl.crm.dto.SmsPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Component
public class SmsService {
    private final String ACCOUNT_SID = "ACafff2717e3385d802c79c856337c4339";
    private final String AUTH_TOKEN = "c9f8d4d1d1e4fc5a2f729ac0353f02bb";
    private final String FROM_NUMBER = "+16303608942";

    public void send(SmsPojo sms) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(new PhoneNumber(sms.getTo()), new PhoneNumber(FROM_NUMBER), sms.getMessage())
                .create();
        System.out.println("here is my id:"+ message.getSid());// Unique resource ID created to manage this transaction
    }

    public void receive(MultiValueMap<String, String> smscallback) {
    }

}
