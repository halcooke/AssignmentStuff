package rp.assignments.individual.ex1;

import lejos.robotics.RangeFinder;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.TouchSensorEvent;
import rp.systems.ControllerWithTouchSensor;
import rp.systems.StoppableRunnable;

public class createBumperController implements StoppableRunnable, ControllerWithTouchSensor {

	private final DifferentialDriveRobot robot;
	private boolean m_running = false;
	private final DifferentialPilot pilot;
	private boolean m_bumped = false;
	private RangeFinder m_ranger;

	public createBumperController(DifferentialDriveRobot robot) {
		this.robot = robot;
		this.pilot = robot.getDifferentialPilot();
	}

	@Override
	public void stop() {
		m_running = false;
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		m_running = true;

		while (m_running) {

			while (m_running && !m_bumped) {
				pilot.travel(10f, true);
				Delay.msDelay(1);
			}
			if (m_bumped) {
				pilot.stop();
				pilot.travel(-0.05);
				pilot.rotate(180.3);
				m_bumped = false;
			}

		}
		// TODO Auto-generated method stub

	}

	@Override
	public void sensorPressed(TouchSensorEvent _e) {
		// TODO Auto-generated method stub
		m_bumped = true;
	}

	@Override
	public void sensorReleased(TouchSensorEvent _e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void sensorBumped(TouchSensorEvent _e) {
		// TODO Auto-generated method stub

	}

}
