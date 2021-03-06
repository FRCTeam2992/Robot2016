package org.usfirst.frc2992.Robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;

public class CameraFeeds {
	
	private final int camFront;
	private final int camRear;
	private int curCam;
	private Image frame;
	private CameraServer server;

	
	public CameraFeeds() {
        // Get camera ids by supplying camera name ex 'cam0', found on roborio web interface
        camFront = NIVision.IMAQdxOpenCamera(Robot.frontCamName, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        camRear = NIVision.IMAQdxOpenCamera(Robot.rearCamName, NIVision.IMAQdxCameraControlMode.CameraControlModeController);
        curCam = camFront;
        // Img that will contain camera img
        frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
        // Server that we'll give the img to
        server = CameraServer.getInstance();
        server.setQuality(Robot.imgQual);

	}
	
	public void init() {
		changeCam(camFront);
	}
	
	public void run() {
		if(Robot.oi.leftJoy.getRawButton(Robot.btFrontCam)) {
			changeCam(camFront);
		}
		
		if(Robot.oi.leftJoy.getRawButton(Robot.btRearCam)) {
			changeCam(camRear);
		}
		updateCam();
	}
	
	/**
	 * Stop aka close camera stream
	 */
	public void end() {
		NIVision.IMAQdxStopAcquisition(curCam);
	}
	
	/**
	 * Change the camera to get imgs from to a different one
	 * @param newId for camera
	 */
	public void changeCam(int newId) {
		NIVision.IMAQdxStopAcquisition(curCam);
    	NIVision.IMAQdxConfigureGrab(newId);
    	NIVision.IMAQdxStartAcquisition(newId);
    	curCam = newId;
    }
    
	/**
	 * Get the img from current camera and give it to the server
	 */
    public void updateCam() {
    	NIVision.IMAQdxGrab(curCam, frame, 1);
        server.setImage(frame);
    }
}