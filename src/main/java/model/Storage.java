package model;

import java.util.List;

public interface Storage {

	void add(Instruction i);
	List<OperativeInstruction> getAll();
}
