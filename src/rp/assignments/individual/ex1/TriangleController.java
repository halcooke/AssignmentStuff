package rp.assignments.individual.ex1;

import rp.robotics.DifferentialDriveRobot;
import rp.systems.StoppableRunnable;

public class TriangleController implements StoppableRunnable {

	private final DifferentialDriveRobot robot;
	private float sideLength;
	private boolean m_running = false;

	public TriangleController(DifferentialDriveRobot robot, float sideLength) {
		this.robot = robot;
		this.sideLength = sideLength;
	}

	@Override
	public void run() {
		m_running = true;
		for (int i = 0; i <= 2; i++) {
			robot.getDifferentialPilot().travel(sideLength);
			robot.getDifferentialPilot().rotate(121);
		}
		m_running = false;
		// TODO Auto-generated method stub

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		m_running = false;

	}

}
