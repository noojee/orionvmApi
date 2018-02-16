package au.com.noojee.orion.api;

import java.util.List;

public abstract class OrionAbstractResponseList<E extends OrionEntity<E>> extends  OrionResponseMeta<E>
{
	
	abstract public List<E> getList();
}
