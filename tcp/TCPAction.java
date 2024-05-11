package tcp;

import Fsm.Action;
import Fsm.Event;
import Fsm.FSM;

public abstract class TCPAction extends Action {
    @Override
    public abstract void execute(FSM fsm, Event event);

    public static class SendSYN extends TCPAction {
        @Override
        public void execute(FSM fsm, Event event) { System.out.println("Sending SYN"); }
    }
    public static class SendSYNACK extends TCPAction {
        @Override
        public void execute(FSM fsm, Event event) { System.out.println("Sending SYNACK"); }
    }
    public static class SendACK extends TCPAction {
        @Override
        public void execute(FSM fsm, Event event) { System.out.println("Sending ACK"); }
    }
    public static class ReceiveData extends TCPAction {
        private int counter;
        public ReceiveData(int counter) { this.counter = counter; }
        @Override
        public void execute(FSM fsm, Event event) { System.out.println("Received DATA: " + (++counter)); }
    }
    public static class SendData extends TCPAction {
        private int counter;
        public SendData(int counter) { this.counter = counter; }
        @Override
        public void execute(FSM fsm, Event event) { System.out.println("Sent DATA: " + (++counter)); }
    }
    public static class SendFIN extends TCPAction {
        @Override
        public void execute(FSM fsm, Event event) { System.out.println("Sending FIN"); }
    }
    public static class Close extends TCPAction {
        @Override
        public void execute(FSM fsm, Event event) { System.out.println("Closing connection"); }
    }
    public static class StartTimer extends TCPAction {
        @Override
        public void execute(FSM fsm, Event event) { System.out.println("Timer started"); }
    }
}
