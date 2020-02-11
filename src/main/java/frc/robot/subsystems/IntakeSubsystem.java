package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.IntakeConstants;

public class IntakeSubsystem extends SubsystemBase {
    WPI_TalonSRX m_intake = new WPI_TalonSRX(IntakeConstants.kIntakePort);

    /**
     * this is the class for the intake
     * thats it its really simple
     */
    public IntakeSubsystem() {

    }
    /**
     * will i keep the name as succ? probably
     * can you change it? no.
     * @param speed = speed at which succage occurs
     */
    public void succ(double speed) {
        m_intake.set(ControlMode.PercentOutput, speed);
    }
}