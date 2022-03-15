package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
//import com.qualcomm.robotcore.eventloop.opmode.Disabled;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.util.ElapsedTime;
//import com.qualcomm.robotcore.util.Range;

@Autonomous(name = "BlueAutoCarousel", group = "A")

public class BlueAutoCarousel extends LinearOpMode
{
   RobotHardware robot = new RobotHardware();
   //* Code to run ONCE when the driver hits INIT

   @Override
   public void runOpMode()
   {
      robot.init(hardwareMap);
      robot.gs.setPosition(.45);
      robot.gs1.setPosition(.3);
      waitForStart();

      drive(-.5, 0.0, 820 * 2);
      drive(-.5, -.5, 500);
      strafer(.5, 350);
      spin(.5, 3500);
      strafer(-.5, 1050);
      drive(-.5, -.5, 200);
   }

   public void armExtend(double power, int time)
   {
      robot.es.setPower(power);
      sleep(time);
      robot.es.setPower(0);
   }

   public void armPos(int height)
   {
      if (height == 0)
      {
         robot.em.setPower(0);
      }
      else if (height == 2)
      {
         robot.em.setPower(.5);
         sleep(height * 350);
         robot.em.setPower(.2);
         sleep(500);
      }
   }

   public void drive(double leftPower, double rightPower, int time)
   {
      robot.leftFront.setPower(leftPower);
      robot.rightFront.setPower(-rightPower);
      robot.leftBack.setPower(leftPower);
      robot.rightBack.setPower(-rightPower);
      sleep(time);
      robot.leftFront.setPower(0);
      robot.rightFront.setPower(0);
      robot.leftBack.setPower(0);
      robot.rightBack.setPower(0);
   }

   public void strafer(double power, int time)
   {
      robot.leftFront.setPower(-power);
      robot.rightFront.setPower(-power);
      robot.leftBack.setPower(power);
      robot.rightBack.setPower(power);
      sleep(time);
      robot.leftFront.setPower(0);
      robot.rightFront.setPower(0);
      robot.leftBack.setPower(0);
      robot.rightBack.setPower(0);
   }

   public void spin(double power, int time)
   {
      robot.cm.setPower(power);
      sleep(time);
      robot.cm.setPower(0);
   }
}