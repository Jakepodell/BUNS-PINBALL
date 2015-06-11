/*************************************************************************
 *  Compilation:  javac CollidingBalls.java
 *  Execution:    java CollidingBalls N
 *  Dependencies: StdDraw.java
 *
 *  Simulate N balls of uniform mass, bouncing off the four walls
 *  and each other according to the laws of elastic collisions.
 *
 *  % java CollidingBalls 50
 *
 *  Limitations
 *  -----------
 *   - Inefficient since it performs N^2 collision checks per dt.
 *
 *   - Can miss collisions. Use event-based simulation and a priority
 *     queue instead of time-based simulation to fix.
 *
 *   - physics not correct
 *
 *************************************************************************/

import java.awt.Color;

public class CollidingBalls {

    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double dt = 1.0;
        double RADIUS = 5.0;

        // initialize positions and velocities at random
        double[] px = new double[N];
        double[] py = new double[N];
        double[] vx = new double[N];
        double[] vy = new double[N];
        Color[] color = new Color[N];
        for (int i = 0; i < N; i++) {
            px[i] = 16 + 480 * Math.random();
            py[i] = 16 + 480 * Math.random();
            vx[i] = 10 * Math.random() - 5;
            vy[i] = 10 * Math.random() - 5;
            color[i] = Color.getHSBColor((float) Math.random(), 1.0f, 1.0f);
        }


        int SIZE = 512;
        StdDraw.setXscale(0, SIZE);
        StdDraw.setYscale(0, SIZE);

        while (true) {
            StdDraw.clear(Color.BLACK);

            // detect collision with wall and reverse velocity
            for (int i = 0; i < N; i++) {
                if ((px[i] + dt * vx[i] > SIZE - RADIUS) || (px[i] + dt * vx[i] < RADIUS)) vx[i] = -vx[i];
                if ((py[i] + dt * vy[i] > SIZE - RADIUS) || (py[i] + dt * vy[i] < RADIUS)) vy[i] = -vy[i];
            }

            // detect collision with other particles
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double dx = (px[i] - px[j]) + dt * (vx[i] - vx[j]);
                    double dy = (py[i] - py[j]) + dt * (vy[i] - vy[j]);

                    // if collision swap velocities
                    if (Math.sqrt(dx*dx + dy*dy) <= 2*RADIUS) {
                        double tempx = vx[i];
                        double tempy = vy[i];
                        vx[i] = vx[j];
                        vy[i] = vy[j];
                        vx[j] = tempx;
                        vy[j] = tempy;
                        StdAudio.play("pop.wav");
                        break;               // only pairwise collisions
                    }
                }
            }

            // update positions
            for (int i = 0; i < N; i++) {
                px[i] = px[i] + vx[i] * dt;
                py[i] = py[i] + vy[i] * dt;
            }

            // update positions
            for (int i = 0; i < N; i++) {
                StdDraw.setPenColor(color[i]);
                StdDraw.filledCircle(px[i], py[i], RADIUS);
            }
            StdDraw.show(50);
        }
    }
}
