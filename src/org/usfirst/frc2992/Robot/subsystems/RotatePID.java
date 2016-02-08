package org.usfirst.frc2992.Robot.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import org.usfirst.frc2992.Robot.*;

public class RotatePID implements PIDOutput {

	mhRobotDrive mDrive; // Chassis to rotate
	
	public RotatePID (mhRobotDrive drive) {
		mDrive = drive;
	}
	
	@Override
	public void pidWrite(double output) {
		
		mDrive.tankDrive(-output, output, false);
	}

}