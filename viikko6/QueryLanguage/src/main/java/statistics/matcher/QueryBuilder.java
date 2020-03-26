/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistics.matcher;
import java.util.ArrayList;
/**
 *
 * @author laura
 */
public class QueryBuilder {

    Matcher matcher;
    
    public QueryBuilder() {

        matcher = new All();
    }
    
    public QueryBuilder playsIn(String team) {
        this.matcher= new And(matcher, new PlaysIn(team)); 
        return this;
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        this.matcher= new And(matcher, new HasAtLeast(value, category)); 
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        this.matcher= new And(matcher, new HasFewerThan(value, category)); 
        return this;
    }
    
    public QueryBuilder not(Matcher m1) {
        this.matcher= new And(matcher, new Not(m1)); 
        return this;
    }
    
    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.matcher= new Or(m1, m2); 
        return this;
    }
    
    public Matcher build() {
        Matcher matches = matcher;
        matcher = new All();
        return matches;
    }
    
}
