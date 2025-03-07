package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveCommand;

//This is cool!
//this is rad

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */

public class Robot extends TimedRobot {

  public static OI m_oi;

  Command autoCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    
    m_oi = new OI();
    m_chooser = new SendableChooser<Command>();
    //m_chooser.addObject("Test", new TestSandstormExample(false));
    // m_chooser.addObject("Left Side Rocket Hatch", new LeftSideRocketHatch(false));
    // m_chooser.addObject("Right Side Rocket Hatch", new RightSideRocketHatch(false));
    // m_chooser.addObject("Front Cargo Hatch", new FrontCargoHatch(false));
    //m_chooser.addObject("TestSandstormExample", new TestSandstormExample(false));
    m_chooser.setDefaultOption("Default Auto", new DriveCommand(OI.throttle, OI.turn));
    SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    Scheduler.getInstance().removeAll();
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
    //HAL.drive.setBrake(false);
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  
  @Override
  public void autonomousInit() {
    //m_autonomousCommand = new SetTurret();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    
    autoCommand = m_chooser.getSelected();
		autoCommand = (Command) m_chooser.getSelected();
		
		if (autoCommand != null) {
			autoCommand.start();
		}
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.

    if (autoCommand != null) {
      autoCommand.cancel();
    }
  }

  
  @Override
  public void teleopPeriodic() {  
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  
  @Override
  public void testPeriodic() {
  }
}