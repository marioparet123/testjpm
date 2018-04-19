package model;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

import common.Currency;
import controller.SimpleTradingCalendar;
import controller.TradingCalendar;

//The aim of this class is to normalize the Instruction class and to add more features to it.
//The original Instruction class is left unchanged.
//I use this class more or less like a "Decorator" for the Instruction class.
//I want use this class because the received Instructions maybe can't be executed; for instance when
//a settlement date is on the week end.
//I keep the original received Instruction, but I create this class which represents
//an Instruction that will be really executed.
public class OperativeInstruction {

	Instruction instruction;
	LocalDate realSettlementDate;
	
	public Instruction getInstruction() {
		return instruction;
	}

	public void setInstruction(Instruction instruction) {
		this.instruction = instruction;
	}

	public LocalDate getRealSettlementDate() {
		return realSettlementDate;
	}

	public void setRealSettlementDate(LocalDate realSettlementDate) {
		this.realSettlementDate = realSettlementDate;
	}

	public OperativeInstruction(Instruction instructionPar)
	{
		instruction=instructionPar;
		setupDates();
	}

	//this method sets the validSettlementDate.
	//The Instruction object can contain some settlement dates that are no valid, for instance a weekend.
	//So I must check them and set the valid date.
	private void setupDates() {
		
		LocalDate settlementDate=instruction.getSettlementDate();
		realSettlementDate=settlementDate;
		
		TradingCalendar tc=new SimpleTradingCalendar();
		
		realSettlementDate=tc.getRealSettlementDate(instruction.getCurrency(), instruction.getSettlementDate());
	}
	
	//USD amount of a trade = Price per unit * Units * Agreed Fx 
	public BigDecimal getAmountInUSD()
	{
		return instruction.getPricePerUnit().multiply(instruction.getAgreedFx()).multiply(instruction.getUnits());
	}
}
