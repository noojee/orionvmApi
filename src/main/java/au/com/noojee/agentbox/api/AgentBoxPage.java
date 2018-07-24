package au.com.noojee.agentbox.api;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class AgentBoxPage<E>
	{
		private AgentBoxEndPoint endPoint;
		private int pageNo = 1;
		private List<E> rows;
		private boolean lastPage = false;
		// private AgentBoxFilter filter;

		public AgentBoxPage(AgentBoxEndPoint endPoint)
		{
			this.endPoint = endPoint;
			// this.filter = filter;
			rows = new LinkedList<>();
		}

	
		public void add(E entity)
		{
			rows.add(entity);
		}

		public List<E> getList()
		{
			return rows;
		}

		public URL getURL(AgentBoxApi api) throws MalformedURLException
		{
			return this.endPoint.getURL(api);
		}


		private URL getURL(AgentBoxApi api, String id) throws MalformedURLException
		{
			return this.endPoint.getURL(api, id);
		}

		public void setLastPage(boolean lastPage)
		{
			this.lastPage = lastPage;

		}

		public boolean isLastPage()
		{
			return lastPage;
		}

		public void inc()
		{
			this.pageNo++;

		}

		public void addAll(List<E> entityList)
		{
			rows = new LinkedList<E>();
			rows.addAll(entityList);
		}

		public int getPageNo()
		{
			return pageNo;
		}

		public String getURLWithArgs(AgentBoxApi api) throws MalformedURLException
		{
			return getURL(api) + buildUrlArgList(this);
		}
		
		public String getURLWithArgs(AgentBoxApi api, String id) throws MalformedURLException
		{
			return getURL(api,id) +  buildUrlArgList(this);
		}



		private String buildUrlArgList(AgentBoxPage<E> page)
		{

			String urlArgs = "?"
					+ ""
					+ "version=2&page=" + page.pageNo + "&limit=" + AgentBoxApi.PAGE_SIZE + "&include=streetAddress" ;

			return urlArgs;
		}


		public int getCount()
		{
			return this.rows.size();
		}


		public E getContact(int currentRow)
		{
			return this.rows.get(currentRow);
		}

	}