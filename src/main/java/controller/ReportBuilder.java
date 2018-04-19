package controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

import common.Entity;
import common.Operation;
import model.OperativeInstruction;
import model.Storage;

public class ReportBuilder {

	List<OperativeInstruction> instructionList;
	
	public ReportBuilder(Storage storagePar)
	{
		instructionList=storagePar.getAll();
	}
	
	public Report build()
	{
		Report result=new Report();
		
		HashMap <String,BigDecimal> amountInUSDSettledIncomingEveryday= new  HashMap <String,BigDecimal>();
		HashMap <String,BigDecimal> amountInUSDSettledOutgoingEveryday= new  HashMap <String,BigDecimal>();
		HashMap <Entity,BigDecimal> amountOfEntitiesBasedOnIncoming =new  HashMap <Entity,BigDecimal>();
		HashMap <Entity,BigDecimal> amountOfEntitiesBasedOnOutgoing =new  HashMap <Entity,BigDecimal>();
		HashMap <Entity,Integer> rankOfEntitiesBasedOnIncoming =new  HashMap <Entity,Integer>();
		HashMap <Entity,Integer> rankOfEntitiesBasedOnOutgoing =new  HashMap <Entity,Integer>();
		
		for(OperativeInstruction instruction:instructionList)
		{
			//I use an internal representation of time (the Epoch Day)
			//This makes it easier to show the time in different formats, on the view side.
			String dateString=Long.toString(instruction.getRealSettlementDate().toEpochDay());
			BigDecimal amount=instruction.getAmountInUSD();
			Entity entity=instruction.getInstruction().getEntity();
			
			if(instruction.getInstruction().getOperation() == Operation.BUY)
			{
				amountInUSDSettledIncomingEveryday=sumAmount(amountInUSDSettledIncomingEveryday,dateString,amount);
				amountOfEntitiesBasedOnIncoming=sumAmount(amountOfEntitiesBasedOnIncoming,entity,amount);
				
			}
			//it is the SELL case
			else
			{
				amountInUSDSettledOutgoingEveryday=sumAmount(amountInUSDSettledOutgoingEveryday,dateString,amount);
				amountOfEntitiesBasedOnOutgoing=sumAmount(amountOfEntitiesBasedOnOutgoing,entity,amount);
				
			}
		}

		rankOfEntitiesBasedOnIncoming=rank(amountOfEntitiesBasedOnIncoming);
		rankOfEntitiesBasedOnOutgoing=rank(amountOfEntitiesBasedOnOutgoing);
		
		//now I have all the raw data for the report and I can build it.
		result.setAmountInUSDSettledIncomingEveryday(amountInUSDSettledIncomingEveryday);
		result.setAmountInUSDSettledOutgoingEveryday(amountInUSDSettledOutgoingEveryday);
		result.setRankOfEntitiesBasedOnIncoming(rankOfEntitiesBasedOnIncoming);
		result.setRankOfEntitiesBasedOnOutgoing(rankOfEntitiesBasedOnOutgoing);
		
		return result;
	}
	
	private <K> HashMap<K, BigDecimal> sumAmount(HashMap<K,BigDecimal> htPar,K keyPar,BigDecimal howMuchPar)
	{	
		//make a defensive copy of the parameter
		HashMap<K,BigDecimal> result=new HashMap<K, BigDecimal>(htPar);
				
		BigDecimal amountSoFar=result.get(keyPar);
		if(amountSoFar==null)
			amountSoFar=howMuchPar;
		else
			amountSoFar=amountSoFar.add(howMuchPar);
		
		result.put(keyPar, amountSoFar);
		
		return result;
		
	}
	
	//this method assigns a rank value to each Entity
	private HashMap <Entity,Integer> rank(HashMap<Entity, BigDecimal> amountOfEntitiesBasedOnIncoming)
	{
		HashMap <Entity,Integer> result=new HashMap <Entity,Integer>();
		
		TreeSet<BigDecimal> t = new TreeSet<BigDecimal>(amountOfEntitiesBasedOnIncoming.values());
		
		int rankValue=1;
		for(BigDecimal val:t.descendingSet())
		{
			for(Entity key: amountOfEntitiesBasedOnIncoming.keySet())
			{
				if(amountOfEntitiesBasedOnIncoming.get(key).longValue()==val.longValue())
					result.put(key, rankValue);
			}
			
			rankValue+=1;
		}
		
		return result;
	}
	
}
