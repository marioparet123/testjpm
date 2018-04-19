package model;

import java.util.ArrayList;
import java.util.List;

public class StorageInMemory implements Storage {

	List<OperativeInstruction> instructionList=new ArrayList<OperativeInstruction>();

	@Override
	public void add(Instruction instructionPar)
	{
		OperativeInstruction operativeInstruction=new OperativeInstruction(instructionPar);
		instructionList.add(operativeInstruction);
	}

	@Override
	public List<OperativeInstruction> getAll() {
		return instructionList;
	}
}
