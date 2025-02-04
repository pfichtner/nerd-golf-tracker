package de.itagile.golf.operation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import de.itagile.golf.Operation;
import de.itagile.golf.Scorecard;

class LochwechselausgabeTest {
	
	private Scorecard scorecard = mock(Scorecard.class);
	private Operation folgeoperation = mock(Operation.class);
	private Lochwechselausgabe lochwechselausgabe = new Lochwechselausgabe(folgeoperation);	

	@Test
	void gibtZuruecksetzenAus() {
		assertThat(lochwechselausgabe.fuehreAus(scorecard), containsString("Deine Schlagzahl wurde zurückgesetzt"));
	}
	
	@Test
	void gibtAusgabeDerFolgeoperationMitAus() {
		when(folgeoperation.fuehreAus(any(Scorecard.class))).thenReturn("folgeoperationAusgabe");
		
		assertThat(lochwechselausgabe.fuehreAus(scorecard), containsString("folgeoperationAusgabe"));	
	}

}
