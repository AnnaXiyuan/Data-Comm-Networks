package tcp;

import Fsm.FSM;
import Fsm.State;
import Fsm.Event;
import Fsm.Action;
import Fsm.Transition;
import java.util.ArrayList;
import java.util.List;

public class TCPSetup {
    private final List<State> states = new ArrayList<>();
    private final List<Event> events = new ArrayList<>();
    private final List<Action> actions = new ArrayList<>();
    private final List<Transition> transitions = new ArrayList<>();

    public void initializeStates() {
        states.add(new TCPState.Closed());
        states.add(new TCPState.Listen());
        states.add(new TCPState.SYN_Sent());
        states.add(new TCPState.SYN_Rcvd());
        states.add(new TCPState.Established());
        states.add(new TCPState.FIN_Wait_1());
        states.add(new TCPState.FIN_Wait_2());
        states.add(new TCPState.Timed_Wait());
        states.add(new TCPState.Close_Wait());
        states.add(new TCPState.Last_ACK());
    }

    public void initializeEvents() {
        events.add(new TCPEvent.ActiveOpen());
        events.add(new TCPEvent.PassiveOpen());
        events.add(new TCPEvent.SYN());
        events.add(new TCPEvent.SYNACK());
        events.add(new TCPEvent.ACK());
        events.add(new TCPEvent.RDATA());
        events.add(new TCPEvent.SDATA());
        events.add(new TCPEvent.FIN());
        events.add(new TCPEvent.CLOSE());
        events.add(new TCPEvent.TIMEOUT());
    }

    public void initializeActions() {
        actions.add(new TCPAction.SendSYN());
        actions.add(new TCPAction.SendSYNACK());
        actions.add(new TCPAction.SendACK());
        actions.add(new TCPAction.ReceiveData(0)); // You might want to manage the data counter differently
        actions.add(new TCPAction.SendData(0));
        actions.add(new TCPAction.SendFIN());
        actions.add(new TCPAction.Close());
        actions.add(new TCPAction.StartTimer());
    }

    public void setupTransitions() {
        // Assuming fsm is a global FSM instance you would add transitions to
        // Here you would create and add your transitions based on the initialized states and actions
        // transitions.add(new Transition(...));
    }

    public State getState(String name) {
        return states.stream().filter(s -> s.getName().equals(name)).findFirst().orElse(null);
    }

    public List<Transition> getTransitions() {
        return transitions;
    }
}
