package adapter;

import mockExtLibs_adaptee.ISmartThirdPartyAnalyticLibrary;
import target.DataAnalyzer;

public class XMLToJSONAdapter implements DataAnalyzer {
	private ISmartThirdPartyAnalyticLibrary iSmartThirdPartyAnalyticLibrary;

	public XMLToJSONAdapter(ISmartThirdPartyAnalyticLibrary iSmartThirdPartyAnalyticLibrary) {
		this.iSmartThirdPartyAnalyticLibrary = iSmartThirdPartyAnalyticLibrary;
	}

	@Override
	public void analyzeData(String xmlData) {
		String jsonData = convertXMLToJSONData(xmlData);

		iSmartThirdPartyAnalyticLibrary.analyzeData(jsonData);
	}

	private String convertXMLToJSONData(String xmlData) {
		// Logic to convert the xmlData to JSON data.
		String jsonData = "{" + "\"stock\": {" + "\"symbol\": \"GOOG\"," + "\"price\": 1500" + "}" + "}";

		return jsonData;
	}
}
