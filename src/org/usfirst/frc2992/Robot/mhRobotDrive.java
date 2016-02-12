package org.usfirst.frc2992.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.MotorSafety;
import edu.wpi.first.wpilibj.MotorSafetyHelper;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;

public class mhRobotDrive implements MotorSafety{

	SpeedController[] leftDriveMotors;
	SpeedController[] rightDriveMotors;
	
	SpeedController mLF;
	SpeedController mLM;
	SpeedController mLR;
	
	SpeedController mRF;
	SpeedController mRM;
	SpeedController mRR;
	
	Encoder LEnc;
	Encoder REnc;
	
	PIDController LFDrive, LMDrive, LRDrive, RFDrive, RMDrive, RRDrive;
	
	public final double PowerMax = 1.00;
	public final double SpeedMax = 10.0;
	
	protected MotorSafetyHelper safetyHelper;
	
	double mKp, mKi, mKd, mKf;
	
	public mhRobotDrive(){
		leftDriveMotors = new SpeedController[3];
		leftDriveMotors[0] = RobotMap.LFWheel;
		leftDriveMotors[1] = RobotMap.LMWheel;
		leftDriveMotors[2] = RobotMap.LRWheel;
		
		rightDriveMotors = new SpeedController[3];
		rightDriveMotors[0] = RobotMap.RFWheel;
		rightDriveMotors[1] = RobotMap.RMWheel;
		rightDriveMotors[2] = RobotMap.RRWheel;

		mLF = leftDriveMotors[0];
		mLM = leftDriveMotors[1];
		mLR = leftDriveMotors[2];
		
		mRF = rightDriveMotors[0];
		mRM = rightDriveMotors[1];
		mRR = rightDriveMotors[2];
		
	    setupMotorSafety();		
		
    }
	
	/*public void smartDrive(SpeedController LF, SpeedController LM, SpeedController LR, SpeedController RF, SpeedController RM, SpeedController RR,
			Encoder LEnc, Encoder REnc,
			double Kp, double Ki, double Kd, double Kf){
		
		mKp = Kp;
		mKi = Ki;
		mKd = Kd;
		mKf = Kf;
		
		LFDrive = new PIDController(mKp, mKi, mKd, mKf, LEnc, mLF);
		LMDrive = new PIDController(mKp, mKi, mKd, mKf, LEnc, mLM);
		LRDrive = new PIDController(mKp, mKi, mKd, mKf, LEnc, mLR);
		
		RFDrive = new PIDController(mKp, mKi, mKd, mKf, REnc, mRF);
		RMDrive = new PIDController(mKp, mKi, mKd, mKf, REnc, mRM);
		RRDrive = new PIDController(mKp, mKi, mKd, mKf, REnc, mRR);
		
		LEnc.reset();
		REnc.reset();
		
		LFDrive.setOutputRange(-PowerMax, PowerMax);
		LFDrive.setInputRange(-SpeedMax, SpeedMax);
		LFDrive.setPercentTolerance(1.0);
    	LFDrive.disable();
    	
    	LMDrive.setOutputRange(-PowerMax, PowerMax);
		LMDrive.setInputRange(-SpeedMax, SpeedMax);
		LMDrive.setPercentTolerance(1.0);
    	LMDrive.disable();
    	
    	LRDrive.setOutputRange(-PowerMax, PowerMax);
		LRDrive.setInputRange(-SpeedMax, SpeedMax);
		LRDrive.setPercentTolerance(1.0);
    	LRDrive.disable();
    	
    	RFDrive.setOutputRange(-PowerMax, PowerMax);
		RFDrive.setInputRange(-SpeedMax, SpeedMax);
		RFDrive.setPercentTolerance(1.0);
    	RFDrive.disable();
    	
    	RMDrive.setOutputRange(-PowerMax, PowerMax);
		RMDrive.setInputRange(-SpeedMax, SpeedMax);
		RMDrive.setPercentTolerance(1.0);
    	RMDrive.disable();
    	
    	RRDrive.setOutputRange(-PowerMax, PowerMax);
		RRDrive.setInputRange(-SpeedMax, SpeedMax);
		RRDrive.setPercentTolerance(1.0);
    	RRDrive.disable();
		
		
		
    	//setupMotorSafety();
	}
	*/
	
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
       setLeftSpeed(leftDriveMotors, leftspeed);
       setRightSpeed(rightDriveMotors, -rightspeed);
       
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