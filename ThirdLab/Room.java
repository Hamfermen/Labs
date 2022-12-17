package com.ThirdLab.Classes;

import java.util.*;

public final class Room {

	public static final class RoomConsts {
		private RoomConsts() {
		}

		public static final double JPS = 10000000;
		public static final int DELAY = 5000;
	}

	private BodyOfRoom floor;
	private BodyOfRoom wall_1;
	private BodyOfRoom wall_2;
	private BodyOfRoom wall_3;
	private BodyOfRoom wall_4;
	private BodyOfRoom ceiling;

	private Karlson karlson;

	private Workbench workbench;
	private Fireplace fireplace;
	private KeroseneLamp keroseneLamp;

	private List<Food> foodList;

	public Room() {
	fireplace = new Fireplace("Rock", 0.8, 8);
	keroseneLamp = new KeroseneLamp("Silver", 0.1);
	createFood();
    	generateRoom();
    	karlson = Karlson.getKarlson();
    	try {
			startSimulate();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }

	public void generateRoom() {
		generateWalls();
		generateFloor();
		generateCeiling();
	}

	private void generateWalls() {
		List<Object> local = new ArrayList<>();
		local.add(new Door("Gold", 4, 3));
		wall_1 = new BodyOfRoom(new ArrayList<Object>(local));
		local.clear();
		local.add(new Window("Glass", 3, 3));
		wall_2 = new BodyOfRoom(new ArrayList<Object>(local));
		local.clear();
		local.add(fireplace);
		wall_3 = new BodyOfRoom(new ArrayList<Object>(local));
		local.clear();
		wall_4 = new BodyOfRoom();
	}

	private void generateFloor() {
		List<Object> local = new ArrayList<>();
		local.add(new Workbench());
		floor = new BodyOfRoom(new ArrayList<Object>(local));
		local.clear();
	}

	private void generateCeiling() {
		List<Object> local = new ArrayList<>();
		local.add(keroseneLamp);
		ceiling = new BodyOfRoom(new ArrayList<Object>(local));
		local.clear();
	}

	private void createFood() {
		foodList = new ArrayList<>();
		foodList.add(new Food("сладкое", "варенье", "выпил всё"));
	}

	private void startSimulate() throws InterruptedException {
		Thread simulate = new Thread(new Runnable() {
			public void run() {
				roomUpdater();
				try {
					Thread.sleep(RoomConsts.DELAY);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		while (true) {
			simulate.run();
		}
	}

	public void roomUpdater() {
		karlson.exist(this);
		fireplace.dynamicExist();
		keroseneLamp.dynamicExist();
		System.out.println(
				(LightCondition.LIGHT == fireplace.getLightState() || LightCondition.LIGHT == keroseneLamp.getLightState())
						? "В комнате светло"
						: "В комнате темно");
		System.out.println("----------------------------------");
	}

	public BodyOfRoom getWall_1() {
		return wall_1;
	}

	public BodyOfRoom getWall_2() {
		return wall_2;
	}

	public BodyOfRoom getWall_3() {
		return wall_3;
	}

	public BodyOfRoom getWall_4() {
		return wall_4;
	}

	public BodyOfRoom getFloor() {
		return floor;
	}

	public BodyOfRoom getCeiling() {
		return ceiling;
	}

	public List<Food> getFoodList() {
		List<Food> deepCopy = new ArrayList<>(foodList);
		return deepCopy;
	}

	public Fireplace getFireplace() {
		return fireplace;
	}

	public KeroseneLamp getKeroseneLamp() {
		return keroseneLamp;
	}
}
