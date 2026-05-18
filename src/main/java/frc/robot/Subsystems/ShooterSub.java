// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSub extends SubsystemBase {
  /** Creates a new Climber. */
    public ShooterSub() {}
    private final SparkMax shooterLeft = new SparkMax(7, MotorType.kBrushed);
    private final SparkMax shooterRight = new SparkMax(8, MotorType.kBrushed);

    private final SparkMax barrelRotation = new SparkMax(6, MotorType.kBrushless);
    private final SparkMax climberSub = new SparkMax(1, MotorType.kBrushed);

  public void setRightSpeed(double speed){
    shooterRight.set(-speed);
  }
  public void setLeftSpeed(double speed){
    shooterLeft.set(-speed);
  }
  public void setBarrelRotationSpeed(double speed){
    barrelRotation.set(speed);
  }
  public void setClimberSpeed(double speed){
    climberSub.set(speed);
  }

  //map funtion ai make
  public double map(double x, double in_min, double in_max, double out_min, double out_max) {
    return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}