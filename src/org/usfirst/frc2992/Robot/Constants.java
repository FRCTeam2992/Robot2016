package org.usfirst.frc2992.Robot;

public class Constants{// file used solely for constants elsewhere. keep variables descriptive, will be renamed elsewhere
	
	/**
	 * Vision constants
	 */
    public static final boolean SimpleVision = true;
    public static final String frontCamName = "cam0";
    public static final int imgQual = 30;
    // Constants for 2 camera vision mode (only used if SimpleVision is false)
    public static final int btFrontCam = 5;
    public static final int btRearCam = 6;
    public static final String rearCamName = "cam1";
    
    //Subsystems
    
    
    /**
	 * Drive Train
	 */
    final static int numDriveMotors = 3; //number of drive motors on each side
    
    public static final double distanceP = 0.1;
    public static final double distanceI = 0.0;
    public static final double distanceD = 0.0;
    
    
    /**
     * FeedExternal
     */
    public static final double extFeedForwardSpeed = 0.5;
    public static final double extFeedReverseSpeed = 0.0;
    
    
    /**
     * FeedInternal
     */
    public static final double intFeedForwardSpeed = 1.0;
    public static final double intFeedReverseSpeed = -0.75;
    
    
    /**
     * PhotonCannon
     */
    public static final double photonAutoOff = 10.0;
    
    
    /**
     * Shooter
     */
    public static final double shooterRpmMaxSpeed = 4600;
    public static final double shooterPowerMax = 1.0;
    public static final double shooterP = 0.0001;
    public static final double shooterI = 0.0;
    public static final double shooterD = 0.004;
    public static final double shooterF = 1.0/4600.0;
    
    public static final double shootReverseSpeed = 0.35;
    
    public static final double maxShootTime = 7.5;
    
    
	public Constants(){
	
	}
}