package com.crxmarkets.it;

import com.crxmarkets.web.RequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.jboss.resteasy.util.HttpResponseCodes;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {
    @Test
    public void testREST() throws Exception {

        HttpClient client = new HttpClient();
        {
            GetMethod getMethod = new GetMethod("http://localhost:8080/water-after-rain/rest/heartbeat");
            int status = client.executeMethod(getMethod);
            Assert.assertEquals(HttpResponseCodes.SC_OK, status);
            getMethod.releaseConnection();
        }
        {
            ObjectMapper mapper = new ObjectMapper();
            RequestDTO dto = new RequestDTO();
            dto.setList(Arrays.asList(9, 2, 9));
            PostMethod postMethod = new PostMethod("http://localhost:8080/water-after-rain/rest/surface");
            postMethod.setRequestEntity(new StringRequestEntity(mapper.writeValueAsString(dto), "application/json", null));
            int status = client.executeMethod(postMethod);
            Assert.assertEquals(HttpResponseCodes.SC_OK, status);
            assertEquals("7", postMethod.getResponseBodyAsString());
            postMethod.releaseConnection();
        }

    }
}
