package command;

public class addCommand implements Command {

	@Override
	public float calc(int i, int j) {
		return i+j;
	}

}
