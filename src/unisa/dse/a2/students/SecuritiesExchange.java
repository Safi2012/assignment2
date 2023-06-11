package unisa.dse.a2.students;

import java.util.HashMap;
import java.util.Scanner;


public class SecuritiesExchange {

	/**
	 * Exchange name
	 */
	private String name;
	
	public String getName() {
		return name;
	}
	
	/**
	 * List of brokers on this exchange
	 */
	public DSEListGeneric<StockBroker> brokers;
	
	/**
	 * List of announcements of each trade processed
	 */
	public DSEListGeneric<String> announcements;
	
	/**
	 * HashMap storing the companies, stored based on their company code as the key
	 */
	public HashMap<String, ListedCompany> companies;

	/**
	 * Initialises the exchange ready to handle brokers, announcements, and companies
	 * @param name
	 */
	public SecuritiesExchange(String name)
	{
		this.name=name;
		brokers=new DSEListGeneric<StockBroker>();
		this.announcements=new DSEListGeneric<String>();
		this.companies=new HashMap<String, ListedCompany>();
	}
	
	/**
	 * Adds the given company to the list of listed companies on the exchange
	 * @param company
	 * @return true if the company was added, false if it was not
	 */
	public boolean addCompany(ListedCompany company)
	{
		if(company==null)
			return false;
		if(companies.put(company.getCode(), company)==null)
			
		return true;
		return false;
	}

	/**
	 * Adds the given broke to the list of brokers on the exchange
	 * @param company
	 */
	public boolean addBroker(StockBroker broker)
	{
		return brokers.add(broker);
	}
	
	/**
	 * Process the next trade provided by each broker, processing brokers starting from index 0 through to the end
	 * 
	 * If the exchange has three brokers, each with trades in their queue, then three trades will processed, one from each broker.
	 * 
	 * If a broker has no pending trades, that broker is skipped
	 * 
	 * Each processed trade should also make a formal announcement of the trade to the announcements list in the form a string:
	 * "Trade: QUANTITY COMPANY_CODE @ PRICE_BEFORE_TRADE via BROKERNAME", 
	 * e.g. "Trade: 100 DALL @ 99 via Honest Harry Broking" for a sale of 100 DALL shares if they were valued at $99
	 * Price shown should be the price of the trade BEFORE it's processed. Each trade should add its announcement at 
	 * the end of the announcements list
	 * 
	 * @return The number of successful trades completed across all brokers
	 * @throws UntradedCompanyException when traded company is not listed on this exchange
	 */
	public int processTradeRound() throws UntradedCompanyException
	{
		int trades=0;
		for(int i=0; i<brokers.size(); i++)
		{
			if(brokers.get(i).getPendingTradeCount()>0)				
			{
				//companies.get(brokers.get(i)).processTrade(i)
				Trade t=brokers.get(i).getNextTrade();
				
				ListedCompany c=companies.get(t.listedCompanyCode);
				if(c==null)
						throw new UntradedCompanyException("");
				String st="Trade: "+t.getShareQuantity()+" "+ c.getCode()+" @ "+c.getCurrentPrice()+" via "+brokers.get(i).getName();
				System.out.println(st);
				this.announcements.add(st);
				c.processTrade(t.getShareQuantity());
				trades++;
			}
		}
		return trades;
	}
	
	
	
	public int runCommandLineExchange(Scanner sc)
	{
		return 0;
	}
}
