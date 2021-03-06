package gov.nist.appvet.shared.backend;

import gov.nist.appvet.properties.AppVetProperties;

import java.util.ArrayList;

/**
 * This class defines an HTTP request message sent by AppVet to a tool service.
 * 
 * @author steveq@nist.gov
 */
public class RequestParams {

	private static final Logger log = AppVetProperties.log;

	public Protocol protocol = null;
	public String protocolXPath = null;
	public XmlUtil xml = null;
	public String configFileName = null;

	public String URL = null;
	public String method = null;
	public ArrayList<String> formParameterNames = null;
	public ArrayList<String> formParameterValues = null;
	public int pollingMaxIterations = 0;
	public int pollingSleep = 0;
	public String proxyHost = null;
	public String proxyPort = null;
	public boolean proxySSL = false;
	public AppInfo appInfo = null;
	public String toolId = null;

	public RequestParams(Protocol protocol, String protocolXPath,
			XmlUtil xml, String configFileName, AppInfo appInfo, String toolId) {

		this.protocol = protocol;
		this.protocolXPath = protocolXPath;
		this.xml = xml;
		this.configFileName = configFileName;
		this.appInfo = appInfo;
		this.toolId = toolId;
		loadRequest();
	}

	public void loadRequest() {

		URL = xml.getXPathValue(protocolXPath + "/Request/URL");
		checkNullString(configFileName, "URL", URL);
		//log.debug("URL: " + URL);

		method = xml.getXPathValue(protocolXPath + "/Request/Method");
		checkNullString(configFileName, "method", method);			
		//log.debug("Request method: " + method);

		formParameterNames = xml.getXPathValues(protocolXPath
				+ "/Request/Parameter/Name");
		boolean formParamNullOrEmpty = isNullOrEmpty(configFileName, "formParameterNames",
				formParameterNames);
		if (!formParamNullOrEmpty) {
			//log.debug("Form parameter: " + formParameterNames.get(0));
		}

		formParameterValues = xml.getXPathValues(protocolXPath
				+ "/Request/Parameter/Value");
		formParamNullOrEmpty = isNullOrEmpty(configFileName, "formParameterValues",
				formParameterValues);
		if (!formParamNullOrEmpty) {
			//log.debug("For parameter values: " + formParameterValues.get(0));
		}

		if (xml.xpathExists(protocolXPath + "/Request/Polling")) {
			String intStr = xml.getXPathValue(protocolXPath
					+ "/Request/Polling/MaxIterations");
			checkNullString(configFileName, "intStr",
					intStr);
			pollingMaxIterations = new Integer(intStr).intValue();
			log.debug("Polling max iterations: " + pollingMaxIterations);

			intStr = xml.getXPathValue(protocolXPath
					+ "/Request/Polling/Sleep");
			checkNullString(configFileName, "intStr",
					intStr);
			pollingSleep = new Integer(intStr).intValue();
			log.debug("Polling sleep: " + pollingSleep);
		}
		
		if (xml.xpathExists(protocolXPath + "/Request/Proxy")) {
			proxyHost = xml.getXPathValue(protocolXPath
					+ "/Request/Proxy/ProxyHost");
			checkNullString(configFileName, "proxyHost",
					proxyHost);
			appInfo.log.debug(toolId + " Proxy Host: " + proxyHost);

			proxyPort = xml.getXPathValue(protocolXPath
					+ "/Request/Proxy/ProxyPort");
			checkNullString(configFileName, "proxyPort",
					proxyPort);
			appInfo.log.debug(toolId + " Proxy Port: " + proxyPort);

			String proxyUseSSLStr = xml.getXPathValue(protocolXPath
					+ "/Request/Proxy/SSL");
			
			proxySSL = new Boolean(proxyUseSSLStr).booleanValue();
			appInfo.log.debug(toolId + " Proxy SSL: " + proxySSL);
		}
	}

	public void checkNullString(String configFile, String parameter, String value) {
		if ((value == null) || value.isEmpty()) {
			//log.error("Required parameter '" + parameter
			//		+ "' in config file '" + configFile + "' is null or empty.");
		}
	}

	public boolean isNullOrEmpty(String configFile, String parameter,
			ArrayList<String> value) {
		if ((value == null) || value.isEmpty()) {
			//log.warn("Required parameter '" + parameter
			//		+ "' in config file " + configFile
			//		+ " is null or empty.");
			return true;
		} else {
			return false;
		}
	}
}
