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

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

import org.usfirst.frc2992.Robot.commands.DriveAuto;
import org.usfirst.frc2992.Robot.Robot;

/**
 *
 */
public class AutoLowShootBack extends CommandGroup {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public AutoLowShootBack() {

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
    	addSequential(new DriveAuto(2.0, 0.0, 1.0));
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveAuto(0.0, 36.0, 1.0));
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveAuto(-1.0, 0.0, 1.0));
    	addSequential(new WaitCommand(1));
    	addSequential(new ShootHigh());
    	addSequential(new WaitCommand(2));
    	addSequential(new DriveAuto(1.0, 0.0, 1.0));
    	addSequential(new WaitCommand(2));
    	addSequential(new DriveAuto(1.0, -36.0, 1.0));
    	addSequential(new WaitCommand(1));
    	addSequential(new DriveAuto(-2.0, 0.0, 1.0));
    	addSequential(new WaitCommand(2));
    	addSequential(new DriveStop());
    }
}
