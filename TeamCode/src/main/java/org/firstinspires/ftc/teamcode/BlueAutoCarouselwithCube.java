package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;
//import com.qualcomm.robotcore.util.Hardware;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

@Autonomous(name = "BlueAutoCauroselwithCube", group = "Test")

public class BlueAutoCarouselwithCube extends LinearOpMode
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
      int duckPosition = 0;

      robot.em.setPower(.5);
      sleep(550);
      robot.em.setPower(.2);
      sleep(1000);
      drive(-.5, 0.0, 820 * 2);
      drive(-.5, -.5, 270 * 2);
      strafer(.5, 225);
      spin(.5, 3500);
      drive(.5, .5, 925);
      sleep(100);
      strafer(-.5, 650);
      sleep(100);
      if (robot.sensorColorRange.green() >= 50)
      {
         duckPosition = 2;
      }
      strafer(.5, 200);
      sleep(100);
      drive(.5, .5, 375);
      sleep(100);
      strafer(-.5, 190);
      sleep(200);
      if (robot.sensorColorRange.green() >= 50)
      {
         duckPosition = 1;
      }
      strafer(.5, 750);
      sleep(100);
      sleep(300);
      armPos(duckPosition);
      drive(.25, .25, 3500);
      sleep(300);
      strafer(-.5, 800);
      sleep(300);
      armOpen();
      sleep(300);

      armPos(0);
      drive(.5, -.5, 800);
      drive(.25, .25, 2600);
      strafer(-.5, 2450);
   }

   public void armExtend(double power, int time)
   {
      robot.es.setPower(power);
      sleep(time);
      robot.es.setPower(0);
   }

   public void armClose()
   {
      robot.gs.setPosition(.45);
      robot.gs1.setPosition(.30);
   }

   public void armOpen()
   {
      robot.gs.setPosition(.7);
      robot.gs1.setPosition(0);
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