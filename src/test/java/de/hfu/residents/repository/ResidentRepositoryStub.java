package de.hfu.residents.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import de.hfu.residents.domain.Resident;

public class ResidentRepositoryStub implements ResidentRepository {
	private List<Resident> residents = new ArrayList<Resident>();
	
	@Override
	public List<Resident> getResidents() {
		Calendar c = Calendar.getInstance();
		c.set(1990, 4, 2, 0, 0);  
		residents.add(new Resident("Hans", "Müller", "Müllerstr.", "Bochum", c.getTime()));
		c.set(1969, 11, 1, 0, 0);
		residents.add(new Resident("Georg", "Frisch", "Albertschweizerstr.", "Berlin", c.getTime()));
		c.set(1990, 5, 15, 0, 0);
		residents.add(new Resident("Peter", "Gemmel", "Strauchgasse", "Saarbrücken", c.getTime()));
		c.set(2001, 5, 30, 0, 0);
		residents.add(new Resident("Fridolin", "Zermatt", "Alpenblickstr.", "Garmisch", c.getTime()));
		c.set(1930, 1, 10, 0, 0);
		residents.add(new Resident("Gerda", "Zimmermann", "Alexanderstr.", "Berlin", c.getTime()));
		return residents;
	}

}
