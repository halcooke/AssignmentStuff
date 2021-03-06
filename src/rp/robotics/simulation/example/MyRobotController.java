package rp.robotics.simulation.example;

import lejos.robotics.RangeFinder;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.TouchSensorEvent;
import rp.systems.ControllerWithTouchSensor;
import rp.systems.StoppableRunnable;
import rp.util.Rate;

/**
 * 
 * Very empty example controller structure.
 * 
 * @author Nick Hawes
 *
 */
public class MyRobotController implements StoppableRunnable, ControllerWithTouchSensor {
	
	private final DifferentialDriveRobot robot;
	private boolean m_running = false;
	private final DifferentialPilot pilot;
	private boolean m_bumped = false;
	private RangeFinder m_ranger;
	public MyRobotController(DifferentialDriveRobot robot) {
this.robot = robot;
this.pilot = robot.getDifferentialPilot();
	}

	@Override
	public void run() {
		m_running = true;
		double sideLength = 1;
		int noOfSides = 3;
		/*
		for (int i = 0; i <= 9; i++) {
			robot.getDifferentialPilot().travel(sideLength);
			robot.getDifferentialPilot().rotate(36.75);
		}
		*/

			
		/*
		for (int i = 0; i <= noOfSides-1; i++) {
			robot.getDifferentialPilot().travel(sideLength);
			robot.getDifferentialPilot().rotate((180 - (((noOfSides-2)*180)/noOfSides))+0.75);
		}
		*/
		
		while (m_running) {
			
			while(m_running && !m_bumped){
				pilot.forward();
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
	public void stop() {
		// TODO Auto-generated method stub
		m_running = false;
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
		m_bumped = true;
	}

}
