package org.usfirst.frc2992.Robot.subsystems;

import org.usfirst.frc2992.Robot.*;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.AnalogGyro;

public class DrivePID implements PIDOutput {

	private SpeedController[] mDrive;
	private AnalogGyro mGyro;

	public DrivePID (SpeedController[] motors, AnalogGyro gyro) {
		mDrive = motors;
		mGyro = gyro;
	}
	
	@Override
	public void pidWrite(double output) {
		
		//get gyro angle
		// double gyroCorrection = mGyro.getAngle();
		
		// Ignore gyro correction for now
		for (SpeedController m : mDrive) {
			m.set(output);
		}

	}

}
