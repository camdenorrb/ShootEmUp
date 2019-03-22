package me.camdenorrb.shootemup.window;


import me.camdenorrb.shootemup.base.pos.impl.immutable.Pos2D;
import me.camdenorrb.shootemup.base.pos.impl.immutable.Pos3D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Objects.*;
import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL.createCapabilities;
import static org.lwjgl.opengl.GL46.*;
import static org.lwjgl.system.MemoryUtil.*;


public class Window {

	private Long uuid;


	private final String title;

	private final int initHeight, initWidth;

	private final List<WindowHint> hintList = new ArrayList<>();


	public Window(String title, int initHeight, int initWidth) {
		this.title = title;
		this.initWidth = initWidth;
		this.initHeight = initHeight;
	}


	public void init() {

		for (WindowHint hint : hintList) {
			glfwWindowHint(hint.getHint(), hint.getValue());
		}

		uuid = glfwCreateWindow(initWidth, initHeight, title, NULL, NULL);
	}


	public void addHints(WindowHint... hints) {
		hintList.addAll(Arrays.asList(hints));
	}

	public boolean remHint(int hint) {
		return hintList.removeIf(it -> it.getHint() == hint);
	}


	public void vec2D(Pos2D pos) {
		glVertex2d(pos.getX(), pos.getY());
	}

	public void vec2D(double x, double y) {
		glVertex2d(x, y);
	}


	public void vec3D(Pos3D pos) {
		glVertex3d(pos.getX(), pos.getY(), pos.getZ());
	}

	public void vec3D(double x, double y, double z) {
		glVertex3d(x, y, z);
	}


	public Long getUUID() {
		return uuid;
	}

	public int getInitWidth() {
		return initWidth;
	}

	public int getInitHeight() {
		return initHeight;
	}

	public List<WindowHint> getHintList() {
		return Collections.unmodifiableList(hintList);
	}

}
