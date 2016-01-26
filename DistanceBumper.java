package rp.assignments.individual.ex1;

import lejos.nxt.TouchSensor;
import lejos.robotics.RangeFinder;
import lejos.robotics.Touch;
import lejos.robotics.navigation.DifferentialPilot;
import rp.config.RangeFinderDescription;
import rp.robotics.DifferentialDriveRobot;
import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorEventSource;
import rp.robotics.TouchSensorListener;

public class DistanceBumper implements TouchSensorEventSource, Touch{

	private final RangeFinderDescription desc;
	private RangeFinder ranger;
	private float touchRange;
	
	
	public DistanceBumper(RangeFinderDescription desc, RangeFinder ranger, float touchRange){
		this.desc = desc;
		this.ranger = ranger;
		this.touchRange = touchRange;
		DistanceBumperThread a = new DistanceBumperThread(ranger, touchRange);
		a.start();
	}

	
	

	@Override
	public void addTouchSensorListener(TouchSensorListener _listener) {
		// TODO Auto-generated method stub
		_listener.sensorBumped(_e);
		;
		
	}



	@Override
	public boolean isPressed() {
		if(ranger.getRange() <= touchRange){
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}

}
