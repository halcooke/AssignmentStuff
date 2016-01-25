package rp.assignments.individual.ex1;

import rp.robotics.DifferentialDriveRobot;
import rp.systems.ControllerWithTouchSensor;
import rp.systems.StoppableRunnable;

public class SolutionFactory {
	
	public static StoppableRunnable createEquilateralTriangleController(DifferentialDriveRobot _robot, Float _sideLength) {
		 
		return  new TriangleController(_robot, _sideLength);

	}

	public static StoppableRunnable createSquareController(DifferentialDriveRobot _robot, Float _sideLength) {

		return new SquareController(_robot, _sideLength);

	}

	public static StoppableRunnable createDecagonController(DifferentialDriveRobot _robot, Float _sideLength) {

		return new DecagonController(_robot, _sideLength);

	}
	
	public static ControllerWithTouchSensor createBumperController(DifferentialDriveRobot _robot){
		return new createBumperController(_robot);
	}
	
}
