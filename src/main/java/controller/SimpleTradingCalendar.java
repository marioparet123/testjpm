package controller;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

import common.Currency;

public class SimpleTradingCalendar implements TradingCalendar {

	LocalDate realSettlementDate;
	
	@Override
	public LocalDate getRealSettlementDate(Currency currPar, LocalDate proposedSettlementDatePar) {
		
		realSettlementDate=proposedSettlementDatePar;
		
		if(currPar== Currency.SAR || currPar== Currency.AED)
		{
			if(realSettlementDate.getDayOfWeek()==DayOfWeek.FRIDAY || realSettlementDate.getDayOfWeek()==DayOfWeek.SATURDAY)
				realSettlementDate=realSettlementDate.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		}
		else
		{
			if(realSettlementDate.getDayOfWeek()==DayOfWeek.SATURDAY || realSettlementDate.getDayOfWeek()==DayOfWeek.SUNDAY)
				realSettlementDate=realSettlementDate.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		}
		
		return realSettlementDate;
	}
	
}
