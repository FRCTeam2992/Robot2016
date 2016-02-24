package org.usfirst.frc2992.Robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DualCoder implements PIDSource {

	Encoder m_Encoders[] = new Encoder[2];
	
	public DualCoder(Encoder l, Encoder r){
		m_Encoders[0] = l;
		m_Encoders[1] = r;
	}
	
	
	public void reset() {
		for (Encoder enc : m_Encoders) {
			enc.reset();
		}
	}
	
	/**
	 * PID value is the average of the encoders individually
	 */
	public double pidGet() {
		double sum = 0;
		sum -= m_Encoders[0].getDistance();  // Left encoder is reversed
		sum += m_Encoders[1].getDistance();
		SmartDashboard.putNumber("DoubleCoder output", sum/2.0);
		return sum/2.0;
	}
	
	public boolean isStuck() {
		// Returns true if at least 1 encoder not moving
		boolean stuck = false;
		for (Encoder enc : m_Encoders) {
			if (enc.getStopped()) {
				stuck = true;
			}
		}
		return stuck;
	}


	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return PIDSourceType.kDisplacement;
	}

}
