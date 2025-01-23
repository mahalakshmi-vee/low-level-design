package main;

import adapter.XMLToJSONAdapter;
import mockExtLibs_adaptee.ISmartThirdPartyAnalyticLibrary;
import mockExtLibs_adaptee.SmartThirdPartyAnalyticLibrary;
import target.DataAnalyzer;
import target.StockXMLDataProvider;

public class AppMain {
	public static void main(String[] args) {
		StockXMLDataProvider stockXMLDataProvider = new StockXMLDataProvider();
		String stockXMLData = stockXMLDataProvider.getStockXMLData();

//		Initial coding implementation.
//		DataAnalyzer stockXMLDataAnalyzer = new StockXMLDataAnalyzer();
//		stockXMLDataAnalyzer.analyzeData(stockXMLData);

//		As part of improving the performance of the system, the team decided to use the external third part library to perform this process.
		ISmartThirdPartyAnalyticLibrary iSmartThirdPartyAnalyticLibrary = new SmartThirdPartyAnalyticLibrary();
		DataAnalyzer dataAnalyzer = new XMLToJSONAdapter(iSmartThirdPartyAnalyticLibrary);
		dataAnalyzer.analyzeData(stockXMLData);
	}
}
