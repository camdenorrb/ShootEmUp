package me.camdenorrb.shootemup;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWMouseButtonCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GL46C;

import java.nio.IntBuffer;
import java.util.Arrays;

import static java.util.Objects.*;
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL46.*;
import static org.lwjgl.system.MemoryUtil.*;

public final class ShootEmUp {

	private long windowUUID;

	private static final int INIT_HEIGHT = 400, INIT_WIDTH = 600;


	public void start() {

		System.out.println("Hello LWJGL " + Version.getVersion() + "!");

		init();
		loop();

		glfwFreeCallbacks(windowUUID);
		glfwDestroyWindow(windowUUID);

		glfwTerminate();

		requireNonNull(glfwSetErrorCallback(null)).free();
	}

	private void init() {

		GLFWErrorCallback.createPrint(System.err).set();

		if (!glfwInit()) {
			throw new IllegalStateException("Unable to initialize GLFW");
		}

		glfwDefaultWindowHints();

		glfwWindowHint(GLFW_SAMPLES, 20);
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);

		windowUUID = glfwCreateWindow(INIT_WIDTH, INIT_HEIGHT, "Meow", NULL, NULL);

		if (windowUUID == NULL) {
			throw new RuntimeException("Failed to create the GLFW window");
		}

		glfwSetMouseButtonCallback(windowUUID, (windowUUID, button, action, mods) -> {

			final double[] xPos = new double[1];
			final double[] yPos = new double[1];

			glfwGetCursorPos(windowUUID, xPos, yPos);

			System.out.println(Arrays.toString(xPos) + Arrays.toString(yPos));
		});

		glfwSetKeyCallback(windowUUID, (windowUUID, key, scanCode, action, mods) -> {
			if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) {
				glfwSetWindowShouldClose(windowUUID, true);
			}
		});


		final GLFWVidMode vidMode = requireNonNull(glfwGetVideoMode(glfwGetPrimaryMonitor()));

		glfwSetWindowPos(windowUUID, (vidMode.width() - INIT_WIDTH) / 2, (vidMode.height() - INIT_HEIGHT) / 2);

		glfwMakeContextCurrent(windowUUID);
		glfwSwapInterval(1);

		glfwShowWindow(windowUUID);


		// Enable multi sampling for anti aliasing
		//glEnable(GL_MULTISAMPLE);
		//glEnable(GL_BLEND);
	}

	private void loop() {

		createCapabilities();

		glClearColor(1.0f, 0.0f, 0.0f, 0.0f);


		while (!glfwWindowShouldClose(windowUUID)) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			drawElems();
			glfwSwapBuffers(windowUUID); // Update display
			glfwWaitEvents();
		}
	}

	private void drawElems() {

		glBegin(GL_TRIANGLES);

		glColor3d(0, 1, 0);

		glVertex3d(-1, -1, 0);
		glVertex3d(0, 1, 0);
		glVertex3d(1, -1, 0);

		glEnd();
		glFlush();
	}

}
