package website.web;

import java.io.IOException;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class HomeServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		ServletContext context = config.getServletContext();
		homeJsp = context.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
	}
	private Logger logger = Logger.getLogger(this.getClass());
	private RequestDispatcher homeJsp;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.debug("Retrieving reddit news feed");
		URL url = new URL("https://www.reddit.com/.rss");
		SyndFeedInput syndFeedInput = new SyndFeedInput();
		SyndFeed syndFeed = null;
		XmlReader xmlReader = new XmlReader(url);
		try {
			syndFeed = syndFeedInput.build(xmlReader);
		} catch (IllegalArgumentException e) {
			logger.error("", e);
		} catch (FeedException e) {
			logger.error("", e);
		}
		
		logger.debug("Forwarding to home.jsp");
		req.setAttribute("syndFeed", syndFeed);
		homeJsp.forward(req, resp);
		
	}

}
