package tcp;

import Fsm.FSM;
import Fsm.FsmException;
import java.util.Scanner;

public class TCPManager {
    private static int sdataCount = 0; // To track the number of SDATA events
    private static int rdataCount = 0; // To track the number of RDATA events

    public static void main(String[] args) {
        // Setup the TCP state machine
        TCPSetup setup = new TCPSetup();
        setup.initializeStates();
        setup.initializeEvents();
        setup.initializeActions();
        setup.setupTransitions();

        // Create the FSM and initialize it with the closed state
        FSM tcpFSM = new FSM("TCPConnection", setup.getState("Closed"));
        setup.getTransitions().forEach(transition -> {
            try {
                tcpFSM.addTransition(transition);
            } catch (FsmException e) {
                System.err.println("Failed to add transition: " + e.getMessage());
            }
        });

        // Start processing user input
        processUserInput(tcpFSM);
    }

    private static void processUserInput(FSM fsm) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter an event (or 'quit' to exit): ");
            String input = scanner.nextLine().trim();

            if ("quit".equalsIgnoreCase(input)) {
                scanner.close();
                break;
            }

            try {
                TCPEvent event = TCPEvent.fromString(input); // Assume there's a method to parse input to events
                if (event != null) {
                    fsm.doEvent(event);
                    System.out.println("Transitioned to state: " + fsm.currentState().getName());
                } else {
                    System.out.println("Invalid event: " + input);
                }
            } catch (FsmException e) {
                System.err.println("Error processing event: " + e.getMessage());
            }
        }
    }
}
