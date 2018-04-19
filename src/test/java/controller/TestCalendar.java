package controller;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import common.Currency;
import common.Entity;
import common.Operation;
import controller.SimpleTradingCalendar;
import controller.TradingCalendar;

public class TestCalendar {

	@Test
	public void testGetRealSettlementDateNonArabic() {
		
		TradingCalendar tc=new SimpleTradingCalendar();
		
		assertEquals("2018-04-02",
				tc.getRealSettlementDate(Currency.SGP, LocalDate.of(2018, Month.APRIL, 2)).toString());
		
		assertEquals("2018-04-03",
				tc.getRealSettlementDate(Currency.SGP, LocalDate.of(2018, Month.APRIL, 3)).toString());
		
		assertEquals("2018-04-04",
				tc.getRealSettlementDate(Currency.SGP, LocalDate.of(2018, Month.APRIL, 4)).toString());
		
		assertEquals("2018-04-05",
				tc.getRealSettlementDate(Currency.SGP, LocalDate.of(2018, Month.APRIL, 5)).toString());
		
		assertEquals("2018-04-06",
				tc.getRealSettlementDate(Currency.SGP, LocalDate.of(2018, Month.APRIL, 6)).toString());
		
		assertEquals("2018-04-09",
				tc.getRealSettlementDate(Currency.SGP, LocalDate.of(2018, Month.APRIL, 7)).toString());
	
		assertEquals("2018-04-09",
				tc.getRealSettlementDate(Currency.SGP, LocalDate.of(2018, Month.APRIL, 8)).toString());
		
		assertEquals("2018-04-09",
				tc.getRealSettlementDate(Currency.SGP, LocalDate.of(2018, Month.APRIL, 9)).toString());
		

	}
	
	@Test
	public void testGetRealSettlementDateArabic() {
		
		TradingCalendar tc=new SimpleTradingCalendar();
		
		//AED
		assertEquals("2018-04-02",
				tc.getRealSettlementDate(Currency.AED, LocalDate.of(2018, Month.APRIL, 2)).toString());
		
		assertEquals("2018-04-03",
				tc.getRealSettlementDate(Currency.AED, LocalDate.of(2018, Month.APRIL, 3)).toString());
		
		assertEquals("2018-04-04",
				tc.getRealSettlementDate(Currency.AED, LocalDate.of(2018, Month.APRIL, 4)).toString());
		
		assertEquals("2018-04-05",
				tc.getRealSettlementDate(Currency.AED, LocalDate.of(2018, Month.APRIL, 5)).toString());
		
		assertEquals("2018-04-08",
				tc.getRealSettlementDate(Currency.AED, LocalDate.of(2018, Month.APRIL, 6)).toString());
		
		assertEquals("2018-04-08",
				tc.getRealSettlementDate(Currency.AED, LocalDate.of(2018, Month.APRIL, 7)).toString());
	
		assertEquals("2018-04-08",
				tc.getRealSettlementDate(Currency.AED, LocalDate.of(2018, Month.APRIL, 8)).toString());
		
		assertEquals("2018-04-09",
				tc.getRealSettlementDate(Currency.AED, LocalDate.of(2018, Month.APRIL, 9)).toString());
		

		//SAR
		assertEquals("2018-04-02",
				tc.getRealSettlementDate(Currency.SAR, LocalDate.of(2018, Month.APRIL, 2)).toString());
		
		assertEquals("2018-04-03",
				tc.getRealSettlementDate(Currency.SAR, LocalDate.of(2018, Month.APRIL, 3)).toString());
		
		assertEquals("2018-04-04",
				tc.getRealSettlementDate(Currency.SAR, LocalDate.of(2018, Month.APRIL, 4)).toString());
		
		assertEquals("2018-04-05",
				tc.getRealSettlementDate(Currency.SAR, LocalDate.of(2018, Month.APRIL, 5)).toString());
		
		assertEquals("2018-04-08",
				tc.getRealSettlementDate(Currency.SAR, LocalDate.of(2018, Month.APRIL, 6)).toString());
		
		assertEquals("2018-04-08",
				tc.getRealSettlementDate(Currency.SAR, LocalDate.of(2018, Month.APRIL, 7)).toString());
	
		assertEquals("2018-04-08",
				tc.getRealSettlementDate(Currency.SAR, LocalDate.of(2018, Month.APRIL, 8)).toString());
		
		assertEquals("2018-04-09",
				tc.getRealSettlementDate(Currency.SAR, LocalDate.of(2018, Month.APRIL, 9)).toString());
		
	}

}
