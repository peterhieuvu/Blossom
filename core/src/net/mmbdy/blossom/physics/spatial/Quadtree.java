/** 
 * Copyright (c) 2016, Peter Vu. All rights reserved.
 * License terms are in the included LICENSE.txt file.
 */
package net.mmbdy.blossom.physics.spatial;

import java.util.ArrayList;
import java.util.List;

import net.mmbdy.blossom.entity.OEntity;
import net.mmbdy.blossom.util.Disposable;

//TODOC: Document this

public class Quadtree implements Disposable {

	private final int MAX_OBJECTS = 10; //Maximum Num of objects a node can hold before it splits
	private final int MAX_LEVELS = 5; //Deepest level subnode

	private int level; //current node level (0 is topmost)
	private List<OEntity> entities;
	
	//maybe just make bounds entities themselves
	private Boundary bounds; //2D space the node occupies
	private Quadtree[] nodes; //the four subnodes

	public Quadtree(int level, Boundary bounds) {
		this.level = level;
		entities = new ArrayList<OEntity>();
		this.bounds = bounds;
		nodes = new Quadtree[4];
	}

	//clear nodes recursively
	public void clear() {
		entities.clear();

		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null) {
				nodes[i].clear();
				nodes[i] = null;
			}
		}
	}

	//split the node into 4 subnodes
	private void split() {
		int subWidth = (int)(bounds.width / 2);
		int subHeight = (int)(bounds.height / 2);
		int x = (int)bounds.x0;
		int y = (int)bounds.y0;

		nodes[0] = new Quadtree(level + 1, new Boundary().setBounds(x + subWidth, y, subWidth,
				subHeight));
		nodes[1] = new Quadtree(level + 1, new Boundary().setBounds(x, y, subWidth, subHeight));
		nodes[2] = new Quadtree(level + 1, new Boundary().setBounds(x, y + subHeight, subWidth,
				subHeight));
		nodes[3] = new Quadtree(level + 1, new Boundary().setBounds(x + subWidth, y + subHeight,
				subWidth, subHeight));
	}

	//Find which node an object belongs to. -1 means object doesnt fit in a child node
	//and is part of the parent node
	private int getIndex(OEntity entity) {
		int index = -1;
		Boundary bounds = entity.getBounds();
		double verticalMidpoint = bounds.x0 + (bounds.width / 2);
		double horizontalMidpoint = bounds.y0 + (bounds.height / 2);

		// Object can completely fit in the top quadrants.
		boolean topQuadrant = (bounds.y0 < horizontalMidpoint && bounds.y0
				+ bounds.height < horizontalMidpoint);
		//maybe change this so that it only check for the second expression ^
		
		// Object can completely fit in the bottom quadrants
		boolean bottomQuadrant = (bounds.y0 > horizontalMidpoint);
		
		//object fitting into left quadrants completely
		if(bounds.x0 < verticalMidpoint && bounds.x0 + bounds.width < verticalMidpoint){
			if(topQuadrant) index = 1;
			else if(bottomQuadrant) index = 2;
		}
		//object fitting into right quadrants completely
		if(bounds.x0 > verticalMidpoint){
			if(topQuadrant) index = 0;
			if(bottomQuadrant) index = 3;
		}
		//maybe use boundaries to automate this
		return index;
	}
	
	//insert object into quadtree, if node exceeds the capacity, it will split at add all objects
	//to the corresponding nodes.
	public void insert(OEntity object){
		
		//go through all the levels until you hit a null layer
		//check if the node has any child nodes and tries to add the object there,
		//if there are no child nodes or the object doesnt fit into a child node,
		//it adds the object to the parent node.
		if(nodes[0] != null){
			int index = getIndex(object);
			if(index != -1){ //if bounds is completely in one of the quadrants
				nodes[index].insert(object);
				return;
			}
		}
		
		entities.add(object);
		
		//once the object is added, it determines whether the node needs to be split or not
		//splitting will cause the node to insert any object that can fit in a child node to be added
		//to the child node, otherwise the object will stay in the parent node.
		if(entities.size() > MAX_OBJECTS && level < MAX_LEVELS){
			if(nodes[0] == null){
				split();
			}
			int i = 0;
			while(i < entities.size()){
				int index = getIndex(entities.get(i));
				if(index != -1){
					nodes[index].insert(entities.remove(i));
				} else i++;
			}
		}
	}
	
	//return all objects that could collide with the given object
	public List<OEntity> retrieve(List<OEntity> returnObjects, OEntity mob){
		int index = getIndex(mob);
		if(index != -1 && nodes[0] != null){
			nodes[index].retrieve(returnObjects, mob);
		}
		returnObjects.addAll(entities);
		return returnObjects;
	}

	@Override
	public void dispose() {
		entities.clear();
	}
}