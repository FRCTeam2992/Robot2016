// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2992.Robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc2992.Robot.commands.DriveStop;
import org.usfirst.frc2992.Robot.Robot;

/**
 *
 */
public class ShootCmd extends CommandGroup {

	Timer timetotal;
	
	double time;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public ShootCmd() {

        timetotal = new Timer();

    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new HoodUp());
    	addSequential(new WaitCommand(.25));
    	addSequential(new FeedInternalIn());
    	addSequential(new WaitCommand(1.0));
    	addSequential(new HoodDown());
    	addSequential(new FeedInternalOff());
    }
    protected void initialize() {
    	this.setInterruptible(true);
    	
    	time = 2.0;
    	
    	timetotal.reset();
    	timetotal.start();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(timetotal.get() < time){
    		return false;
    	} else{
    		return true;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

}