package au.com.noojee.orion.api.entities;

import static au.com.noojee.orion.api.entities.InstanceStateType.FINAL;
import static au.com.noojee.orion.api.entities.InstanceStateType.TRANSITIONAL;

public enum OrionInstanceStates
{
	failed_to_provision(FINAL)
	, initial(TRANSITIONAL)
	, pending_verification(TRANSITIONAL)
	, provisioning(TRANSITIONAL)
	, running(FINAL)
	, starting(TRANSITIONAL)
	, stopped(FINAL)
	, stopping(TRANSITIONAL)
	, terminated(FINAL)
	, terminating(TRANSITIONAL)
	, transferred(FINAL)
	, updating(TRANSITIONAL)
	, updating_network(TRANSITIONAL)
	, unknown(TRANSITIONAL) // I add this for internal tracking when we don't know what state the instance is in.
	, deleted(FINAL);	// and another. Means we expect the system to no longer exist.
	
	private InstanceStateType type;
	
	
	OrionInstanceStates(InstanceStateType type)
	{
		this.type = type;
	}


	public InstanceStateType getType()
	{
		return type;
	}
}

