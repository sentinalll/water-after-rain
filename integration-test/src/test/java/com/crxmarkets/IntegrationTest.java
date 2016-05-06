package com.crxmarkets;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.jboss.resteasy.util.HttpResponseCodes;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegrationTest {
  @Test
  public void testNoDefaultsResource() throws Exception {

    HttpClient client = new HttpClient();

    GetMethod getMethod = new GetMethod("http://localhost:8080/test-war/heartbeat");
    int status = client.executeMethod(getMethod);
    assertEquals(HttpResponseCodes.SC_OK, status);
    getMethod.releaseConnection();

    PostMethod postMethod = new PostMethod("http://localhost:8080/test-war/surface");
    postMethod.setRequestEntity(new StringRequestEntity("basic", "application/json", null));
    status = client.executeMethod(postMethod);
    assertEquals(204, status);
    assertEquals(7, postMethod.getResponseBodyAsString());
    postMethod.releaseConnection();

  }
}
