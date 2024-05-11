package tcp;

import Fsm.State;

public abstract class TCPState extends State {
    protected TCPState(String name) {
        super(name);
    }

    public static class Closed extends TCPState { public Closed() { super("Closed"); }}
    public static class Listen extends TCPState { public Listen() { super("Listen"); }}
    public static class SYN_Sent extends TCPState { public SYN_Sent() { super("SYN_Sent"); }}
    public static class SYN_Rcvd extends TCPState { public SYN_Rcvd() { super("SYN_Rcvd"); }}
    public static class Established extends TCPState { public Established() { super("Established"); }}
    public static class FIN_Wait_1 extends TCPState { public FIN_Wait_1() { super("FIN_Wait_1"); }}
    public static class FIN_Wait_2 extends TCPState { public FIN_Wait_2() { super("FIN_Wait_2"); }}
    public static class Timed_Wait extends TCPState { public Timed_Wait() { super("Timed_Wait"); }}
    public static class Close_Wait extends TCPState { public Close_Wait() { super("Close_Wait"); }}
    public static class Last_ACK extends TCPState { public Last_ACK() { super("Last_ACK"); }}
}
