package be.phury.rest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import fi.iki.elonen.NanoHTTPD;
import fi.iki.elonen.NanoHTTPD.Response.Status;
import fi.iki.elonen.ServerRunner;

public class JsonServer extends NanoHTTPD {
	
	private final Map<String, String> responses = new HashMap<String, String>();
	{
		responses.put("/advisor-dashboard/api/authentication/login", "login.json");
		responses.put("/advisor-dashboard/api/client/1", "client_details.json");
		responses.put("/advisor-dashboard/api/advisor/1", "advisor_details.json");
		responses.put("/advisor-dashboard/api/advisor/1/client/list", "list_of_clients_for_advisor.json");
		responses.put("/error", "error.json");
	}
	
	public static void main(String[] args) {
        ServerRunner.run(JsonServer.class);
    }

    public JsonServer() {
        super(8080);
        
    }

    private Response jsonResponse(String uri) {
    	try {
			String resource = responses.get(uri);
			InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(resource);
			return new Response(IOUtils.toString(resourceStream));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
    
    @Override 
    public Response serve(IHTTPSession session) {
    	
    	Response resp;
    	
    	try {
			
    		
			resp = jsonResponse(session.getUri());
			
		} catch (RuntimeException e) {
			
			resp = jsonResponse("/error");
			resp.setStatus(Status.INTERNAL_ERROR);
//			e.printStackTrace();
//			return debugHtml(session);
		}
    	
    	resp.setMimeType("application/json");
    	return resp;
    }
    
    private Response debugHtml(IHTTPSession session) {
        Map<String, List<String>> decodedQueryParameters =
            decodeParameters(session.getQueryParameterString());

        StringBuilder sb = new StringBuilder();
        sb.append("<html>");
        sb.append("<head><title>Debug Server</title></head>");
        sb.append("<body>");
        sb.append("<h1>Debug Server</h1>");

        sb.append("<p><blockquote><b>URI</b> = ").append(
            String.valueOf(session.getUri())).append("<br />");

        sb.append("<b>Method</b> = ").append(
            String.valueOf(session.getMethod())).append("</blockquote></p>");

        sb.append("<h3>Headers</h3><p><blockquote>").
            append(toString(session.getHeaders())).append("</blockquote></p>");

        sb.append("<h3>Parms</h3><p><blockquote>").
            append(toString(session.getParms())).append("</blockquote></p>");

        sb.append("<h3>Parms (multi values?)</h3><p><blockquote>").
            append(toString(decodedQueryParameters)).append("</blockquote></p>");

        try {
            Map<String, String> files = new HashMap<String, String>();
            session.parseBody(files);
            sb.append("<h3>Files</h3><p><blockquote>").
                append(toString(files)).append("</blockquote></p>");
        } catch (Exception e) {
            e.printStackTrace();
        }

        sb.append("</body>");
        sb.append("</html>");
        return new Response(sb.toString());
    }
    
    private String toString(Map<String, ? extends Object> map) {
        if (map.size() == 0) {
            return "";
        }
        return unsortedList(map);
    }

    private String unsortedList(Map<String, ? extends Object> map) {
        StringBuilder sb = new StringBuilder();
        sb.append("<ul>");
        for (Map.Entry entry : map.entrySet()) {
            listItem(sb, entry);
        }
        sb.append("</ul>");
        return sb.toString();
    }

    private void listItem(StringBuilder sb, Map.Entry entry) {
        sb.append("<li><code><b>").append(entry.getKey()).
            append("</b> = ").append(entry.getValue()).append("</code></li>");
    }
}
