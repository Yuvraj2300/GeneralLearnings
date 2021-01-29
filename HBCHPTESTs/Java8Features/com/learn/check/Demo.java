package com.learn.check;

import java.util.HashMap;
import java.util.function.Predicate;

public class Demo {
	static public HashMap<Employee, Desk> hm = new HashMap<>();

	public static void main(String[] args) {
		hm.put(new Employee("Yuvraj", 1L), new Desk(1L));
		hm.put(new Employee("John", 2L), new Desk(2L));
		hm.put(new Employee("Joe", 3L), new Desk(3L));
		hm.put(new Employee("Tim", 4L), new Desk(1L));
		hm.put(new Employee("Brian", 5L), new Desk(5L));

		searchOnValue(new Desk(1L));
		searchOnKeyValue(new Employee("Tim", 4L), new Desk(1L));
	}

	static void searchOnValue(Desk desk) {
		hm.entrySet().forEach(e -> {
			if (e.getValue().equals(desk)) {
				System.out.println(e.getKey());
			}
		});
	}

	static void searchOnKeyValue(Employee emp, Desk desk) {
		hm.entrySet().forEach(e -> {
			if (e.getValue().equals(desk)) {
				if (e.getKey().equals(emp)) {
					System.out.println(e.getKey() + " is assigned to : - " + e.getValue());
				}
			}
		});

	}
}

class Desk {
	private Long id;

	@Override
	public String toString() {
		return "Desk [id=" + id + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Desk(Long id) {
		super();
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Desk other = (Desk) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

class Employee {
	private String name;
	private Long id;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

	public Employee(String name, Long id) {
		super();
		this.name = name;
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}