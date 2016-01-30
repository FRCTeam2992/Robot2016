package org.usfirst.frc2992.Robot.subsystems;

import edu.wpi.first.wpilibj.Talon;

public class mhRobotDrive{

	Talon[] leftDriveMotors;
	Talon[] rightDriveMotors;
	int[] leftMotorChannels;
	int[] rightMotorChannels;
	int i = 3;
	
	public mhRobotDrive(int[] leftMotorChannels, int[] rightMotorChannels){
		leftDriveMotors[i] = new Talon(leftMotorChannels[i]);
        rightDriveMotors[i] = new Talon(rightMotorChannels[i]);
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
   public void tankDrive(double leftJoystickValue, double rightJoystickValue) {

       double leftspeed = leftJoystickValue;
       double rightspeed = rightJoystickValue;


       // Set the drive motors
       setLeftSpeed(leftDriveMotors, leftspeed);
       setRightSpeed(rightDriveMotors, rightspeed);

       // Smartdashboard update
       // SmartDashboard.putNumber("Left Motor Speed", leftspeed);
       // SmartDashboard.putNumber("Right Motor Speed", rightspeed);
   }

/**
*
* Internal utility method to actually set the left drive motors directly.
* Private so should not be used outside this class file.
*
* @param leftDriveMotors -- left array of motors to set
* @param speed -- speed to set the motors to
*
*/
	private void setLeftSpeed(Talon[] leftDriveMotors, double speed) {
           leftDriveMotors[i].set(speed);
    }
	/**
	*
	* Internal utility method to actually set the left drive motors directly.
	* Private so should not be used outside this class file.
	*
	* @param leftDriveMotors -- left array of motors to set
	* @param speed -- speed to set the motors to
	*
	*/
	private void setRightSpeed(Talon[] rightDriveMotors, double speed) {
	           rightDriveMotors[i].set(speed);
    }
	/**
	 * sets all motors to 0
	 */
	
}