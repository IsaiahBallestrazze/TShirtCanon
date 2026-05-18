// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.RobotContainer;
import frc.robot.Subsystems.ShooterSub;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class ShooterSpeed extends Command {
  /** Creates a new ShooterSpeed. */
  private double speed;
  private CommandXboxController g_driverController;
  private ShooterSub shooterSub;


  public ShooterSpeed(CommandXboxController l_driverController, ShooterSub l_shooterSub) {
    // Use addRequirements() here to declare subsystem dependencies.
    g_driverController = l_driverController;
    shooterSub = l_shooterSub;

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    speed = g_driverController.getLeftTriggerAxis();
    shooterSub.setLeftSpeed(speed);
    shooterSub.setRightSpeed(speed);

    System.out.println("Shooter speed: " + speed);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSub.setLeftSpeed(0);
    shooterSub.setRightSpeed(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return g_driverController.getLeftTriggerAxis() < .1; //if the trigger is released, end the command.
  }
}
