package rp.assignments.individual.ex1;

import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

public class DecagonController implements StoppableRunnable {
	private DifferentialDriveRobot robot;
	private float sideLength;
	private boolean m_running = false;

	public DecagonController(DifferentialDriveRobot robot, Float sideLength) {
		this.robot = robot;
		this.sideLength = sideLength;
	}

	@Override
	public void run() {
		this.m_running = true;
		for (int i = 0; i <= 9; i++) {
			robot.getDifferentialPilot().travel(sideLength);
			robot.getDifferentialPilot().rotate(36.75);
		}

		this.m_running = false;
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

}
