module orion.api
{
	exports au.com.noojee.orion.api.internals;
	exports au.com.noojee.orion.gson.entities;
	exports au.com.noojee.orion.api;

	requires com.github.spotbugs.annotations;
	requires org.apache.commons.lang3;
	requires com.google.gson;
	requires transitive org.joda.money;
	requires org.apache.logging.log4j;
}