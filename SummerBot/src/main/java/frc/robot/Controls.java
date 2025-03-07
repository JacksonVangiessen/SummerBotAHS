package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * Contains functions for use with the Logitech F310 controller.
 *
 */
public class Controls extends Joystick {
	// Axis
	private static final int AXIS_LEFT_X = 0;
	private static final int AXIS_LEFT_Y = 1;
	private static final int AXIS_SHOULDER_L = 2;
	private static final int AXIS_SHOULDER_R = 3;
	private static final int AXIS_RIGHT_X = 4;
	private static final int AXIS_RIGHT_Y = 5;

	// Buttons
	public static final int BUTTON_A = 1;
	public static final int BUTTON_B = 2;
	public static final int BUTTON_X = 3;
	public static final int BUTTON_Y = 4;
	public static final int BUTTON_SHOULDER_LEFT = 5;
	public static final int BUTTON_SHOULDER_RIGHT = 6;
	public static final int BUTTON_TRIGGER_LEFT = 7;
	public static final int BUTTON_TRIGGER_RIGHT = 8;
	public static final int BUTTON_BACK = 7;
	public static final int BUTTON_START = 8;	
	public static final int BUTTON_LEFT_STICK = 9;
	public static final int BUTTON_RIGHT_STICK = 10;

	/**
	 * Constructor that creates a Joystick object.
	 */
	public Controls(int ControlsPort) {
		super(ControlsPort);
	}

	/**
	 * Returns the X position of the left stick.
	 */
	public double getLeftX() {
		return getRawAxis(AXIS_LEFT_X);
	}

	/**
	 * Returns the X position of the right stick.
	 */
	public double getRightX() {
		return getRawAxis(AXIS_RIGHT_X);
	}
	
	
	public double getLeftTrigger() {
		return getRawAxis(AXIS_SHOULDER_L);
	}
	
	public double getRightTrigger() {
		return getRawAxis(AXIS_SHOULDER_R);
	}
	

	

	/**
	 * Returns the Y position of the left stick.
	 */
	public double getLeftY() {
		return getRawAxis(AXIS_LEFT_Y);
	}

	/**
	 * Returns the Y position of the right stick.
	 */
	public double getRightY() {
		return getRawAxis(AXIS_RIGHT_Y);
	}

	/**
	 * Checks whether Button A is being pressed and returns true if it is.
	 */
	public boolean getButtonStateA() {
		return getRawButton(BUTTON_A);
	}

	/**
	 * Checks whether Button B is being pressed and returns true if it is.
	 */
	public boolean getButtonStateB() {
		return getRawButton(BUTTON_B);
	}

	/**
	 * Checks whether Button X is being pressed and returns true if it is.
	 */
	public boolean getButtonStateX() {
		return getRawButton(BUTTON_X);
	}

	/**
	 * Checks whether Button Y is being pressed and returns true if it is.
	 */
	public boolean getButtonStateY() {
		return getRawButton(BUTTON_Y);
	}

	/**
	 * Returns an object of Button A.
	 */
	public JoystickButton getButtonA() {
		return new JoystickButton(this, BUTTON_A);
	}

	/**
	 * Returns an object of Button B.
	 */
	public JoystickButton getButtonB() {
		return new JoystickButton(this, BUTTON_B);
	}

	/**
	 * Returns an object of Button X.
	 */
	public JoystickButton getButtonX() {
		return new JoystickButton(this, BUTTON_X);
	}

	/**
	 * Returns an object of Button Y.
	 */
	public JoystickButton getButtonY() {
		return new JoystickButton(this, BUTTON_Y);
	}

	public boolean getDPadUp() {
		return getPOV() == 0;
	}
	
	public boolean getDPadRight() {
		return getPOV() == 90;
	}
	
	public boolean getDPadDown() {
		return getPOV() == 180;
	}
	
	public boolean getDPadLeft() {
		return getPOV() == 270;
	}

	/**
	 * Gets the state of the Start button
	 *
	 * @return the state of the Start button
	 */
	// public JoystickButton getStartButton() {
	// 	return new JoystickButton(this, BUTTON_START);
	// }

	// public JoystickButton getBackButton() {
	// 	return new JoystickButton(this, BUTTON_BACK);
	// }

	/**
	 * Gets the state of the left shoulder
	 *
	 * @return the state of the left shoulder
	 */
	public JoystickButton getLeftShoulder() {
		return new JoystickButton(this, BUTTON_SHOULDER_LEFT);
	}

	/**
	 * Gets the state of the right shoulder
	 *
	 * @return the state of the right shoulder
	 */
	public JoystickButton getRightShoulder() {
		return new JoystickButton(this, BUTTON_SHOULDER_RIGHT);
	}

	public JoystickButton getLeftStickClick() {
		return new JoystickButton(this, BUTTON_LEFT_STICK);
	}

	public JoystickButton getRightStickClick() {
		return new JoystickButton(this, BUTTON_RIGHT_STICK);
	}

	public JoystickButton rightTrigger(){
		return new JoystickButton(this, BUTTON_TRIGGER_RIGHT);
	}
}