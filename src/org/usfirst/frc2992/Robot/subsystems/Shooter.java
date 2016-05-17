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

import org.usfirst.frc2992.Robot.Constants;
import org.usfirst.frc2992.Robot.Robot;
import org.usfirst.frc2992.Robot.RobotMap;
import org.usfirst.frc2992.Robot.commands.*;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class Shooter extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController shooterwheel = RobotMap.shooterShooterwheel;
    private final Encoder shootEnc = RobotMap.shootEncoder;
    
    PIDController shootPID;
    
    private double shootspeed;
    private double speedIs;
    
    final double reversespeed = Constants.shootReverseSpeed;
    
    final double kP = Constants.shooterP;
    final double kI = Constants.shooterI;
    final double kD = Constants.shooterD;
    final double kF = Constants.shooterF;
    
    public final double powerMax = Constants.shooterPowerMax;
	public final double rpmMax = Constants.shooterRpmMaxSpeed;
    
    public boolean shootOn = false;
    
    private Timer time;
    private double maxTime = Constants.maxShootTime;
    
    private Joystick buttonbox;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public Shooter(){
    	super();
    	
    	shootPID = new PIDController(kP, kI, kD, kF, shootEnc, shooterwheel);
    	shootPID.setOutputRange(-powerMax, powerMax);
		shootPID.setInputRange(-rpmMax, rpmMax);
		shootPID.setPercentTolerance(1.0);
		
		time = new Timer();
    }
    
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        setDefaultCommand(new ShootOff());
    }
    
    public boolean ShootOn(){
    	return shootOn;
    }
    
    public void shootPID(){
    	buttonbox  = Robot.oi.getSwitchbox();
    	if (buttonbox.getRawButton(10) == true){
    		reverse();
    		return;
    	} else if (buttonbox.getRawButton(11) == true) {
    		shootspeed = -4200;//rpm
    	} else {
    		shootspeed = -3500;//rpm
    	}
    	//shootspeed = (buttonbox.getX() * 8.468); //scales x axis to motor powers: 8.468 scale = [0,1]
    	
    	shootPID.setSetpoint(shootspeed);
    	speedIs = shootspeed;
		
		if (!shootPID.isEnable()){
		shootPID.enable();
		}
		
		shootReady();
		
    	if(shootEnc.getRate() >= speedIs - 100 && shootEnc.getRate() <= speedIs + 100){
    		buttonbox.setOutput(6, true);
    	} else {
    		buttonbox.setOutput(6, false);
    	}
    	SmartDashboard.putNumber("shooter wheel", shootEnc.getRate());
    	
    }
    public void shootHigh(){
    	buttonbox  = Robot.oi.getSwitchbox();
    	
    	//shootspeed = (buttonbox.getX() * 8.468); //scales x axis to motor powers: 8.468 scale = [0,1]
    	shootspeed = -.25;
    	shootPID.disable();
    	
    	shooterwheel.set(shootspeed);
    	//SmartDashboard.putNumber("shooter raw", buttonbox.getX());
    	SmartDashboard.putNumber("Shoot Speed", shootspeed);
    	
    	shootOn = true;
    	buttonbox.setOutput(6, true);
    }
    
    public void reverse(){
    	buttonbox  = Robot.oi.getSwitchbox();
    	
    	buttonbox.setOutput(6, false);
    	
    	shootPID.disable();
    	shooterwheel.set(reversespeed);
    	shootOn = true;
    	SmartDashboard.putNumber("shooter wheel", shootEnc.getRate());
    }
    
    public void stop(){
    	buttonbox  = Robot.oi.getSwitchbox();
    	
    	buttonbox.setOutput(6, false);
    	
    	shootPID.disable();
    	shooterwheel.set(0);
    	shootOn = false;
    	SmartDashboard.putNumber("shooter wheel", shootEnc.getRate());
    }
    
    public void shootReady(){
    	time.start();
    	
    	if (Math.abs(speedIs) <= 100){
    		shootOn = false;
    	} else if (buttonbox.getRawButton(12) == true){
    		shootOn = true;
    	} else if(time.get() >= maxTime){
    		time.reset();
    		time.stop();
    		shootOn = false;
    	} else{
    		return;
    	}
    }
}

