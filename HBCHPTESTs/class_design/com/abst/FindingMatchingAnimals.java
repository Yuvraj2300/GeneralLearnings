package com.abst;

public class FindingMatchingAnimals {
	public static void print(Animal animal, CheckTrait trait) {
		if (!trait.test(animal)) {
			System.out.println(animal);
		}
	}

	public static void main(String[] args) {
		print(new Animal("Fish", false, true), a -> a.canHop());
	}
}
