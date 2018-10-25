package com.learn.remoting;

import java.util.List;

import com.learn.remoting.entities.Singer;

public class Singers {
	private List<Singer> singers;

	public Singers() {
	}

	public Singers(List<Singer> singers) {
		this.singers = singers;
	}

	public List<Singer> getSingers() {
		return singers;
	}

	public void setSingers(List<Singer> singers) {
		this.singers = singers;
	}

}
