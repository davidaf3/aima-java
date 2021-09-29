package aima.core.environment.eightpuzzle;

import aima.core.agent.Action;
import aima.core.search.framework.problem.BidirectionalProblem;
import aima.core.search.framework.problem.GeneralProblem;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.problem.StepCostFunction;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author Ruediger Lunde
 * 
 */
public class BidirectionalEightPuzzleProblem extends GeneralProblem<EightPuzzleBoard, Action>
		implements BidirectionalProblem<EightPuzzleBoard, Action> {

	private final Problem<EightPuzzleBoard, Action> reverseProblem;

	public BidirectionalEightPuzzleProblem(EightPuzzleBoard initialState) {
		super(initialState, EightPuzzleFunctions::getActions, EightPuzzleFunctions::getResult,
				Predicate.isEqual(EightPuzzleFunctions.GOAL_STATE));

		reverseProblem = new GeneralProblem<>(EightPuzzleFunctions.GOAL_STATE,
				EightPuzzleFunctions::getActions, EightPuzzleFunctions::getResult,
				Predicate.isEqual(initialState));
	}
	
	 public BidirectionalEightPuzzleProblem(EightPuzzleBoard initialState, 
			 StepCostFunction<EightPuzzleBoard, Action> stepCostFn) {
		 super(initialState, EightPuzzleFunctions::getActions, EightPuzzleFunctions::getResult,
					Predicate.isEqual(EightPuzzleFunctions.GOAL_STATE), stepCostFn);
		 
		 reverseProblem = new GeneralProblem<>(EightPuzzleFunctions.GOAL_STATE,
					EightPuzzleFunctions::getActions, EightPuzzleFunctions::getResult,
					Predicate.isEqual(initialState), stepCostFn);
	 }

	public Problem<EightPuzzleBoard, Action> getOriginalProblem() {
		return this;
	}

	public Problem<EightPuzzleBoard, Action> getReverseProblem() {
		return reverseProblem;
	}
}
