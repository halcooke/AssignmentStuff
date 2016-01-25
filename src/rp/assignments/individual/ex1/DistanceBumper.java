package rp.assignments.individual.ex1;

import rp.robotics.TouchSensorEventSource;
import rp.robotics.TouchSensorListener;
import lejos.robotics.Touch;
public class DistanceBumper implements TouchSensorEventSource, Touch {

	@Override
	public void addTouchSensorListener(TouchSensorListener _listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPressed() {
		// TODO Auto-generated method stub
		return false;
	}

}
