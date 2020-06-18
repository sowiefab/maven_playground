package de.hfu.residents.service;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

import de.hfu.residents.domain.Resident;
import de.hfu.residents.repository.ResidentRepository;
import de.hfu.residents.repository.ResidentRepositoryStub;

// name has to End or start with Test for mvn to execute it
public class BaseResidentServiceIntWStubTest {
	private ResidentRepository residentRepo = new ResidentRepositoryStub();
	private BaseResidentService service = new BaseResidentService();
	
	@Test
	public void testContains3StreetNamesWithA() {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Resident r = new Resident();
		r.setStreet("A*");
		List<Resident> lr = new ArrayList<Resident>();
		lr = service.getFilteredResidentsList(r);
		assertEquals(lr.size(), 3);
	}
	
	@Test
	public void testContains5Names() {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Resident r = new Resident();
		r.setFamilyName("*");
		r.setGivenName("*");
		List<Resident> lr = new ArrayList<Resident>();
		lr = service.getFilteredResidentsList(r);
		assertEquals(lr.size(), 5);
	}
	
	@Test
	public void testCityFilterNotImplemented() {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Resident r = new Resident();
		r.setCity("Berlin");  // in stub 2 are from berlin
		// r.setStreet("Berlin");
		List<Resident> lr = new ArrayList<Resident>();
		lr = service.getFilteredResidentsList(r);
		assertNotEquals(lr.size(), 2);  // returns 5 as not implemented
	}
	
	@Test
	public void testContainsBirthDate199042() throws ResidentServiceException {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Resident r = new Resident();
		Calendar c = Calendar.getInstance();
		c.set(1990, 4, 2, 0, 0);  
		r.setDateOfBirth(c.getTime());
		Resident rr = new Resident();
		rr = service.getUniqueResident(r);
		assertNotEquals(rr, null);
	}
	
	@Test(expected=ResidentServiceException.class, timeout=1000)
	public void testDoesNotContainResident() throws ResidentServiceException {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Resident r = new Resident();
		Calendar c = Calendar.getInstance();
		c.set(2019, 4, 2, 0, 0);  
		r.setDateOfBirth(c.getTime());
		service.getUniqueResident(r);
	}
	
	@Test(expected=ResidentServiceException.class, timeout=1000)
	public void testWildcardNotAllowedInName() throws ResidentServiceException {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Resident r = new Resident();
		r.setGivenName("G*");
		service.getUniqueResident(r);
	}
	
	@Test(expected=ResidentServiceException.class, timeout=1000)
	public void testWildcardNotAllowedInStreet() throws ResidentServiceException {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Resident r = new Resident();
		r.setStreet("*str");
		service.getUniqueResident(r);
	}
	
	@Test(expected=ResidentServiceException.class, timeout=1000)
	public void testWildcardNotAllowedInFamilyName() throws ResidentServiceException {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Resident r = new Resident();
		r.setFamilyName("A*");
		service.getUniqueResident(r);
	}
	
	@Test
	public void testContainsGeorgFrisch() throws ResidentServiceException {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Calendar c = Calendar.getInstance(); 
		c.set(1969, 11, 1, 0, 0);
		Resident r = new Resident();
		r.setGivenName("Georg");
		r.setFamilyName("Frisch");
		r.setDateOfBirth(c.getTime());
		Resident rr = new Resident();
		rr = service.getUniqueResident(r);
		assertNotEquals(rr, null);
	}
	
	@Test
	public void testContainsZimmermannAsFamilyName() throws ResidentServiceException {
		service.setResidentRepository(residentRepo);  // DI with stub element
		Calendar c = Calendar.getInstance(); 
		c.set(1969, 11, 1, 0, 0);
		Resident r = new Resident();
		r.setFamilyName("Zimmermann");
		Resident rr = new Resident();
		rr = service.getUniqueResident(r);
		assertNotEquals(rr, null);
	}

}
