// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2992.Robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc2992.Robot.commands.*;
import org.usfirst.frc2992.Robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain mhRobotDrive;
    public static DuckTail tail;
    public static Shooter shooter;
    public static ShootPosition shootReady;
    public static FeedInternal intFeed;
    public static FeedExternal extFeed;
    public static Hood hood;
    public static PhotonCannon photon;
    public static Arm arm;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static String autoName;
    public static int autoCommandNum;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	//create 1 copy of the subsystems
		mhRobotDrive = new DriveTrain();
		tail = new DuckTail();
		shooter = new Shooter();
		shootReady = new ShootPosition();
		intFeed = new FeedInternal();
		extFeed = new FeedExternal();
		hood = new Hood();
		photon = new PhotonCannon();
		arm = new Arm();
    
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        
		oi = new OI();
		
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new AutoNothing();
        autoName = "Stand Still";
        autoCommandNum = 0;

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
        
        SmartDashboard.putData(mhRobotDrive);
        SmartDashboard.putData(tail);
        SmartDashboard.putData(shooter);
        SmartDashboard.putData(shootReady);
        SmartDashboard.putData(arm);
        SmartDashboard.putData(intFeed);
        SmartDashboard.putData(extFeed);
        SmartDashboard.putData(photon);
        SmartDashboard.putData(hood);
        
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	mhRobotDrive.allStop();

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
        setAutoMode();
        SmartDashboard.putNumber("Auto Command Number", autoCommandNum);
        SmartDashboard.putString("Auto Command Name", autoName);
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
       // SmartDashboard.putBoolean("Solenoid A", RobotMap.feedLA.get());
       // SmartDashboard.putBoolean("Solenoid B", RobotMap.feedLB.get());
       // SmartDashboard.putBoolean("Ducktail Up Sw", oi.duckTailUp.get());
       // SmartDashboard.putBoolean("Ducktail Down", oi.duckTailDown.get());
        SmartDashboard.putBoolean("Feed Limit Switch", RobotMap.feedLimit.get());
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    
    
    public void setAutoMode () {
    	// Read the switch autonomous switches & set auto mode
    	int automode = 0;
    	if (Robot.oi.auto1.get()) {
    		automode += 1;
    	}
    	if (Robot.oi.auto2.get()) {
    		automode += 2;
    	}
    	if (Robot.oi.auto3.get()) {
    		automode += 4;
    	}
    	
    	autoCommandNum = automode;
    	
    	switch (automode) {
    		case 0:	autonomousCommand = new AutoNothing();
    				autoName = "Stand Still";
    				break;
    		case 1: autonomousCommand = new AutoForward();
    				autoName = "Move Forward";
    				break;
    		case 2: autonomousCommand = new AutoBD();
					autoName = "Move over BD";
					break;
    		case 3: autonomousCommand = new AutoLowBar();
					autoName = "Move through Low Bar";
					break;
    		case 4: autonomousCommand = new AutoLowAndShoot();
    				autoName = "Move through Low Bar, Shoot";
    				break;
    		case 5:	autonomousCommand = new AutoLowShootBack();
    				autoName = "Move through Low Bar, Shoot, Back";
    				break;
    		default: autonomousCommand = new AutoNothing();
    				autoName = "Default Do Nothing";
    				break;
    	}	
    }
}
