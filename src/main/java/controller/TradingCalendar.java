package controller;

import java.time.LocalDate;

public interface TradingCalendar {

	LocalDate getRealSettlementDate(common.Currency currPar, LocalDate proposedSettlementDatePar);
}
