package mas.agents0815.rules;

import java.util.Collection;
import java.util.LinkedList;

import mas.agents0815.Const;
import mas.agents0815.SubsumptionAgent;
import massim.javaagents.agents2011.Mars2011Util;
import apltk.interpreter.data.LogicBelief;
import apltk.interpreter.data.LogicGoal;

import eis.iilang.Percept;

public class RuleProbe extends Rule {

	public boolean fire(Collection<Percept> percepts, Collection<LogicBelief> beliefs,Collection<LogicGoal> goals, SubsumptionAgent agent){

		LinkedList<LogicBelief> inzone = agent.getAllBeliefs(Const.INZONE);
		if(inzone.size()>0)
			return false;
		
			
		if (beliefs.contains(new LogicBelief(Const.UNPROBEDVERTEX, agent.getMyPos()))){
				setAction((Mars2011Util.probeAction()));
				return true;
			 
			}//if
		
		return false;
		
	}
}
