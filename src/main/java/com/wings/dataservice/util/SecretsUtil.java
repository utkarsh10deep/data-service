package com.wings.dataservice.util;

import com.wings.dataservice.domain.Secrets;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static com.wings.dataservice.constants.Constants.*;

public class SecretsUtil {
    private static String getHeaderKeyValue() {
        return Decoder.decodeNumber(SECRET_SUB_KEY) + Decoder.decode(SECRET_INGREDIENT);
    }

    public static void initializeSecrets() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        headers.set(HEADER_KEY_ID, getHeaderKeyValue());
        headers.set(HEADER_SERVICE_ID, SERVICE_NAME);

        HttpEntity entityReq = new HttpEntity(headers);

        RestTemplate template = new RestTemplate();

        ResponseEntity<Secrets> respEntity = template.exchange(EndpointUtil.getSecretEndpoint(), HttpMethod.GET, entityReq, Secrets.class);
        Secrets secrets = respEntity.getBody();
        System.setProperty(DATASOURCE_USERNAME_KEY, secrets.getH2UserName());
        System.setProperty(DATASOURCE_PASSWORD_KEY, secrets.getH2Password());
        System.setProperty(SERVICE_KEY, secrets.getServiceAuthenticationKey());
    }
}
