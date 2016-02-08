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

import org.usfirst.frc2992.Robot.RobotMap;
import org.usfirst.frc2992.Robot.mhRobotDrive;
import org.usfirst.frc2992.Robot.commands.*;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 *
 */
public class DriveTrain extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    private final Solenoid driveshifthighlow = RobotMap.driveTrainDriveshifthighlow;
    private final mhRobotDrive mhRobotDrive = RobotMap.mhRobotDrive;
    private final AnalogGyro Gyro = RobotMap.driveTrainGyro;
    
    private final Encoder LeftEnc = RobotMap.LEncoder;
    private final Encoder RightEnc = RobotMap.REncoder;
	
    DrivePID distance;
    PIDController DistPID;
    final double Dkp = 0.0;
    final double Dki = 0.0;
    final double Dkd = 0.0;
    
    RotatePID turn;
    PIDController TurnPID;
    final double Rkp = 0.0;
    final double Rki = 0.0;
    final double Rkd = 0.0;
    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveSticks());
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    public void tankDrive(double leftY, double rightY, boolean HighGear){
    			
    	
    	mhRobotDrive.tankDrive(leftY, rightY, HighGear);
    	
    }
    
    /*
     * in progress PID control
     */
	public void smartDrive(double Distance, double Degrees){
    	
    	distance = new DrivePID(mhRobotDrive, Gyro);
    	DistPID = new PIDController(Dkp, Dki, Dkd, LeftEnc, distance);
    	DistPID.setOutputRange(-0.3, 0.3);
    	DistPID.setInputRange(-40.0, 40.0);
    	DistPID.setPercentTolerance(1.0);
    	DistPID.disable();
    	
    	turn = new RotatePID(mhRobotDrive);
    	TurnPID = new PIDController(Rkp, Rki, Rkd, Gyro, turn);
    	TurnPID.setOutputRange(-1.5, 1.5);
    	TurnPID.setInputRange(-360.0, 360.0);
    	TurnPID.setPercentTolerance(1.0);
    	TurnPID.disable();
    	
    	
    	if(Math.abs(Distance) > 0 && Degrees == 0){
    		DistPID.enable();
    		TurnPID.disable();
    		DistPID.setSetpoint(Distance);
    		
    	} else if(Math.abs(Degrees) > 0 && Distance == 0){
    		DistPID.disable();
    		TurnPID.enable();
    		TurnPID.setSetpoint(Degrees);
    		
    	}else if(Math.abs(Degrees) > 0 && Math.abs(Distance) > 0){
    		DistPID.enable();
    		TurnPID.enable();
    		DistPID.setSetpoint(Distance);
    		TurnPID.setSetpoint(Degrees);
    	}else{
    		DistPID.disable();
    		TurnPID.disable();
    		allStop();
    	}
    }
    
    
    
    /*
     * stop all motors
     */
    public void allStop(){
    	mhRobotDrive.tankDrive(0, 0, false);
    }
}

