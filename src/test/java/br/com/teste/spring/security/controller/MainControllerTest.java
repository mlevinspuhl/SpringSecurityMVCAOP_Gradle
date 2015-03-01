package br.com.teste.spring.security.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.teste.spring.security.business.controller.MainController;
import br.com.teste.spring.security.business.rest.RestfulController;
import br.com.teste.spring.security.commons.IntegrationTestUtil;
import br.com.teste.spring.security.config.AppConfig;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {
        // MVC application context to be tested
        AppConfig.class,
})
public class MainControllerTest {
 
    @Autowired WebApplicationContext wac; 
    @Autowired MockHttpSession session;
    @Autowired MockHttpServletRequest request;

    private MockMvc mockMvc;
 
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
 
    @Test public void helloWorld() throws Exception {
        mockMvc.perform(get("/hello").accept(IntegrationTestUtil.TEXT_PLAIN_ISO88591))
                .andExpect(status().isOk())
                .andExpect(content().contentType(IntegrationTestUtil.TEXT_PLAIN_ISO88591))
                .andExpect(content().string("Hello World!"));
    }
    
    @Test public void greetings() throws Exception {
        mockMvc.perform(get("/rest/v1.0/greeting?name=World").accept(IntegrationTestUtil.TEXT_PLAIN_ISO88591))
                .andExpect(status().isOk())
                .andExpect(content().contentType(IntegrationTestUtil.TEXT_PLAIN_ISO88591))
                .andExpect(content().string("Hello! World1 - Teste ok"));
    }

}