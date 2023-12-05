package command;

public class multiCommand implements Command {

	@Override
	public float calc(int i, int j) {
		return i*j;
	}

}
