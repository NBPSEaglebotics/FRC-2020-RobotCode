package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class Intake extends CommandBase {
    IntakeSubsystem m_intake = new IntakeSubsystem();
    private final double m_speed;

    public Intake(IntakeSubsystem intake, DoubleSupplier speed) {
        m_intake = intake;
        m_speed = speed.getAsDouble();
        addRequirements(intake);
    }
    @Override
    public void execute() {
        m_intake.succ(m_speed);
    }
}