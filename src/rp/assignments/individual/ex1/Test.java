package rp.assignments.individual.ex1;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import lejos.robotics.navigation.Pose;
import rp.robotics.simulation.MapBasedSimulation;
import rp.robotics.simulation.SimulatedRobots;
import rp.robotics.simulation.example.MyRobotController;
import rp.robotics.testing.TestMaps;
import rp.robotics.testing.TestViewer;
import rp.robotics.testing.ZoneSequence;
import rp.robotics.testing.ZoneSequenceTest;
import rp.robotics.*;
import rp.assignments.individual.ex1.Ex1Tests;

import org.junit.runner.*;
import org.junit.*;

public class Test {

	public static void main(String[] args){
		 Result result = JUnitCore
	                .runClasses(rp.assignments.individual.ex1.Ex1Tests.class);

	        System.out.println(String.format("%d/%d tests successful",
	                result.getRunCount() - result.getFailureCount(),
	                result.getRunCount()));
	        for (Failure failure : result.getFailures()) {
	            System.out.println(failure.toString());
	        }
	}
}
