package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggtabell;
	private int nesteledig;

	public Blogg() {
		innleggtabell = new Innlegg[20];
		nesteledig = 0;
	}

	public Blogg(int lengde) {
		innleggtabell = new Innlegg[lengde];
		nesteledig = 0;	
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		boolean finnes = false;
		int x = 0;
		
		while(x < nesteledig && !finnes) {
			if(innleggtabell[x].erLik(innlegg)) {
				finnes = true;
			}
			else {
				x++;
			}
		}
		if(finnes) {
			return x;
		}
		else {
			return -1;
		}
	}

	public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
		int x = 0;
		
		while(x < nesteledig && !finnes) {
			if(innleggtabell[x].erLik(innlegg)) {
				finnes = true;
			}
			else {
				x++;
			}
		}
		
		return finnes;
	}

	public boolean ledigPlass() {

		if(nesteledig < innleggtabell.length) {
			return true;
		}
		
		return false;
	}
	
	public boolean leggTil(Innlegg innlegg) {
		boolean b = false;
		
		if(finnes(innlegg)) {
			b = false;
		}
		else if(!finnes(innlegg) && ledigPlass()) {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			b = true;
		}
		
		return b;
		
	}
	
	public String toString() {
		String s = nesteledig + "\n";
		
		for(int i = 0; i < nesteledig; i++) {
			s += innleggtabell[i].toString();
		}
		
		return s;
	}
}