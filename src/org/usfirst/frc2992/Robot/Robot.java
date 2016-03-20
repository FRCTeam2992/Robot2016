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

import edu.wpi.first.wpilibj.CameraServer;
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
    public static Gear gear;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static String autoName;
    public static int autoCommandNum;
    
 // Vision constants
    public static final boolean SimpleVision = true;
    CameraServer server;
    public static final String frontCamName = "cam0";
    public static final int imgQual = 30;
    // Constants for 2 camera vision mode (only used if SimpleVision is false)
    public static final int btFrontCam = 5;
    public static final int btRearCam = 6;
    public static final String rearCamName = "cam1";
    CameraFeeds cameraFeeds;

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
		gear = new Gear();
    
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
        
        // Vision
        if (SimpleVision) {
        	// Single camera mode
        	server = CameraServer.getInstance();
            server.setQuality(imgQual);//not working
            //the camera name (ex "cam0") can be found through the roborio web interface
            server.startAutomaticCapture(frontCamName);
        } else {
        	// Multiple camera mode
        	cameraFeeds = new CameraFeeds();
        }
    }
	
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	mhRobotDrive.allStop();
    	/*if (SimpleVision == false) {
           	// Multi camera mode so stop video
           	cameraFeeds.end();
           }
           */
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
        SmartDashboard.putNumber("Left Encoder", RobotMap.lEncoder.getDistance());
        SmartDashboard.putNumber("Right Encoder",  RobotMap.rEncoder.getDistance());

    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        /*
        if (SimpleVision == false) {
        	// Multi camera mode so force to front camera
        	cameraFeeds.init();
        }
        */
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
        SmartDashboard.putNumber("Left Encoder", RobotMap.lEncoder.getDistance());
        SmartDashboard.putNumber("Right Encoder",  RobotMap.rEncoder.getDistance());
        SmartDashboard.putNumber("Shooter speed", RobotMap.shootEncoder.getRate());
        SmartDashboard.putNumber("Shooter Current", RobotMap.power.getCurrent(12));
        /*
        if (SimpleVision == false) {
        	// Multi camera mode so process video
        	cameraFeeds.run();
        }
        */
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
    	if (Robot.oi.autoA.get()) {
    		automode += 1;
    	}
    	if (Robot.oi.autoB.get()) {
    		automode += 2;
    	}
    	if (Robot.oi.autoC.get()) {
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
    		case 4: autonomousCommand = new AutoPort();
    				autoName = "Move through Portcullis";
    				break;
    		case 5:	autonomousCommand = new AutoISurrender();
    				autoName = "Move through CDF";
    				break;
    		default: autonomousCommand = new AutoNothing();
    				autoName = "Default Do Nothing";
    				break;
    	}	
    }
}
