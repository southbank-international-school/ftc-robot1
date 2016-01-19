package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.TouchSensor;

/**
 * Created by julian on 17/01/2016.
 */
public class DriveWithTouchSensorTurnLinear extends LinearOpMode {

    DcMotor left_motor;
    DcMotor right_motor;
    TouchSensor touch_sensor;

    //time constants
    long BACKUP_TIME = 1000;
    long TURN_BASE_TIME = 250;
    long MAX_RANDOM_TIME = 1000;

    @Override
    public void runOpMode() throws InterruptedException{
        left_motor = hardwareMap.dcMotor.get("lmotor");
        right_motor = hardwareMap.dcMotor.get("rmotor");
        right_motor.setDirection(DcMotor.Direction.REVERSE);
        touch_sensor = hardwareMap.touchSensor.get("touch_sensor");

        waitForStart();

        while (true) {
            //back up and turn if the touch sensor is pressed
            if (touch_sensor.isPressed()) {
                //set the motors to drive backwards at 25% power
                left_motor.setPower(-0.25);
                right_motor.setPower(-0.25);
                telemetry.addData("State", "Backing Up");
                sleep(BACKUP_TIME);

                //set the motors to turn the robot right at 25% power
                left_motor.setPower(0.25);
                right_motor.setPower(-0.25);
                long randomTime = (long) (TURN_BASE_TIME + Math.random()*MAX_RANDOM_TIME);
                telemetry.addData("Turn Time", randomTime);
                sleep(randomTime);
            } else {
                //set the motors to drive forward at 50% power
                left_motor.setPower(0.5);
                right_motor.setPower(0.5);
                telemetry.addData("State", "Driving");
            }
            //wait for one hardward cycle to allow other processes to run
            waitOneFullHardwareCycle();
        }
    }
}
