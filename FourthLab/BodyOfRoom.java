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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((container == null) ? 0 : container.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		BodyOfRoom other = (BodyOfRoom) obj;
		if (container == null) {
			if (other.container != null) {
				return false;
			}
		} else if (!container.equals(other.container)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "BodyOfRoom [container=" + container.toString() + "]";
	}
	
	
}
