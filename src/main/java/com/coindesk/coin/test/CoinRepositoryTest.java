package com.coindesk.coin.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.test.context.SpringBootTest;

@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class CoinRepositoryTest {

    @Test
    public void contextLoads() {
    }

}