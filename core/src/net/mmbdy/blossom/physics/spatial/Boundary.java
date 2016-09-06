/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.physics.spatial;

import java.awt.Point;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

//TODOC: Document this

public class Boundary {
	public float x0, y0, x1, y1;
	public float width, height;
	
	public Boundary(int x0, int y0, int x1, int y1) {
		setPins(x0, y0, x1, y1);
	}
	
	public Boundary() {}
	
	// y0
	// |---------|
	// | |
	// x0 | | x1
	// | |
	// |---------|
	// y1
	
	public boolean overlaps(Boundary target) {
		return !(target.y1 < this.y0 || target.x0 > this.x1 || target.y0 > this.y1 || target.x1 < this.x0);
	}
	
	public Boundary setPins(int x0, int y0, int x1, int y1) {
		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		width = Math.abs(x1 - x0);
		height = Math.abs(y1 - y0);
		return this;
	}
	
	public Boundary setBounds(float x, float y, float width, float height) {
		this.width = width;
		this.height = height;
		x0 = x;
		y0 = y;
		x1 = x + width;
		y1 = y + height;
		return this;
	}
	
	public Boundary shift(float x, float y){
		x0 += x;
		x1 += x;
		y0 += y;
		y1 += y;
		return this;
	}
	
	public Boundary shiftTo(float x, float y){
		x0 = x;
		y0 = y;
		x1 = x + width;
		y1 = y + height;
		return this;
	}
	
	public void renderRectangle(SpriteBatch batch) {
		// Draw Rect
		System.out.println("X: " + x0 + " Y: " + y0 + " W: " + width + " H: " + height);
	}
	
	public boolean inside(Point p) {
		return (p.x > x0 && p.y > y0) && (p.x < x1 && p.y < y1);
	}
}