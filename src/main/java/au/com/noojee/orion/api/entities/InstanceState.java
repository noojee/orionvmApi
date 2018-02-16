package au.com.noojee.orion.api.entities;

public enum InstanceState
{
	failed_to_provision, initial, pending_verification
	,provisioning, running, starting, stopped
	,stopping, terminated, terminating
	,transferred, updating, updating_network
	, unknown // I add this for internal tracking when we don't know what state the instance is in.
	, deleted // and another. Means we expect the system to no longer exist.
	;

}
