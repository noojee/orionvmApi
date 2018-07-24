package au.com.noojee.orion.api;

public interface OrionFilter<T>
{

	String toJson();

	int getOffset();

	int getLimit();

}
