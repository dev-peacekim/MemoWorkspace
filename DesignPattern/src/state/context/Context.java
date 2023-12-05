package state.context;

import state.state.State;

public interface Context {

	public abstract void setNum();
	public abstract void changeState(State state);
	
}
