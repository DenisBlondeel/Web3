package db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.Person;

public class PersonRepositoryInMemory implements PersonRepository {
	private Map<String, Person> persons = new HashMap<String, Person>();
	
	public PersonRepositoryInMemory () {
		Person administrator = new Person("admin", "admin@ucll.be", "t", "Ad", "Ministrator");
		Person denis = new Person("baas", "denis@wina.be", "yolo", "denis", "Blondeel");
		Person lotte = new Person("preses", "lote@chemika.be", "yolo", "lotte", "clinckemalie");
		Person caro = new Person("vice", "carolyne@wina.be", "yolo", "carolyne", "peelman");
		add(administrator);
		add(denis);
		add(lotte);
		add(caro);
	}
	
	@Override
	public Person get(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		return persons.get(personId);
	}
	
	@Override
	public List<Person> getAll(){
		return new ArrayList<Person>(persons.values());	
	}

	@Override
	public void add(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if (persons.containsKey(person.getUserid())) {
			throw new IllegalArgumentException("User already exists");
		}
		persons.put(person.getUserid(), person);
	}
	
	@Override
	public void update(Person person){
		if(person == null){
			throw new IllegalArgumentException("No person given");
		}
		if(!persons.containsKey(person.getUserid())){
			throw new IllegalArgumentException("No person found");
		}
		persons.put(person.getUserid(), person);
	}
	
	@Override
	public void delete(String personId){
		if(personId == null){
			throw new IllegalArgumentException("No id given");
		}
		persons.remove(personId);
	}

	@Override
	public Person getIfAuthenticated(String personId, String password)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exists(String id)
	{
		// TODO Auto-generated method stub
		return false;
	}
}
