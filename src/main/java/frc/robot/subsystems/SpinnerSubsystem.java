package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.SpinnerConstants;

public class SpinnerSubsystem extends SubsystemBase {
    private WPI_TalonSRX m_spinner = new WPI_TalonSRX(SpinnerConstants.kSpinnerPort);

    /**
     * this is the class for the intake
     * thats it its really simple
     */
    public SpinnerSubsystem() {

    }
    /**
     * will i keep the name as succ? probably
     * can you change it? no.
     * @param speed = speed at which succage occurs
     */
    public void spin(double speed) {
        m_spinner.set(ControlMode.PercentOutput, speed);
    }
}