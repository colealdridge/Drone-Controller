import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.lang.*;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.*;

	public class ControlModel {
	
	private double speed = 0.00;
    	private final double normSpeed = 0.10;
	private double lX = 0.0;
	private double lY = 0.0;
	private double lZ = 0.0;
	private double aZ = 0.0;
	private PrintWriter out;
	Socket sock;
	
	
	
		
		public ControlModel() {
		
			try {
				sock = new Socket("robcog.cs.okstate.edu", 9095);
				out = new PrintWriter(sock.getOutputStream());
			} 
			catch (Exception e) {
				System.out.print(e);
			}
		}
		
		
		
		public void Land() {
			String landing_msg = "{\"op\":\"publish\",\"topic\":\"/ardrone/land\",\"msg\":{}}";
			out.write(landing_msg);
			out.flush();
		}
		
		public void Takeoff() {
			String takeoff_msg = "{\"op\":\"publish\",\"topic\":\"/ardrone/takeoff\",\"msg\":{}}";
			out.print(takeoff_msg);
			out.flush();
		}
		
		
		public void goUp() {
			lX = 0;
			lY = 0;
			lZ = normSpeed + speed;
			aZ = 0;

        		out.print(move(lX, lY, lZ, aZ));
        		out.flush();
		}
		
		public void goDown() {
			lX = 0;
			lY = 0;
			lZ = -normSpeed - speed;
			aZ = 0;

			out.print(move(lX, lY, lZ, aZ));
			out.flush();
		}
		
		public void Stop() {
			lX = 0;
			lY = 0;
			lZ = 0;
			aZ = 0;

			out.print(move(lX, lY, lZ, aZ));
			out.flush();
		}
		
		public void goForward() {
			lX = normSpeed + speed;
			lY = 0;
			lZ = 0;
			aZ = 0;

			out.print(move(lX, lY, lZ, aZ));
			out.flush();
		}
		
		public void goBackward() {
			lX = -normSpeed - speed;
			lY = 0;
			lZ = 0;
			aZ = 0;

			out.print(move(lX, lY, lZ, aZ));
			out.flush();
		}
		
		public void goLeft() {
			lX = 0;
			lY = normSpeed + speed;
			lZ = 0;
			aZ = 0;

			out.print(move(lX, lY, lZ, aZ));
			out.flush();
		}
		
		public void goRight() {
			lX = 0;
			lY = -normSpeed - speed;
			lZ = 0;
			aZ = 0;

			out.print(move(lX, lY, lZ, aZ));
			out.flush();
		}
		
		public void turnLeft() {
			lX = 0;
			lY = 0;
			lZ = 0;
			aZ = normSpeed + speed;

			out.print(move(lX, lY, lZ, aZ));
			out.flush();
		}
		
		public void turnRight() {
			lX = 0;
			lY = 0;
			lZ = 0;
			aZ = -normSpeed - speed;

			out.print(move(lX, lY, lZ, aZ));
			out.flush();
		}
		
		public void goSlower() {
			if(speed < 0.15 && speed > -0.15) {
				speed = speed - 0.01;
			}
		}
		
		public void goFaster() {
			if(speed < 0.15 && speed > -0.15) {
				speed = speed + 0.01;
			}
		}
		
		private static String move(double lX, double lY, double lZ, double aZ) {
			return "{\"op\":\"publish\"," +
					"\"topic\":\"/cmd_vel\"," +
					"\"msg\":{\"linear\":{" +
					"\"x\":" + lX + "," +
					"\"y\":" + lY + "," +
					"\"z\":" + lZ + "}," +
					"\"angular\":{" +
					"\"x\":0," +
					"\"y\":0," +
					"\"z\":" + aZ + "}}}";
		}

		
		
		
		
	}	











