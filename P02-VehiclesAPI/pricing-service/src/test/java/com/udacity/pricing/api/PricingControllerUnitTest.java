package com.udacity.pricing.api;

import com.netflix.discovery.converters.Auto;
import com.udacity.pricing.service.PricingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PricingController.class)
public class PricingControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PricingService pricingService;

    @Test
    public void priceGet() throws Exception {
        mockMvc.perform(get("/services/price").param("vehicleId", String.valueOf(1)))
            .andExpect(status().isOk())
            .andDo(print());
    }
}
