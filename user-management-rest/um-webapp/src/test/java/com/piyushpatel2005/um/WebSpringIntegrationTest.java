package com.piyushpatel2005.um;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.piyushpatel2005.um.spring.UmContextConfig;
import com.piyushpatel2005.um.spring.UmPersistenceJpaConfig;
import com.piyushpatel2005.um.spring.UmServiceConfig;
import com.piyushpatel2005.um.spring.UmWebConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { UmPersistenceJpaConfig.class, UmContextConfig.class, UmServiceConfig.class, UmWebConfig.class })
@WebAppConfiguration
public class WebSpringIntegrationTest {

    @Test
    public final void whenContextIsBootstrapped_thenOk() {
        //
    }

}
