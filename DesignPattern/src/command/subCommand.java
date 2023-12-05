package command;

public class subCommand implements Command {

	@Override
	public float calc(int i, int j) {
		return i - j;
	}

}
