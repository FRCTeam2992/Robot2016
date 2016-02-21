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
public class DuckTail extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final DigitalInput feedersystemLimitswitch = RobotMap.feedLimit;
    private final Solenoid ducktailLA = RobotMap.feedLA;
    private final Solenoid ducktailLB = RobotMap.feedLB;
    private final Solenoid ducktailRA = RobotMap.feedRA;
    private final Solenoid ducktailRB = RobotMap.feedRB;
    
    

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    public void TailFullDown(){
    	ducktailLA.set(true);
    	ducktailLB.set(true);
    	ducktailRA.set(true);
    	ducktailRB.set(true);
    }
    
    public void TailMid(){
    	ducktailLA.set(true);
    	ducktailLB.set(false);
    	ducktailRA.set(true);
    	ducktailRB.set(false);
    }
    
    public void TailUp(){
    	ducktailLA.set(false);
    	ducktailLB.set(false);
    	ducktailRA.set(false);
    	ducktailRB.set(false);
    }
    
   
    public boolean limit(){
    return Robot.shooter.shootOn;
    }
    

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        setDefaultCommand(new DuckTailUp());
    }
}
