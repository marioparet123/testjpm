package model;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;

import common.Currency;
import common.Entity;
import common.Operation;

public class TestOperation {

	Instruction instruction=new Instruction();
	OperativeInstruction oi;
	
	@Test
	public void testRealSettlementDate()
	{
		OperativeInstruction oi;
		
		instruction.setEntity(Entity.FOO);
		instruction.setOperation(Operation.BUY);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.SGP);
		instruction.setInstructionDate(LocalDate.of(2018, Month.APRIL, 1));
		instruction.setSettlementDate(LocalDate.of(2018, Month.APRIL, 2));
		instruction.setUnits(new BigDecimal(200));
		instruction.setPricePerUnit(new BigDecimal(100.25));
		
		oi=new OperativeInstruction(instruction);
		
		assertEquals("2018-04-02",oi.getRealSettlementDate().toString());
		
		
		instruction=new Instruction();
		
		instruction.setEntity(Entity.FOO);
		instruction.setOperation(Operation.BUY);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.SGP);
		instruction.setInstructionDate(LocalDate.of(2018, Month.APRIL, 1));
		instruction.setSettlementDate(LocalDate.of(2018, Month.APRIL, 7));
		instruction.setUnits(new BigDecimal(200));
		instruction.setPricePerUnit(new BigDecimal(100.25));
		
		oi=new OperativeInstruction(instruction);
		assertEquals("2018-04-09",oi.getRealSettlementDate().toString());
	}
	
	@Test
	//USD amount of a trade = Price per unit * Units * Agreed Fx 
	public void  testGetAmountInUSD()
	{
		instruction=new Instruction();
		instruction.setEntity(Entity.FOO);
		instruction.setOperation(Operation.BUY);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.SGP);
		instruction.setInstructionDate(LocalDate.of(2018, Month.APRIL, 1));
		instruction.setSettlementDate(LocalDate.of(2018, Month.APRIL, 7));
		instruction.setUnits(new BigDecimal(200));
		instruction.setPricePerUnit(new BigDecimal(100.25));
		oi=new OperativeInstruction(instruction);
		
		BigDecimal expected=new BigDecimal(100.25*0.5*200);
		assertTrue(expected.compareTo(oi.getAmountInUSD())==0);
	}
}
