package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by rCSB14 on 21/11/2015.
 */
public class ManualControl extends OpMode {
    // declare all the motors, inputs, etc. above public void init (or inside anything) because it keeps it global and not local
    //
    DcMotor left_motor;
    DcMotor right_motor;
    DcMotor arm_motor;
    Servo left_gripper;
    Servo right_gripper;
    final double LEFT_OPEN_POSITION = 0.0 ;
    final double LEFT_CLOSED_POSITION = 0.5 ;
    final double RIGHT_OPEN_POSITION = 1.0 ;
    final double RIGHT_CLOSED_POSITION = 0.5 ;

    public ManualControl(){

    }
    @Override
    public void init() {
        //get references to the motors and servos from the hardware map
        arm_motor = hardwareMap.dcMotor.get("arm");
        left_motor = hardwareMap.dcMotor.get("lmotor");
        right_motor = hardwareMap.dcMotor.get("rmotor");
        left_gripper = hardwareMap.servo.get("lgripper");
        right_gripper = hardwareMap.servo.get("rgripper");
        //reverse the left motor
        left_motor.setDirection(DcMotor.Direction.REVERSE);
    }



    @Override

    public void loop() {
        //get values from the gamepad (negated because pushing the stick away from you returns a negative value)
        float leftY = -gamepad1.left_stick_y ;
        float rightY = -gamepad1.right_stick_y ;

        left_motor.setPower (leftY);
        right_motor.setPower(rightY);
        arm_motor.setPower(-gamepad2.left_stick_y);

        if(gamepad2.a) {
            left_gripper.setPosition(LEFT_OPEN_POSITION);
            right_gripper.setPosition(RIGHT_OPEN_POSITION);
        }
        else if(gamepad2.x){
            left_gripper.setPosition(LEFT_CLOSED_POSITION);
            right_gripper.setPosition(RIGHT_CLOSED_POSITION);
        }

    }
    @Override

    public void stop() {
        left_motor.setPower (0);
        right_motor.setPower(0);
        arm_motor.setPower(0);
    }
}