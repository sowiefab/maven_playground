package de.hfu.residents.service;

import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;



public class BaseResidentServiceIntWMockTest {

	@Test
	public void testWrongDay() {
		// setup Data for mock to return
		List<Resident> residents = new ArrayList<Resident>();
		Calendar c = Calendar.getInstance();
		c.set(1969, 11, 1, 0, 0);
		residents.add(new Resident("Georg", "Frisch", "Albertschweizerstr.", "Berlin", c.getTime()));
		c.set(1990, 5, 15, 0, 0);
		residents.add(new Resident("Gerda", "Zimmermann", "Alexanderstr.", "Berlin", c.getTime()));
		
		ResidentRepository repoMock = createMock(ResidentRepository.class);
		expect(repoMock.getResidents()).andReturn(residents);
		replay(repoMock);
		Resident r = new Resident();
		r.setGivenName("Gerda");
		r.setFamilyName("Zimmermann");
		r.setStreet("Alexanderstr.");
		
		c.set(1969, 11, 15,6,8);
		r.setDateOfBirth(c.getTime());
		
		BaseResidentService service = new BaseResidentService();
		service.setResidentRepository(repoMock);
		List<Resident> lr = service.getFilteredResidentsList(r);
		assertEquals(lr.size(), 0);
	}

}
