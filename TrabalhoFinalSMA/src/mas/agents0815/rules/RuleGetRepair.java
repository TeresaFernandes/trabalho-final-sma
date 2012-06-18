package mas.agents0815.rules;

import java.util.Collection;

import mas.agents0815.InternalAction;
import mas.agents0815.SubsumptionAgent;
import massim.javaagents.agents2011.Mars2011Util;

import apltk.interpreter.data.LogicBelief;
import apltk.interpreter.data.LogicGoal;
import eis.iilang.Percept;

public class RuleGetRepair extends Rule {

	@Override
	public boolean fire(Collection<Percept> percepts,
			Collection<LogicBelief> beliefs, Collection<LogicGoal> goals, SubsumptionAgent agent) {
		
		//fires if I am disabled
		
		if(agent.getMyHealth()==0){
			agent.clearGoals();
			//do I have enough energy for a walk?
			if (agent.getMyEnergy()<7){
				setAction(Mars2011Util.rechargeAction());
				return true;
			}else{
			setAction(new InternalAction ("getRepair"));
			return true;
			}
		}
		return false;
	}
}//class
