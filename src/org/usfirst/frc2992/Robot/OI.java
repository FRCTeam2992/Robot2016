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

import org.usfirst.frc2992.Robot.commands.*;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	
	// 2 joysticks and 1 switchbox
	public mhJoystick leftJoy;
	public mhJoystick rightJoy;
	public Joystick switchbox;
	
	// joystick buttons
	//public JoystickButton gearHigh;
	//public JoystickButton gearLow;
	public JoystickButton joyShootHigh;
	public JoystickButton joyShootLow;
	public JoystickButton joyShootOff;
	public JoystickButton joyIntakeForward;
	public JoystickButton joyIntakeReverse;
	public JoystickButton joyPhotonOnOff;
	public JoystickButton joySolenoidTest;
	public JoystickButton joyArmOutIn;
	
	// switchbox buttons
	public JoystickButton shoot;
	public JoystickButton intakeInvert;
	public JoystickButton duckTailUp;
	public JoystickButton duckTailDown;
	public JoystickButton intakeForward;
	public JoystickButton intakeReverse;
	public JoystickButton flyWheelOn;
	public JoystickButton photonOnOff;
	public JoystickButton HoodUp;
	public JoystickButton HoodDown;
	
	public JoystickButton auto1;
	public JoystickButton auto2;
	public JoystickButton auto3;
	
	// following button is regarding a possibility of being able to press a button to line yourself up and shoot for you.
	public JoystickButton smartShoot;
	
	

    public OI() {
    	// joysticks
        leftJoy = new mhJoystick(0);
        rightJoy = new mhJoystick(1);
        
        // switchbox
        switchbox = new Joystick(2);
        
        // Joystick button assignments, **need to verify**
        
        //right Joystick
        joyShootHigh = new JoystickButton(rightJoy, 1);
        joyShootLow = new JoystickButton(rightJoy, 2);
        joyShootOff = new JoystickButton(rightJoy, 3);
        joyPhotonOnOff = new JoystickButton(rightJoy, 4);
        joyArmOutIn = new JoystickButton(rightJoy,5);
        
        //left Joystick
        joyIntakeForward = new JoystickButton(leftJoy, 3);
        joyIntakeReverse = new JoystickButton(leftJoy,4);
        joySolenoidTest = new JoystickButton(leftJoy, 6);
        
        //switchbox button assigments, **need to verify**
        
        //Button Box
        shoot = new JoystickButton(switchbox, 12);
        duckTailUp = new JoystickButton(switchbox, 1);
        duckTailDown = new JoystickButton(switchbox, 2);
        intakeForward = new JoystickButton(switchbox, 5);
        intakeReverse = new JoystickButton(switchbox, 6);
        flyWheelOn = new JoystickButton(switchbox, 4);
        photonOnOff = new JoystickButton(switchbox, 8);
        HoodUp = new JoystickButton(switchbox, 9);
        HoodDown = new JoystickButton(switchbox, 16);
        
        auto1 = new JoystickButton(switchbox, 13);
        auto2 = new JoystickButton(switchbox, 14);
        auto3 = new JoystickButton(switchbox, 15);
        
        
       
        joyShootHigh.whenPressed(new ShootHigh());
        joyShootOff.whenPressed(new ShootOff());
        
        flyWheelOn.whenActive(new ShootHigh());
        
        flyWheelOn.whenReleased(new ShootOff());
        
        
        duckTailUp.whenActive(new DuckTailUp());
        duckTailDown.whenActive(new DuckTailFullDown());
        
        duckTailUp.whenReleased(new DuckTailMid());
        duckTailDown.whenReleased(new DuckTailMid());
        
        intakeForward.whenActive(new FeedInInternal());
        intakeForward.whenActive(new FeedInExternal());
        
        intakeForward.whenReleased(new FeedOffInternal());
        intakeForward.whenReleased(new FeedOffExternal());
        
        intakeReverse.whenActive(new FeedOutInternal());
        intakeReverse.whenActive(new FeedOutExternal());
        
        intakeReverse.whenReleased(new FeedOffInternal());
        intakeReverse.whenReleased(new FeedOffExternal());
        
        joySolenoidTest.whenPressed(new DuckTailUp());
        joySolenoidTest.whenReleased(new DuckTailFullDown());
        
        
        photonOnOff.whenActive(new PhotonOn());
        photonOnOff.whenReleased(new PhotonOff());
        
        joyPhotonOnOff.whenPressed(new PhotonOn());
        joyPhotonOnOff.whenReleased(new PhotonOff());
        
        joyArmOutIn.whenPressed(new ArmOut());
        joyArmOutIn.whenReleased(new ArmIn());
        
        //smartShoot.whenPressed(new AutoLowAndShoot());
        
    }
    
    public mhJoystick getLeftJoy(){
    	return leftJoy;
    }
    
    public mhJoystick getRightJoy(){
    	return rightJoy;
    }
    
    public Joystick getSwitchbox(){
    	return switchbox;
    }
}

