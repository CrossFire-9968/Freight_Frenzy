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

@Autonomous(name = "RedAutoWarehouse", group = "Test")

public class RedAutoWarehouse extends LinearOpMode
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
      int duckPosition = 2;

      robot.em.setPower(.45);
      sleep(450);
      robot.em.setPower(.2);
      sleep(1000);
      drive(.45, .45, 550);
      drive(.45, -.45, 850);
      drive(-.45, -.45, 150);
      sleep(200);
      strafer(-.45, 490);
      sleep(200);
      if (robot.sensorColorRange.green() >= 40)
      {
         duckPosition = 1;
      }
      strafer(.45, 150);
      sleep(100);
      drive(.45, .45, 425);
      sleep(100);
      strafer(-.45, 200);
      sleep(200);
      if (robot.sensorColorRange.green() >= 40)
      {
         duckPosition = 0;
      }
      armPos(duckPosition);
      drive(0, .45, 450);
      strafer(-.45, 100);
      robot.es.setPower(-1);
      sleep(4100);
      robot.es.setPower(0);
      sleep(300);
      armOpen();
      drive(0, -.45, 450);
      strafer(.45, 700);
      robot.es.setPower(1);
      sleep(4000);
      robot.es.setPower(0);
      robot.em.setPower(-.5);
      sleep(300);
      robot.em.setPower(0);
      drive(-.40, 40, 550);
      drive(-.2, -.2, 1250);
      strafer(-.45, 2150);
      sleep(100);
      drive(.5, .5, 1000);
      drive(-.5, .5, 800);
      drive(.5, .5, 850);
   }

   public void armExtend(double power, int time)
   {
      robot.es.setPower(-power);
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
         robot.em.setPower(-.3);
         sleep(200);
         robot.em.setPower(.2);
         sleep(200);
         robot.em.setPower(.5);
         sleep(100);
         robot.em.setPower(.2);
      } else if (height == 2)
      {
         robot.em.setPower(.7);
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
}
