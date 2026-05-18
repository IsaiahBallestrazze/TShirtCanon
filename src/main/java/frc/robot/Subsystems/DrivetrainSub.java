// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSub extends SubsystemBase {
  /** Creates a new DrivetrainSub. */
    private final SparkMax FRMotor = new SparkMax(5, MotorType.kBrushed);
    private final SparkMax FLMotor = new SparkMax(2, MotorType.kBrushed);
    private final SparkMax BRMotor = new SparkMax(4, MotorType.kBrushed);
    private final SparkMax BLMotor = new SparkMax(3, MotorType.kBrushed);

    //motor controller groups 
      private final MotorControllerGroup leftGroup = new MotorControllerGroup(FLMotor, BLMotor);
      private final MotorControllerGroup rightGroup = new MotorControllerGroup(FRMotor, BRMotor);
      DifferentialDrive drive = new DifferentialDrive(leftGroup, rightGroup);


        public void tankDrive(double left, double right) {
        drive.arcadeDrive(left, right);

          System.out.println("Left speed: " + left);
          System.out.println("Right speed: " + right);

        }

    public DrivetrainSub() {
      FRMotor.setInverted(false); // inverts sides
      FLMotor.setInverted(false);
      BRMotor.setInverted(false); 
      BLMotor.setInverted(false);

      rightGroup.setInverted(false); // inverts sides
      leftGroup.setInverted(true); 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
