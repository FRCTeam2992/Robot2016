package org.usfirst.frc2992.Robot;

import org.usfirst.frc2992.Robot.subsystems.DrivePID;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.MotorSafetyHelper;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;

public class mhRobotDrive implements MotorSafety{

	public SpeedController[] leftDriveMotors;
	public SpeedController[] rightDriveMotors;
	
	SpeedController mLF;
	SpeedController mLM;
	SpeedController mLR;
	
	SpeedController mRF;
	SpeedController mRM;
	SpeedController mRR;
	
	Encoder lEnc;
	Encoder rEnc;
	
	
	protected MotorSafetyHelper safetyHelper;
	
	
	public mhRobotDrive(){
		
		
		leftDriveMotors = new SpeedController[3];
		leftDriveMotors[0] = RobotMap.lFWheel;
		leftDriveMotors[1] = RobotMap.lMWheel;
		leftDriveMotors[2] = RobotMap.lRWheel;
		
		rightDriveMotors = new SpeedController[3];
		rightDriveMotors[0] = RobotMap.rFWheel;
		rightDriveMotors[1] = RobotMap.rMWheel;
		rightDriveMotors[2] = RobotMap.rRWheel;

    			
	    setupMotorSafety();		
		
    }
	
	
	
	/**
    *
    * Tank drive method. Takes in left and right tank drive joystick input
    * values and drives the left and right motors. Input values should be -1.0
    * (reverse) to 1.0 (forward).
    *
    * @param leftJoystickValue
    * @param rightJoystickValue
    */
   public void tankDrive(double leftJoystickValue, double rightJoystickValue){

       double leftspeed = leftJoystickValue;
       double rightspeed = rightJoystickValue;


       // Set the drive motors
       setSpeed(leftDriveMotors, -leftspeed);   // Left motors are reversed
       setSpeed(rightDriveMotors, rightspeed);
       
       /*
        * shifts between high/low gear
	    */
       

       // Smartdashboard update
       // SmartDashboard.putNumber("Left Motor Speed", leftspeed);
       // SmartDashboard.putNumber("Right Motor Speed", rightspeed);
       
       if (!safetyHelper.isSafetyEnabled()) {
           safetyHelper.setSafetyEnabled(true);
    	   
       }

       safetyHelper.feed();
       
   }
   
   

   
/**
*
* Internal utility method to actually set the left drive motors directly.
* Private so should not be used outside this class file.
*
* @param speed -- speed to set the motors to
*
*/
	private void setSpeed(SpeedController[] motors, double speed) {
        for (int i=0; i<motors.length; i++){
    		motors[i].set(speed); 
        	
        }
    }
	/**
	*
	* Internal utility method to actually set the left drive motors directly.
	* Private so should not be used outside this class file.
	*
	* @param speed -- speed to set the motors to
	*
	*/

	public void setExpiration(double timeout) {
        safetyHelper.setExpiration(timeout);
    }

    public double getExpiration() {
        return safetyHelper.getExpiration();
    }

    public boolean isAlive() {
        return safetyHelper.isAlive();
    }

    public boolean isSafetyEnabled() {
        return safetyHelper.isSafetyEnabled();
    }

    public void setSafetyEnabled(boolean enabled) {
        safetyHelper.setSafetyEnabled(enabled);
    }
    
    private void setupMotorSafety() {
        safetyHelper = new MotorSafetyHelper(this);
        safetyHelper.setExpiration(0.1);
        //SafetyHelper.setSafetyEnabled(true);
    }
	
	@Override
	public void stopMotor() {
		// TODO Auto-generated method stub
		for (int i=0; i<rightDriveMotors.length; i++) {
	        rightDriveMotors[i].set(0);
		}
		for (int i=0; i<leftDriveMotors.length; i++){
			leftDriveMotors[i].set(0);
		}
		safetyHelper.setSafetyEnabled(false);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	
}