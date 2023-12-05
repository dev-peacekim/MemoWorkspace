package command;

public class divCommand implements Command {

	@Override
	public float calc(int i, int j) {
		return (float)i / (float)j;
	}

}
