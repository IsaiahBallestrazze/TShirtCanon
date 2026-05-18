// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.RobotContainer;
import frc.robot.Subsystems.ShooterSub;

public class ClimberSpeed extends Command {
  /** Creates a new ClimberSpeed. */
  private CommandXboxController g_driverController;
  private ShooterSub shooterSub;


  public ClimberSpeed(CommandXboxController l_driverController, ShooterSub l_shooterSub) {
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
    if (g_driverController.povDown().getAsBoolean()) {
          shooterSub.setClimberSpeed(.5);
          System.out.println("Climber speed: " + .5);

    } else if (g_driverController.povUp().getAsBoolean()) {
          shooterSub.setClimberSpeed(-.5);
          System.out.println("Climber speed: " + -.5);

    } else{
          shooterSub.setClimberSpeed(0);
          System.out.println("Climber speed: " + 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
          shooterSub.setClimberSpeed(0);
          System.out.println("Climber speed: " + 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return g_driverController.povDown().getAsBoolean() == false && g_driverController.povUp().getAsBoolean() == false; //if the dpad is released, end the command.
  }
}
