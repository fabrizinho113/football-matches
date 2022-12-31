package com.solvd.football;

import com.solvd.football.exception.InvalidCaptain;
import com.solvd.football.exception.InvalidForwardValue;
import com.solvd.football.exception.InvalidGoalkeeperValue;
import com.solvd.football.exception.InvalidTeamSize;
import com.solvd.football.match.Match;
import com.solvd.football.person.Player;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LaLigaRunner {

    private static final Logger LOGGER = LogManager.getLogger(LaLigaRunner.class);

    public static void main(String[] args) {

        //Barcelona
        Player terStegen = new Player("ter Stegen", 30, "medium", 0, 70, 0, "GK", 7);
        Player christensen = new Player("Christensen", 26, "medium", 0, 70, 0, "DF", 7);
        Player sRoberto = new Player("Sergi Roberto", 30, "high", 0, 80, 0, "DF", 6);
        Player garcia = new Player("Garcia", 21, "high", 0, 80, 0, "DF", 7);
        Player jAlba = new Player("Jordi Alba", 33, "high", 0, 80, 0, "DF", 7);
        Player busquets = new Player("Busquets", 34, "medium", 0, 70, 0, "MF", 8);
        Player pedri = new Player("Pedri", 20, "high", 0, 90, 0, "MF", 8);
        Player deJong = new Player("de Jong", 25, "high", 1, 90, 0, "MF", 9);
        Player gavi = new Player("Gavi", 18, "high", 0, 90, 0, "MF", 8);
        Player fati = new Player("Ansu Fati", 20, "high", 1, 90, 0, "FW", 8);
        Player lewandowski = new Player("Lewandowski", 34, "high", 1, 90, 0, "FW", 9);

        //Real Madrid
        Player courtois = new Player("Courtois", 30, "medium", 1, 70, 0, "GK", 8);
        Player mendy = new Player("Mendy", 27, "high", 1, 80, 0, "DF", 8);
        Player rudiger = new Player("Rüdiger", 29, "medium", 0, 80, 0, "DF", 7);
        Player militao = new Player("Éder Militão", 24, "medium", 0, 70, 0, "DF", 7);
        Player nacho = new Player("Nacho", 32, "medium", 0, 70, 0, "DF", 7);
        Player valverde = new Player("Valverde", 24, "high", 1, 80, 0, "MF", 8);
        Player modric = new Player("Modrić", 37, "medium", 1, 70, 0, "MF", 8);
        Player kross = new Player("Kross", 32, "medium", 1, 70, 0, "MF", 9);
        Player viniciusJr = new Player("Vinicius Junior", 22, "high", 1, 90, 0, "FW", 9);
        Player benzema = new Player("Benzema", 35, "medium", 1, 70, 0, "FW", 8);
        Player rodrygo = new Player("Rodrygo", 21, "high", 0, 90, 0, "FW", 8);

        //Home team (you)
        //GK
        Match.homePlayerArrayList.add(terStegen);
        //DF
        Match.homePlayerArrayList.add(christensen);
        Match.homePlayerArrayList.add(sRoberto);
        Match.homePlayerArrayList.add(garcia);
        Match.homePlayerArrayList.add(jAlba);
        //MF
        Match.homePlayerArrayList.add(gavi);
        Match.homePlayerArrayList.add(busquets);
        Match.homePlayerArrayList.add(pedri);
        Match.homePlayerArrayList.add(deJong);
        //FW
        Match.homePlayerArrayList.add(lewandowski);
        Match.homePlayerArrayList.add(fati);

        //Away Team (opponent)
        //GK
        Match.awayPlayerArrayList.add(courtois);
        //DF
        Match.awayPlayerArrayList.add(mendy);
        Match.awayPlayerArrayList.add(rudiger);
        Match.awayPlayerArrayList.add(militao);
        Match.awayPlayerArrayList.add(nacho);
        //MF
        Match.awayPlayerArrayList.add(valverde);
        Match.awayPlayerArrayList.add(modric);
        Match.awayPlayerArrayList.add(kross);
        //FW
        Match.awayPlayerArrayList.add(benzema);
        Match.awayPlayerArrayList.add(rodrygo);
        Match.awayPlayerArrayList.add(viniciusJr);


        Match match = new Match();

        try {
            match.menu();

            match.play(Match.homePlayerArrayList, Match.awayPlayerArrayList);
        } catch (InvalidCaptain | InvalidTeamSize | InvalidGoalkeeperValue | InvalidForwardValue e) {
            System.out.println(e.getMessage());
        }


    }
}
