// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2992.Robot.subsystems;

import org.usfirst.frc2992.Robot.Robot;
import org.usfirst.frc2992.Robot.RobotMap;
import org.usfirst.frc2992.Robot.commands.*;
import org.usfirst.frc2992.Robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class ShootPosition extends Subsystem {

	private final DigitalInput SL = RobotMap.ShootReadyLeft;
	private final DigitalInput SR = RobotMap.ShootReadyRight;

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public boolean ShootReadyLeft(){
		return SL.get();
	}
	
	public boolean ShootReadyRight(){
		return SR.get();
	}

    public void initDefaultCommand() {

        // Set the default command for a subsystem here.
        setDefaultCommand(new ShootReady());
    }
}
