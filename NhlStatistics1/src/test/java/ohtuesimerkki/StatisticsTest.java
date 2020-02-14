/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtuesimerkki;

/**
 *
 * @author laura
 */
import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class StatisticsTest {
    
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }  
    
    
    
    @Test
    public void searchEtsiiOikean() {
        assertEquals("Semenko", stats.search("Semenko").getName());
    } 
    
    @Test
    public void searchOlemattoman() {
        assertEquals(null, stats.search("Seppanen"));
    } 
    
    @Test
    public void teamTesti() {
        assertEquals("Kurri", stats.team("EDM").get(1).getName());
    } 
    
    @Test
    public void topScorersTesti() {
        assertEquals("Lemieux", stats.topScorers(2).get(1).getName());
    } 
    
    @Test
    public void topScorersNegInput() {
        assertEquals(true, stats.topScorers(-1).isEmpty());
    }
    
    
}
