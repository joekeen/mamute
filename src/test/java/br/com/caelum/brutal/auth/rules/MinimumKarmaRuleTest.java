package br.com.caelum.brutal.auth.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Test;

import br.com.caelum.brutal.dao.TestCase;
import br.com.caelum.brutal.model.Question;
import br.com.caelum.brutal.model.User;

public class MinimumKarmaRuleTest extends TestCase {
    private MinimumKarmaRule<Question> rule = new MinimumKarmaRule<>(10);
    private User author = user("chico", "chico@brutal.com");
    private Question question = question("title", "description", author);

    @Test
    public void should_allow_user_with_enough_karma() {
        User u = user("user with 10 karma", "karma@brutal.com");
        setKarma(u, 10l);
        
        assertTrue(rule.isAllowed(u, question));
    }
    
    @Test
    public void should_disallow_user_with_low_karma() {
        User noob = user("noob", "noob@brutal.com");
        setKarma(noob, 1l);
        
        assertFalse(rule.isAllowed(noob, question));
    }

    private void setKarma(User u, long karma) {
        new Mirror().on(u).set().field("karma").withValue(karma);
    }
    
    

}
