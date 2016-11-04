<%@ page import="com.sun.syndication.feed.synd.SyndFeed" %> 
<%@ page import="com.sun.syndication.feed.synd.SyndEntry" %> 
<%@ page import="java.util.Iterator" %> 
<jsp:useBean id="syndFeed" scope="request" type="SyndFeed" />
<html>
   <head>
      <title>website</title>
   	
    </style>
      <script type="text/javascript" src="timePage.js"></script>
    	<script type="text/javascript">
	var currentTime = new Date()
	var hours = currentTime.getHours()
	var minutes = currentTime.getMinutes()

	if (minutes < 10)
	minutes = "0" + minutes

	var suffix = "AM";
	if (hours >= 12) {
	suffix = "PM";
	hours = hours - 12;
	}
	if (hours == 0) {
	hours = 12;
	}

	document.write("<b>" + hours + ":" + minutes + " " + suffix + "</b>")
</script>     
   </head>
   




   <body onload='window.setInterval("timeHere()", 100)'  onunload="sayTime()">
	      	
   
      <h1><a href = "https://www.reddit.com">Home</a></h1>
      <h2><%=syndFeed.getTitle()%></h2>
      <ul>
         <% 
           Iterator it = syndFeed.getEntries().iterator();
           while (it.hasNext())
           {
              SyndEntry entry = (SyndEntry) it.next();
         %>
            <li>
               <a href="<%=entry.getLink()%>"><%=entry.getTitle()%></a>
            </li>
         <% } %>
      </ul>
   </body>
</html>