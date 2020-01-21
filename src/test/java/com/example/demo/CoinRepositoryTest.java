package com.example.demo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
public class CoinRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private CoinRepository coinRepository;

    @Test
    public void whenFindByValue_thenReturnCoin(){
        Coin ethereum = new Coin("ethereum", 166);
        entityManager.persist(ethereum);
        entityManager.flush();

        // When
        com.coindesk.coin.Coin found = coinRepository.findValue(ethereum.getValue());

        // Then
        assertThat(found.getValue()).isEqualTo(ethereum.getValue());
    }
}
