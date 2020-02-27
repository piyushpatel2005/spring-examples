package com.piyushpatel2005.consumingsoap;

import com.dataaccess.webservicesserver.NumberToWords;
import com.dataaccess.webservicesserver.NumberToWordsResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import java.math.BigInteger;

public class NumberClient extends WebServiceGatewaySupport {
    public NumberToWordsResponse getWords(String numbers) {
        String uri = "https://www.dataaccess.com/webservicesserver/NumberConversion.wso";
        //set up request
        NumberToWords numberRequest = new NumberToWords();
        numberRequest.setUbiNum(new BigInteger(numbers));

        // get and return response
        NumberToWordsResponse response = (NumberToWordsResponse) getWebServiceTemplate().marshalSendAndReceive(uri, numberRequest);
        return response;
    }
}
