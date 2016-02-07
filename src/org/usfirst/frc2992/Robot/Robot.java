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

import org.usfirst.frc2992.Robot.Robot;
import org.usfirst.frc2992.Robot.commands.AutoBD;
import org.usfirst.frc2992.Robot.commands.AutoLowAndShoot;
import org.usfirst.frc2992.Robot.commands.AutoLowBar;
import org.usfirst.frc2992.Robot.commands.AutoLowShootBack;
import org.usfirst.frc2992.Robot.commands.AutoNothing;
import org.usfirst.frc2992.Robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	// Which auto command to run
    public static Command autonomousCommand;
    public static String autoCommandName;
    public static int autoCommandNum;

    public static OI oi;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static DriveTrain mhRobotDrive;
    public static Feed feed;
    public static Shooter shooter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    boolean enckill = false;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	//create 1 copy of the subsystems
		mhRobotDrive = new DriveTrain();
		feed = new Feed();
		shooter = new Shooter();
    
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        // OI must be constructed after subsystems. If the OI creates Commands
        //(which it very likely will), subsystems are not guaranteed to be
        // constructed yet. Thus, their requires() statements may grab null
        // pointers. Bad news. Don't move it.
        
		oi = new OI();
		
        // instantiate the command used for the autonomous period
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

        autonomousCommand = new AutoNothing();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    	//driveTrain.allStop();

    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
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
    	if (Robot.oi.Auto1.get()) {
    		automode += 1;
    	}
    	if (Robot.oi.Auto2.get()) {
    		automode += 2;
    	}
    	if (Robot.oi.Auto3.get()) {
    		automode += 4;
    	}
    	
    	autoCommandNum = automode;
    	
    	switch (automode) {
    		case 0:	autonomousCommand = new AutoNothing();
    				autoCommandName = "Do Nothing";
    				break;
    		case 1: autonomousCommand = new AutoLowBar();
    				autoCommandName = "Move Forward";
    				break;
    		case 2: autonomousCommand = new AutoBD();
					autoCommandName = "Drive over obstacles B/D";
					break;
    		case 3: autonomousCommand = new AutoLowAndShoot();
					autoCommandName = "Drive under low bar and shoot";
					break;
    		case 4: autonomousCommand = new AutoLowShootBack();
    				autoCommandName = "Drive under low bar, shoot, and return";
    				break;
    		default: autonomousCommand = new AutoNothing();
    				autoCommandName = "Default Do Nothing";
    				break;
    	}	
    }
}
