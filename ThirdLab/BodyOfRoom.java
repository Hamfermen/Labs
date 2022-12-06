package com.ThirdLab.Classes;

import java.util.ArrayList;
import java.util.List;

public class BodyOfRoom {

	private List<Object> container;
		
	public BodyOfRoom() {
		container = new ArrayList<Object>();
	}
	
	public BodyOfRoom(List<Object> obj) {
		container = new ArrayList<Object>();
		container.addAll(obj);
	}
	
	public void addNewObjects(List<Object> obj) {
		container.addAll(obj);
	}
	
	public void removeObjectsByNumber(List<Integer> ind) {
		for (int el : ind) {
			if (el < container.size()) container.remove(el);
		}
	}

	public List<Object> getObjects(){
		List<Object> deepCopy = new ArrayList<>(container);
		return deepCopy;
	}
}
