package com.example.superheroes.antiHero.service;

import com.example.superheroes.antiHero.entity.AntiHeroEntity;
import com.example.superheroes.antiHero.repository.AntiHeroRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AntiHeroServiceTest {

    @Mock
    private AntiHeroRepository repo;

    @InjectMocks
    private AntiHeroService underTest;

    @Test
    void canAddAntiHero() {
        AntiHeroEntity antiHero = new AntiHeroEntity(
                UUID.randomUUID(),
                "Bunao",
                "Lakandula",
                "Tondo",
                "Datu of Tondo",
                new SimpleDateFormat("dd-MM-yyyy HH:mm:ss z").format(new Date())
        );

        underTest.addAntiHero(antiHero);

        ArgumentCaptor<AntiHeroEntity> antiHeroDroArgumentCaptor = ArgumentCaptor.forClass(AntiHeroEntity.class);

        verify(repo).save(antiHeroDroArgumentCaptor.capture());

        AntiHeroEntity captureAntiHero = antiHeroDroArgumentCaptor.getValue();

        assertThat(captureAntiHero).isEqualTo(antiHero);
    }

    @Test
    void canFindAllAntiHeroes() {
        underTest.findAllAntiHeroes();

        verify(repo).findAll();
    }
}
