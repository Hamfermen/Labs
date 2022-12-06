package com.ThirdLab.Classes;

import java.util.*;

public final class Room {

	public static final class RoomConsts {
		private RoomConsts() {
		}

		public static final double JPS = 10000000;
		public static final int DELAY = 5000;
		public static final int COUNT_OF_HOURS_IN_ONE_ITERATION = 1;
		public static final int COUNT_OF_HOURS_IN_DAY = 24;
		public static final int COUNT_OF_DAY_IN_MOUNTHS = 28;
		public static final String[] mounths = { "Янраль", "Марель", "Июнль", "Сентобрь" };
		public static final String[] seasons = { "Зима", "Весна", "Лето", "Осень" };
	}

	public class VoidSubstanceException extends Exception {
		@Override
		public String toString() {
			return "Произошла ошибка и в комнате появилась абсоютная пустота";
		}
	}

	public class TwoRoomExeption extends Exception {
		@Override
		public String toString() {
			return "Невозможно создать более одной комнаты";
		}
	}

	public class RoomColaps extends RuntimeException {
		public RoomColaps(Throwable th) {
			super("Конец света наступил", th);
		}
	}

	public class TimerExeption extends Exception {
		public TimerExeption() {
			super("Невозможно переключится на 2000 год");
		}
	}

	private final class RoomTimer {

		private int hour;
		private int day;
		private int mounthNow;
		private int seasonNow;
		private int year;
		private TemperatureCondition state;

		private RoomTimer(int hour, int day, int mounthNow, int year) {
			this.hour = hour;
			this.day = day;
			this.mounthNow = mounthNow;
			seasonNow = mounthNow;
			this.year = year;
			state = seasonNow == 2 ? TemperatureCondition.WARM : TemperatureCondition.COLD;
		}

		private void timeUpdater() throws TimerExeption {
			boolean check = year < 2000;
			year += (((hour + RoomConsts.COUNT_OF_HOURS_IN_ONE_ITERATION) / RoomConsts.COUNT_OF_HOURS_IN_DAY + day)
					/ RoomConsts.COUNT_OF_DAY_IN_MOUNTHS + mounthNow) / 4;
			mounthNow = (((hour + RoomConsts.COUNT_OF_HOURS_IN_ONE_ITERATION) / RoomConsts.COUNT_OF_HOURS_IN_DAY + day)
					/ RoomConsts.COUNT_OF_DAY_IN_MOUNTHS + mounthNow) % 4;
			day = ((hour + RoomConsts.COUNT_OF_HOURS_IN_ONE_ITERATION) / RoomConsts.COUNT_OF_HOURS_IN_DAY + day)
					% RoomConsts.COUNT_OF_DAY_IN_MOUNTHS;
			hour = (hour + RoomConsts.COUNT_OF_HOURS_IN_ONE_ITERATION) % RoomConsts.COUNT_OF_HOURS_IN_DAY;
			if (year == 2000 && check)
				throw new TimerExeption();
			state = seasonNow == 2 ? TemperatureCondition.WARM : TemperatureCondition.COLD;
		}

		public String getTime() {
			return "Время: " + Integer.toString(hour) + ":00:00 День: " + Integer.toString(day) + " Месяц: "
					+ RoomConsts.mounths[mounthNow] + " Сезон года: " + RoomConsts.seasons[seasonNow] + " Год: "
					+ Integer.toString(year);
		}
		public TemperatureCondition getTemperatureState() {
			return state;
		}

	}

	private BodyOfRoom floor;
	private BodyOfRoom wall_1;
	private BodyOfRoom wall_2;
	private BodyOfRoom wall_3;
	private BodyOfRoom wall_4;
	private BodyOfRoom ceiling;

	private static int countOfRooms = 0;

	private Karlson karlson;
	private Malish malish;

	private RoomTimer roomTimer;

	private Workbench workbench;
	private Fireplace fireplace;
	private KeroseneLamp keroseneLamp;

	private List<Food> foodList;

	public Room() throws TwoRoomExeption {
		this(23, 27, 3, 1999);
	}

	public Room(int hour, int day, int mounthNow, int year) throws TwoRoomExeption {
		try {
			countOfRooms++;
			if (countOfRooms > 1) throw new TwoRoomExeption();
		}catch(TwoRoomExeption e) {
			throw new RoomColaps(e);
		}
		fireplace = new Fireplace("Rock", 0.8, 8);
		keroseneLamp = new KeroseneLamp("Silver", 0.1);
		createFood();
    	generateRoom();
    	roomTimer = new RoomTimer(hour, day, mounthNow, year);
    	karlson = Karlson.getKarlson();
    	malish = Malish.getMalish();
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
		foodList.add(new Food("печеные", "яблоки", "съел все"));
	}

	private void startSimulate() throws InterruptedException {
		Thread simulate = new Thread(new Runnable() {
			public void run() {
				roomUpdater();
				try {
					Thread.sleep(RoomConsts.DELAY);
					tryCreateVoid();
					roomTimer.timeUpdater();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				} catch (TimerExeption | VoidSubstanceException e) {
					throw new RoomColaps(e);
				}
			}
		});
		
		while (true) {
			simulate.run();
		}
	}

	public void roomUpdater() {
		System.out.println(roomTimer.getTime());
		karlson.exist(this);
		malish.exist(this);
		fireplace.dynamicExist();
		keroseneLamp.dynamicExist();
		System.out.println(
				(LightCondition.LIGHT == fireplace.getLightState() || LightCondition.LIGHT == keroseneLamp.getLightState())
						? "В комнате светло"
						: "В комнате темно");
		System.out.println(
				(TemperatureCondition.WARM == fireplace.getTemperatureState() || TemperatureCondition.WARM == keroseneLamp.getTemperatureState() || TemperatureCondition.WARM == roomTimer.getTemperatureState())
						? "В комнате тепло"
						: "В комнате холодно");
		System.out.println("----------------------------------");
	}

	private void tryCreateVoid() throws VoidSubstanceException {
		if (Math.random() >= 0.9)
			throw new VoidSubstanceException();
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