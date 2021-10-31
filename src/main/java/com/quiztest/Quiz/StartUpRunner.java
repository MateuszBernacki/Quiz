package com.quiztest.Quiz;


import com.quiztest.Quiz.database.entities.PlayerEntity;
import com.quiztest.Quiz.database.repositories.PlayerRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Component
@Log
public class StartUpRunner implements CommandLineRunner {

    @Autowired
     private PlayerRepository playerRepository;


    @Override
    @Transactional
    public void run(String... args) throws Exception {
        log.info("Executing stat up actions.. ");
        playerRepository.save(new PlayerEntity("Hubert"));
        playerRepository.save(new PlayerEntity("Paweł"));
        playerRepository.save(new PlayerEntity("Mateusz"));

        log.info("List of players from data base: ");
        List<PlayerEntity> PlayersFromDataBase = playerRepository.findAll();
        for (PlayerEntity player :
                PlayersFromDataBase) {
            log.info("Retrieved player: " +player);
        }
    }

//    @Autowired
//    private EntityManager entityManager;

//    @Override
//    @Transactional
//    public void run(String... args) throws Exception {
//        log.info("Executing stat up actions.. ");
//
//        PlayerEntity player = new PlayerEntity("Mateusz");
//        log.info("Create player " + player);
//
//        entityManager.persist(player);
//        log.info("Same player after persist: " + player);
//
//        log.info("List of players from data base: ");
//        Query q = entityManager.createQuery("SELECT p FROM Players p");
//        List<PlayerEntity> playersFromDb = (List<PlayerEntity>) q.getResultList();
//
//        for (PlayerEntity playerFromDB : playersFromDb) {
//            log.info("Player from DB: " + playerFromDB);
//        }
//
//    }
}
