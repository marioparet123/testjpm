package main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

import common.Currency;
import common.Entity;
import common.Operation;
import controller.Report;
import controller.ReportBuilder;
import model.Instruction;
import model.Storage;
import model.StorageInMemory;
import view.SimpleViewer;
import view.Viewer;

public class Main {

	public static void main(String[] args) {

		Main mymain=new Main();
		mymain.runExample();
	}

	private void runExample()
	{
		Storage storage=new StorageInMemory();
		
		Instruction instruction=new Instruction();
		
		instruction.setEntity(Entity.FOO);
		instruction.setOperation(Operation.BUY);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.SGP);
		instruction.setInstructionDate(LocalDate.of(2016, Month.JANUARY, 1));
		instruction.setSettlementDate(LocalDate.of(2016, Month.JANUARY, 2));
		instruction.setUnits(new BigDecimal(200));
		instruction.setPricePerUnit(new BigDecimal(100.25));
		storage.add(instruction);
		
		instruction=new Instruction();
		instruction.setEntity(Entity.FOO);
		instruction.setOperation(Operation.BUY);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.SGP);
		instruction.setInstructionDate(LocalDate.of(2016, Month.JANUARY, 1));
		instruction.setSettlementDate(LocalDate.of(2016, Month.JANUARY, 5));
		instruction.setUnits(new BigDecimal(100));
		instruction.setPricePerUnit(new BigDecimal(100.25));
		storage.add(instruction);

		instruction=new Instruction();
		instruction.setEntity(Entity.ENTITY1);
		instruction.setOperation(Operation.BUY);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.SGP);
		instruction.setInstructionDate(LocalDate.of(2016, Month.JANUARY, 1));
		instruction.setSettlementDate(LocalDate.of(2016, Month.JANUARY, 5));
		instruction.setUnits(new BigDecimal(10));
		instruction.setPricePerUnit(new BigDecimal(100.25));
		storage.add(instruction);
		
		instruction=new Instruction();
		instruction.setEntity(Entity.ENTITY3);
		instruction.setOperation(Operation.BUY);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.SGP);
		instruction.setInstructionDate(LocalDate.of(2016, Month.JANUARY, 1));
		instruction.setSettlementDate(LocalDate.of(2016, Month.JANUARY, 5));
		instruction.setUnits(new BigDecimal(10));
		instruction.setPricePerUnit(new BigDecimal(100.25));
		storage.add(instruction);
		
		instruction=new Instruction();
		instruction.setEntity(Entity.ENTITY2);
		instruction.setOperation(Operation.BUY);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.SGP);
		instruction.setInstructionDate(LocalDate.of(2016, Month.JANUARY, 1));
		instruction.setSettlementDate(LocalDate.of(2016, Month.JANUARY, 7));
		instruction.setUnits(new BigDecimal(1));
		instruction.setPricePerUnit(new BigDecimal(10.25));
		storage.add(instruction);

		
		instruction=new Instruction();
		instruction.setEntity(Entity.ENTITY3);
		instruction.setOperation(Operation.SELL);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.AED);
		instruction.setInstructionDate(LocalDate.of(2017, Month.JANUARY, 1));
		instruction.setSettlementDate(LocalDate.of(2017, Month.JANUARY, 5));
		instruction.setUnits(new BigDecimal(10));
		instruction.setPricePerUnit(new BigDecimal(100.25));
		storage.add(instruction);
		
		instruction=new Instruction();
		instruction.setEntity(Entity.ENTITY2);
		instruction.setOperation(Operation.SELL);
		instruction.setAgreedFx(new BigDecimal(0.5));
		instruction.setCurrency(Currency.AED);
		instruction.setInstructionDate(LocalDate.of(2017, Month.JANUARY, 1));
		instruction.setSettlementDate(LocalDate.of(2017, Month.JANUARY, 7));
		instruction.setUnits(new BigDecimal(1));
		instruction.setPricePerUnit(new BigDecimal(10.25));
		storage.add(instruction);
		
		ReportBuilder builder=new ReportBuilder(storage);
		Report report=builder.build();
		
		Viewer viewer=new SimpleViewer();
		viewer.show(report);
	}
	
}
