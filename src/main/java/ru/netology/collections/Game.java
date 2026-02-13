package ru.netology.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    public void register (Player player) {
        players.put(player.getName(), player);
    }

    public int round (String playerName1, String playerName2) {
      Player p1 = players.get(playerName1);
      Player p2 = players.get(playerName2);

        if (p1 == null) {
           throw  new NotRegisteredException(playerName1);
        }
        if (p2 == null) {
            throw  new NotRegisteredException(playerName2);
        }

        if (p1.getStrength() > p2.getStrength()) {
            return 1;
        } else if (p1.getStrength() < p2.getStrength()) {
            return 2;
        }  else {
            return 0;
        }
    }
}
