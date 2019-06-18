package com.ocp.abst;

public abstract class Animal {
	public abstract void feed();
}

class Cow extends Animal {
	public void feed() {
		addHay();
	}

	protected void addHay() {
	}
}

class Bird extends Animal {
	public void feed() {
		addSeed();
	}

	protected void addSeed() {
	}
}