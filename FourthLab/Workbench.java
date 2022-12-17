package com.ThirdLab.Classes;

import java.util.*;

public class Workbench {

private List<Object> container;
	
	public Workbench() {
		container = new ArrayList<Object>();
	}
	
	public Workbench(List<Object> obj) {
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

}