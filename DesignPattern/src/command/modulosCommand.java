package command;

public class modulosCommand implements Command {

	@Override
	public float calc(int i, int j) {
		return i % j;
	}

}
