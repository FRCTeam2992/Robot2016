package org.usfirst.frc2992.Robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;

public class mhRobotDrive{

	SpeedController[] leftDriveMotors;
	SpeedController[] rightDriveMotors;

	
	public mhRobotDrive(){
		leftDriveMotors = new SpeedController[3];
		leftDriveMotors[0] = new Talon(0);
		leftDriveMotors[1] = new Talon(1);
		leftDriveMotors[2] = new VictorSP(2);
		
		rightDriveMotors = new SpeedController[3];
		rightDriveMotors[0] = new Talon(3);
		rightDriveMotors[1] = new Talon(4);
		rightDriveMotors[2] = new VictorSP(5);
		
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
       setRightSpeed(rightDriveMotors, -rightspeed);
       
      

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
	private void setLeftSpeed(SpeedController[] leftDriveMotors, double speed) {
        for (int i=0; i<leftDriveMotors.length; i++){
    		leftDriveMotors[i].set(speed);
        	
        }
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
	private void setRightSpeed(SpeedController[] rightDriveMotors, double speed) {
		for (int i=0; i<rightDriveMotors.length; i++) {
	           rightDriveMotors[i].set(speed);
		}
    }
	
	
}