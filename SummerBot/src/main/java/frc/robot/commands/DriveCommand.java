package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.command.Command;

import frc.robot.Main;;

public class DriveCommand extends Command {
  DoubleSupplier throttle;
  DoubleSupplier turn;
  public DriveCommand(DoubleSupplier throttle,DoubleSupplier turn) {
    
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    this.turn = turn;
    this.throttle = throttle;
    requires(Main.drive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    Main.drive.arcade(throttle.getAsDouble(), turn.getAsDouble());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
