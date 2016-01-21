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

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static SpeedController driveTrainRightfrontdrivewheel;
    public static SpeedController driveTrainRightmiddrivewheel;
    public static SpeedController driveTrainRightreardrivewheel;
    public static SpeedController driveTrainLeftfrontdrivewheel;
    public static SpeedController driveTrainLeftmiddrivewheel;
    public static SpeedController driveTrainLeftreardrivewheel;
    public static Encoder driveTrainRightdrivetrainencoder;
    public static Encoder driveTrainLeftdrivetrainencoder;
    public static AnalogGyro driveTrainGyro;
    public static Solenoid driveTrainDriveshifthighlow;
    public static SpeedController feedFeederwheel;
    public static DigitalInput feedFeedersystemLimitswitch;
    public static Solenoid feedDucktailupdown;
    public static SpeedController shooterShooterwheel;
    public static Encoder shooterShooterwheelencoder;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        driveTrainRightfrontdrivewheel = new Talon(0);
        LiveWindow.addActuator("DriveTrain", "Right front drive wheel", (Talon) driveTrainRightfrontdrivewheel);
        
        driveTrainRightmiddrivewheel = new Talon(1);
        LiveWindow.addActuator("DriveTrain", "Right mid drive wheel", (Talon) driveTrainRightmiddrivewheel);
        
        driveTrainRightreardrivewheel = new Talon(2);
        LiveWindow.addActuator("DriveTrain", "Right rear drive wheel", (Talon) driveTrainRightreardrivewheel);
        
        driveTrainLeftfrontdrivewheel = new Talon(3);
        LiveWindow.addActuator("DriveTrain", "Left front drive wheel", (Talon) driveTrainLeftfrontdrivewheel);
        
        driveTrainLeftmiddrivewheel = new Talon(4);
        LiveWindow.addActuator("DriveTrain", "Left mid drive wheel", (Talon) driveTrainLeftmiddrivewheel);
        
        driveTrainLeftreardrivewheel = new Talon(5);
        LiveWindow.addActuator("DriveTrain", "Left rear drive wheel", (Talon) driveTrainLeftreardrivewheel);
        
        driveTrainRightdrivetrainencoder = new Encoder(0, 1, false, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "Right drive train encoder", driveTrainRightdrivetrainencoder);
        driveTrainRightdrivetrainencoder.setDistancePerPulse(1.0);
        driveTrainRightdrivetrainencoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainLeftdrivetrainencoder = new Encoder(2, 3, true, EncodingType.k4X);
        LiveWindow.addSensor("DriveTrain", "Left drive train encoder", driveTrainLeftdrivetrainencoder);
        driveTrainLeftdrivetrainencoder.setDistancePerPulse(1.0);
        driveTrainLeftdrivetrainencoder.setPIDSourceType(PIDSourceType.kRate);
        driveTrainGyro = new AnalogGyro(0);
        LiveWindow.addSensor("DriveTrain", "Gyro", driveTrainGyro);
        driveTrainGyro.setSensitivity(0.007);
        driveTrainDriveshifthighlow = new Solenoid(0, 0);
        LiveWindow.addActuator("DriveTrain", "Drive shift highlow", driveTrainDriveshifthighlow);
        
        feedFeederwheel = new Victor(7);
        LiveWindow.addActuator("Feed", "Feeder wheel", (Victor) feedFeederwheel);
        
        feedFeedersystemLimitswitch = new DigitalInput(6);
        LiveWindow.addSensor("Feed", "Feeder system Limit switch", feedFeedersystemLimitswitch);
        
        feedDucktailupdown = new Solenoid(0, 1);
        LiveWindow.addActuator("Feed", "Duck tail updown", feedDucktailupdown);
        
        shooterShooterwheel = new Talon(6);
        LiveWindow.addActuator("Shooter", "Shooter wheel", (Talon) shooterShooterwheel);
        
        shooterShooterwheelencoder = new Encoder(4, 5, false, EncodingType.k4X);
        LiveWindow.addSensor("Shooter", "Shooter wheel encoder", shooterShooterwheelencoder);
        shooterShooterwheelencoder.setDistancePerPulse(1.0);
        shooterShooterwheelencoder.setPIDSourceType(PIDSourceType.kRate);

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
