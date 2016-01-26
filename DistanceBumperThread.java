package rp.assignments.individual.ex1;

import rp.robotics.TouchSensorEvent;
import rp.robotics.TouchSensorListener;
import rp.systems.StoppableRunnable;
import lejos.robotics.RangeFinder;
import lejos.util.Delay;

public class DistanceBumperThread extends Thread implements TouchSensorListener {

	private final RangeFinder ranger;
	private float touchRange;
	private float currentRange;
	private boolean bumped;

	public DistanceBumperThread(RangeFinder ranger, float touchRange) {
		this.ranger = ranger;
		this.touchRange = touchRange;
	}

	@Override
	public void run() {
		bumped = false;
		while (true) {
			
			float a = ranger.getRange();
			Delay.msDelay(20);
			float b = ranger.getRange();
			if (b <= touchRange) {
				TouchSensorEvent e = new TouchSensorEvent(a, b);
				sensorBumped(e);
				bumped = true;
			}
			while (bumped == true) {
				float c = ranger.getRange();
				if (c >= touchRange) {
					TouchSensorEvent d = new TouchSensorEvent(b, c);
					sensorReleased(d);
					bumped = false;
				}
			}
			Delay.msDelay(50);
		}
	}
	// TODO Auto-generated method stub

	public float getRange() {
		return ranger.getRange();
	}

	@Override
	public void sensorPressed(TouchSensorEvent _e) {
		// TODO Auto-generated method stub

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
