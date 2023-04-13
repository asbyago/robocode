package Consul10kg;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Consul10kg - a robot by (Yago Araujo de Souza Barbosa)
 */
public class Consul10kg extends Robot
{
	/**
	 * run: Consul10kg's default behavior
	 */
	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.red,Color.red,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			// Replace the next 4 lines with any behavior you would like
			turnRadarRight(360); // Gira o radar completo para procurar inimigos
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		// Define a direção do canhão e move o robô na direção do inimigo
    	setTurnGunRight(getHeading() - getGunHeading() + e.getBearing());
    	setAhead(e.getDistance() / 2);
		
    	// Atira sucessivamente quando o canhão estiver pronto
    	while (getGunHeat() > 0) {
      		turnGunRight(10);
    	}
    	fire(1);
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		back(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20);
	}	
}
