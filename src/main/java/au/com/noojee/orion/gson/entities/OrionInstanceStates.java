package au.com.noojee.orion.gson.entities;

import static au.com.noojee.orion.gson.entities.InstanceStateType.FINAL;
import static au.com.noojee.orion.gson.entities.InstanceStateType.TRANSITIONAL;

import java.awt.Color;



public enum OrionInstanceStates
{
	 running(FINAL, Color.GREEN, HighLevelState.HAPPY)
	, stopped(FINAL, Color.RED, HighLevelState.SAD)
	, terminated(FINAL, Color.GRAY, HighLevelState.SAD)
	, transferred(FINAL, Color.GRAY, HighLevelState.WARNING)
	, failed_to_provision(FINAL, Color.RED, HighLevelState.SAD)
	, initial(TRANSITIONAL, Color.BLUE, HighLevelState.WATCH)
	, pending_verification(TRANSITIONAL, Color.BLUE, HighLevelState.WATCH)
	, provisioning(TRANSITIONAL, Color.YELLOW, HighLevelState.WATCH)
	, starting(TRANSITIONAL, Color.MAGENTA, HighLevelState.WATCH)
	, stopping(TRANSITIONAL, Color.ORANGE, HighLevelState.WARNING)
	, terminating(TRANSITIONAL, Color.PINK, HighLevelState.WATCH)
	, updating(TRANSITIONAL, Color.BLUE, HighLevelState.WATCH)
	, updating_network(TRANSITIONAL, Color.BLUE, HighLevelState.WATCH)
	, unknown(TRANSITIONAL, Color.RED, HighLevelState.SAD) // I add this for internal tracking when we don't know what state the instance is in.
	, deleted(FINAL, Color.GRAY, HighLevelState.SAD);	// and another. Means we expect the system to no longer exist.
	
	private InstanceStateType type;
	private Color colour;
	private HighLevelState highLevelState;
	
	
	OrionInstanceStates(InstanceStateType type, Color colour, HighLevelState highLevelState)
	{
		this.type = type;
		this.colour = colour;
		this.highLevelState = highLevelState;
	}


	public InstanceStateType getType()
	{
		return type;
	}
	
	public Color getColour()
	{
		return colour;
	}


	public HighLevelState getHighLevelState()
	{
		return highLevelState;
	}
}

