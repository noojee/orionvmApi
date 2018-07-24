package au.com.noojee.orion.api;

import java.util.ArrayList;
import java.util.List;

public class OrionResponseList<E extends OrionEntity<E>> extends  OrionAbstractResponseList<E>
{
	// Stores a list of OrionEntities. 
	private List<E> response;
	
	
	public List<E> getList()
	{
		// Guaranteed to return a list.
		if (response == null)
			response = new ArrayList<>();
		return response;
	}
	
	


	@Override
	public String toString()
	{
		return "OrionResponseList [ response=" + response + super.toString() + "]";
	}
	
	

}
