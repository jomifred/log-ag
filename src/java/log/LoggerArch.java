package log;

import jason.architecture.*;
import jason.asSemantics.*;
import jason.asSyntax.*;
import jason.runtime.RuntimeServicesFactory;

import java.rmi.RemoteException;
import java.util.*;

public class LoggerArch extends AgArch {

    // works only with jacamo1.2-SNAPSHOT
    @Override
    public void act(ActionExec action) {
        System.out.println("log: 1.doing "+getTS().getC().getAction().getActionTerm());
        super.act(action);
    }

    @Override
    public void reasoningCycleFinished() {
        if (getTS().getC().getAction() != null)  {
            System.out.println("log: 2.doing "+getTS().getC().getAction().getActionTerm());
        } else {
            PlanBody p = getTS().getC().getLastDeed();
            if (p != null)  {
                System.out.println("log: last deed: "+p.getBodyTerm() + " of type " + p.getBodyType().name() + " from "+ p.getBodyTerm().getSrcInfo());
            }
        }
    }

    // TODO: see other methods from AgArch to Override
}
