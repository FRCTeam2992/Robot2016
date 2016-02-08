package org.usfirst.frc2992.Robot.subsystems;

import org.usfirst.frc2992.Robot.*;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.AnalogGyro;

public class DrivePID implements PIDOutput {

	private mhRobotDrive mDrive;
	private AnalogGyro mGyro;

	public DrivePID (mhRobotDrive drive, AnalogGyro gyro) {
		mDrive = drive;
		mGyro = gyro;
	}
	
	@Override
	public void pidWrite(double output) {
		
		//get gyro angle
		double gyroCorrection = mGyro.getAngle();
		
		mDrive.tankDrive(output, -gyroCorrection/360, false);
	}

}
