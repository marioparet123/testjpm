package view;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

import common.Entity;
import controller.Report;

public class SimpleViewer implements Viewer{

	@Override
	public void show(Report reportPar) {
		
		System.out.println("*** Amount In USD Settled Incoming Everyday ***");
		{
			HashMap<String, BigDecimal> mymap=reportPar.getAmountInUSDSettledIncomingEveryday();
			Map<String, BigDecimal> treeMap = new TreeMap<String, BigDecimal>(mymap);
			treeMap.forEach((key, value) -> System.out.println(format(key) + " : " + value));
		}
		System.out.println("");
		
		System.out.println("*** Amount In USD Settled Outgoing Everyday ***");
		{

			HashMap<String, BigDecimal> mymap=reportPar.getAmountInUSDSettledOutgoingEveryday();
			Map<String, BigDecimal> treeMap = new TreeMap<String, BigDecimal>(mymap);
			treeMap.forEach((key, value) -> System.out.println(format(key) + " : " + value));
			System.out.println("");
		}
		System.out.println("");
		
		System.out.println("*** Rank Of Entities Based On Incoming ***");
		{
			Stream<Map.Entry<Entity,Integer>> sorted =reportPar.getRankOfEntitiesBasedOnIncoming().entrySet().stream().sorted(Map.Entry.comparingByValue());
			Iterator<Entry<Entity, Integer>> iterator=sorted.iterator();
			while(iterator.hasNext())
			{
				Map.Entry<Entity,Integer> next=iterator.next();
				System.out.println(next.getKey()+" : "+next.getValue());
			}

		}
		System.out.println("");
		
		System.out.println("*** Rank Of Entities Based On Outgoing ***");
		{
			Stream<Map.Entry<Entity,Integer>> sorted =reportPar.getRankOfEntitiesBasedOnOutgoing().entrySet().stream().sorted(Map.Entry.comparingByValue());
			Iterator<Entry<Entity, Integer>> iterator=sorted.iterator();
			while(iterator.hasNext())
			{
				Map.Entry<Entity,Integer> next=iterator.next();
				System.out.println(next.getKey()+" : "+next.getValue());
			}
		}
		System.out.println("");
		
	}
	
	//you can choose here the format of the date
	LocalDate format(String epochDay)
	{
		LocalDate result = LocalDate.ofEpochDay(Long.parseLong(epochDay));
		
		return result;
	}
}
