// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.Commands.BarrelRotation;
import frc.robot.Commands.ClimberSpeed;
import frc.robot.Commands.ShooterSpeed;
import frc.robot.Subsystems.DrivetrainSub;
import frc.robot.Subsystems.ShooterSub;

public class RobotContainer {
private CommandXboxController m_driverController = new CommandXboxController(0);
private final ShooterSub ShooterSub = new ShooterSub();
private final DrivetrainSub driveSub = new DrivetrainSub();


  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    driveSub.setDefaultCommand(
    new RunCommand(
        () -> driveSub.tankDrive(
            -m_driverController.getLeftY(),
            -m_driverController.getLeftX()
        ),
        driveSub
    )
);

    m_driverController.leftTrigger().onTrue(new ShooterSpeed(m_driverController, ShooterSub)); //left trigger is shooter speed.
    m_driverController.rightTrigger().onTrue(new BarrelRotation(m_driverController, ShooterSub)); //right trigger is climber speed.

    m_driverController.povDown().onTrue(new ClimberSpeed(m_driverController, ShooterSub)); //down on the dpad is climber up.
    m_driverController.povUp().onTrue(new ClimberSpeed(m_driverController, ShooterSub)); //up on the dpad is climber down.
    // right trigger is barrel rotation speed.
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }

}
