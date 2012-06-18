package mas.agents0815.rules;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import mas.agents0815.Const;
import mas.agents0815.InternalAction;
import mas.agents0815.SubsumptionAgent;
import massim.javaagents.agents2011.Mars2011Util;
import apltk.interpreter.data.LogicBelief;
import apltk.interpreter.data.LogicGoal;
import eis.iilang.Percept;

/*
 *  Wenn ich in meiner Scannreichweite einen Enemy Entity,
 *	dann will ich ihn kennenlernen
 */
public class RuleInspect extends Rule{
	
	@Override
	public boolean fire(Collection<Percept> percepts,
			Collection<LogicBelief> beliefs, Collection<LogicGoal> goals,
			SubsumptionAgent agent) {
		
		//fires whenever an enemy is in range for an inspect
		List<String> allNeighbours = new ArrayList<String>();
		
		for(LogicBelief b : beliefs){
			if(b.getPredicate().equals(Const.NEIGHBOR)){
				allNeighbours.add(b.getParameters().get(0).toString());
			}
		}
		
		for(LogicBelief b : beliefs){
			
			if(b.getPredicate().equals(Const.VISIBLEENEMY)){
				
				if(allNeighbours.contains(b.getParameters().get(1).toString())){
					//do need a recharge? 
					if (agent.getMyEnergy()<2){
						 setAction(Mars2011Util.rechargeAction());
						return true;						
					 }
					else{
						setAction(Mars2011Util.inspectAction());
						return true;
					}
				}//if
			}//if
		}//for
		
		return false;
	}

}
