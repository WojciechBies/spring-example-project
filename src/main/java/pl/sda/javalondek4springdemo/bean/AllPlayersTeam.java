package pl.sda.javalondek4springdemo.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AllPlayersTeam {

    private final Map<String, Player> allPlayers;
    private final Logger logger = LoggerFactory.getLogger(AllPlayersTeam.class);

    public AllPlayersTeam(Map<String, Player> allPlayers) {
        this.allPlayers = allPlayers;

        allPlayers.keySet().forEach(beanName -> logger.info("bean name: [{}]", beanName));
    }
}
