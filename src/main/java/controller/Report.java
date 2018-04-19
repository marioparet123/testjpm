package controller;

import java.math.BigDecimal;
import java.util.HashMap;

import common.Entity;

public class Report {
	private HashMap <String,BigDecimal> amountInUSDSettledIncomingEveryday= new  HashMap <String,BigDecimal>();
	private HashMap <String,BigDecimal> amountInUSDSettledOutgoingEveryday= new  HashMap <String,BigDecimal>();
	private HashMap <Entity,Integer> rankOfEntitiesBasedOnIncoming =new  HashMap <Entity,Integer>();
	private HashMap <Entity,Integer> rankOfEntitiesBasedOnOutgoing =new  HashMap <Entity,Integer>();
	public HashMap<String, BigDecimal> getAmountInUSDSettledIncomingEveryday() {
		return amountInUSDSettledIncomingEveryday;
	}
	public void setAmountInUSDSettledIncomingEveryday(HashMap<String, BigDecimal> amountInUSDSettledIncomingEveryday) {
		this.amountInUSDSettledIncomingEveryday = amountInUSDSettledIncomingEveryday;
	}
	public HashMap<String, BigDecimal> getAmountInUSDSettledOutgoingEveryday() {
		return amountInUSDSettledOutgoingEveryday;
	}
	public void setAmountInUSDSettledOutgoingEveryday(HashMap<String, BigDecimal> amountInUSDSettledOutgoingEveryday) {
		this.amountInUSDSettledOutgoingEveryday = amountInUSDSettledOutgoingEveryday;
	}
	public HashMap<Entity, Integer> getRankOfEntitiesBasedOnIncoming() {
		return rankOfEntitiesBasedOnIncoming;
	}
	public void setRankOfEntitiesBasedOnIncoming(HashMap<Entity, Integer> rankOfEntitiesBasedOnIncoming) {
		this.rankOfEntitiesBasedOnIncoming = rankOfEntitiesBasedOnIncoming;
	}
	public HashMap<Entity, Integer> getRankOfEntitiesBasedOnOutgoing() {
		return rankOfEntitiesBasedOnOutgoing;
	}
	public void setRankOfEntitiesBasedOnOutgoing(HashMap<Entity, Integer> rankOfEntitiesBasedOnOutgoing) {
		this.rankOfEntitiesBasedOnOutgoing = rankOfEntitiesBasedOnOutgoing;
	}
	
}
