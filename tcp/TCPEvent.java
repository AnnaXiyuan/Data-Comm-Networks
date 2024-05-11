package tcp;

import Fsm.Event;

public class TCPEvent extends Event {
    private TCPEvent(String name) {
        super(name);
    }

    public static TCPEvent fromString(String eventName) {
        switch (eventName.toUpperCase()) {
            case "ACTIVE": return new ActiveOpen();
            case "PASSIVE": return new PassiveOpen();
            case "SYN": return new SYN();
            case "SYNACK": return new SYNACK();
            case "ACK": return new ACK();
            case "RDATA": return new RDATA();
            case "SDATA": return new SDATA();
            case "FIN": return new FIN();
            case "CLOSE": return new CLOSE();
            case "TIMEOUT": return new TIMEOUT();
            default: return null;
        }
    }

    public static class ActiveOpen extends TCPEvent { public ActiveOpen() { super("ACTIVE"); }}
    public static class PassiveOpen extends TCPEvent { public PassiveOpen() { super("PASSIVE"); }}
    public static class SYN extends TCPEvent { public SYN() { super("SYN"); }}
    public static class SYNACK extends TCPEvent { public SYNACK() { super("SYNACK"); }}
    public static class ACK extends TCPEvent { public ACK() { super("ACK"); }}
    public static class RDATA extends TCPEvent { public RDATA() { super("RDATA"); }}
    public static class SDATA extends TCPEvent { public SDATA() { super("SDATA"); }}
    public static class FIN extends TCPEvent { public FIN() { super("FIN"); }}
    public static class CLOSE extends TCPEvent { public CLOSE() { super("CLOSE"); }}
    public static class TIMEOUT extends TCPEvent { public TIMEOUT() { super("TIMEOUT"); }}
}
