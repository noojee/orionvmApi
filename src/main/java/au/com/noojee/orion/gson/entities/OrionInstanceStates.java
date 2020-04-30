package au.com.noojee.orion.gson.entities;

import static au.com.noojee.orion.gson.entities.InstanceStateType.FINAL;
import static au.com.noojee.orion.gson.entities.InstanceStateType.TRANSITIONAL;



public enum OrionInstanceStates
{
	 running(FINAL)
	, stopped(FINAL)
	, terminated(FINAL)
	, transferred(FINAL)
	, failed_to_provision(FINAL)
	, initial(TRANSITIONAL)
	, pending_verification(TRANSITIONAL)
	, provisioning(TRANSITIONAL)
	, starting(TRANSITIONAL)
	, stopping(TRANSITIONAL)
	, terminating(TRANSITIONAL)
	, updating(TRANSITIONAL)
	, updating_network(TRANSITIONAL)
	, unknown(TRANSITIONAL) // I add this for internal tracking when we don't know what state the instance is in.
	, deleted(FINAL)	// and another. Means we expect the system to no longer exist.
	, other_dc(FINAL);  /// The instance not hosted in the orion dc.
	
	private InstanceStateType type;
	
	
	OrionInstanceStates(InstanceStateType type)
	{
		this.type = type;
	}


	public InstanceStateType getType()
	{
		return type;
	}


	public boolean isTransitioning()
	{
		return type == InstanceStateType.TRANSITIONAL;
	}
	
}

