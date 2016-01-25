package rp.assignments.individual.ex1;

import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

public class PolygonControllerFactory implements StoppableRunnable {
	private static DifferentialDriveRobot robot;
	private static float sideLength;
	private boolean m_running = false;
	private static int noOfSides;
	private static PolygonControllerFactory demo;
	
	
	
	public static StoppableRunnable createPolygonController(DifferentialDriveRobot _robot, int _noOfSides, float _sideLength) {
		robot = _robot;
		sideLength = _sideLength;
		noOfSides = _noOfSides;
		demo = new PolygonControllerFactory();
		return demo;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.m_running = true;
		for (int i = 0; i <= noOfSides-1; i++) {
			robot.getDifferentialPilot().travel(sideLength);
			robot.getDifferentialPilot().rotate((((noOfSides-2)*180)/noOfSides)+0.75);
		}

		this.m_running = false;

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
