package aima.gui.demo.search;

import aima.core.environment.nqueens.NQueensBoard;
import aima.core.environment.nqueens.NQueensBoard.Config;
import aima.core.environment.nqueens.NQueensFunctions;
import aima.core.environment.nqueens.NQueensGenAlgoUtil;
import aima.core.environment.nqueens.QueenAction;
import aima.core.search.framework.SearchForActions;
import aima.core.search.framework.problem.Problem;
import aima.core.search.framework.qsearch.GraphSearch;
import aima.core.search.framework.qsearch.GraphSearch4e;
import aima.core.search.framework.qsearch.TreeSearch;
import aima.core.search.informed.AStarSearch;
import aima.core.search.local.*;
import aima.core.search.uninformed.BreadthFirstSearch;
import aima.core.search.uninformed.DepthFirstSearch;
import aima.core.search.uninformed.DepthLimitedSearch;
import aima.core.search.uninformed.IterativeDeepeningSearch;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;

/**
 * Demonsrates how different search algorithms perform on the NQueens problem.
 * @author Ruediger Lunde
 * @author Ravi Mohan
 */

public class NQueensDemo {
	
	private static final int popSize = 50;
	private static final double mutationProbability = 0.15;
	private static final int numberOfGenerations = 100;
	private static final double crossoverProbability = 0.8;
	
	private static final int boardSize = 8;

	public static void main(String[] args) {
		startNQueensDemo();
	}

	private static void startNQueensDemo() {
//		solveNQueensWithDepthFirstSearch();
//		solveNQueensWithBreadthFirstSearch();
		
//		solveNQueensWithAStarSearchIncrementalH0();
//		solveNQueensWithAStarSearchComplete1H0();
//		solveNQueensWithAStarSearchComplete2H0();
//		solveNQueensWithAStarSearchComplete3H0();
		
//		solveNQueensWithAStarSearchComplete1AttackingPairs();
//		solveNQueensWithAStarSearchComplete2AttackingPairs();
//		solveNQueensWithAStarSearchComplete3AttackingPairs();
		
//		solveNQueensWithAStarSearchComplete1AttackedQueens();
//		solveNQueensWithAStarSearchComplete2AttackedQueens();
//		solveNQueensWithAStarSearchComplete3AttackedQueens();
		
//		solveNQueensWithAStarSearchComplete1Aligned();
//		solveNQueensWithAStarSearchComplete2Aligned();
//		solveNQueensWithAStarSearchComplete3Aligned();
		
//		solveNQueensWithAStarSearchIncrementalProbabilistic();
		
		solveNQueensWithGeneticAlgorithmSearch();
		
//		solveNQueensWithAStarSearch4e();
//		solveNQueensWithRecursiveDLS();
//		solveNQueensWithIterativeDeepeningSearch();
//		solveNQueensWithSimulatedAnnealingSearch();
//		solveNQueensWithHillClimbingSearch();
//		solveNQueensWithRandomWalk();
	}

	private static void solveNQueensWithDepthFirstSearch() {
		System.out.println("\n--- NQueensDemo DFS ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(boardSize);
		SearchForActions<NQueensBoard, QueenAction> search = new DepthFirstSearch<>(new TreeSearch<>());
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}

	private static void solveNQueensWithBreadthFirstSearch() {
		System.out.println("\n--- NQueensDemo BFS ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(boardSize);
		SearchForActions<NQueensBoard, QueenAction> search = new BreadthFirstSearch<>(new GraphSearch<>());
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchIncrementalH0() {
		System.out.println("\n--- NQueensDemo A* (incremental state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(boardSize);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new TreeSearch<>(), node -> 0);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchComplete1H0() {
		System.out.println("\n--- NQueensDemo A* (complete-1 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEENS_IN_FIRST_ROW);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), node -> 0);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchComplete2H0() {
		System.out.println("\n--- NQueensDemo A* (complete-2 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEEN_IN_EVERY_COL);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), node -> 0);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchComplete3H0() {
		System.out.println("\n--- NQueensDemo A* (complete-3 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEEN_IN_EVERY_COL_ROW);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), node -> 0);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchComplete1AttackingPairs() {
		System.out.println("\n--- NQueensDemo A* (complete-1 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEENS_IN_FIRST_ROW);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), NQueensFunctions::getNumberOfAttackingPairs);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchComplete2AttackingPairs() {
		System.out.println("\n--- NQueensDemo A* (complete-2 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEEN_IN_EVERY_COL);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), NQueensFunctions::getNumberOfAttackingPairs);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}

	private static void solveNQueensWithAStarSearchComplete3AttackingPairs() {
		System.out.println("\n--- NQueensDemo A* (complete-3 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEEN_IN_EVERY_COL_ROW);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), NQueensFunctions::getNumberOfAttackingPairs);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchComplete1AttackedQueens() {
		System.out.println("\n--- NQueensDemo A* (complete-1 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEENS_IN_FIRST_ROW);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), NQueensFunctions::getNumberOfAttackedQueens);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchComplete2AttackedQueens() {
		System.out.println("\n--- NQueensDemo A* (complete-2 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEEN_IN_EVERY_COL);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), NQueensFunctions::getNumberOfAttackedQueens);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}

	private static void solveNQueensWithAStarSearchComplete3AttackedQueens() {
		System.out.println("\n--- NQueensDemo A* (complete-3 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEEN_IN_EVERY_COL_ROW);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), NQueensFunctions::getNumberOfAttackedQueens);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchComplete1Aligned() {
		System.out.println("\n--- NQueensDemo A* (complete-1 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEENS_IN_FIRST_ROW);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), NQueensFunctions::getMaximumNumberOfQueensAlignedMinusOne);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchComplete2Aligned() {
		System.out.println("\n--- NQueensDemo A* (complete-2 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEEN_IN_EVERY_COL);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), NQueensFunctions::getMaximumNumberOfQueensAlignedMinusOne);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}

	private static void solveNQueensWithAStarSearchComplete3Aligned() {
		System.out.println("\n--- NQueensDemo A* (complete-3 state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEEN_IN_EVERY_COL_ROW);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch<>(), NQueensFunctions::getMaximumNumberOfQueensAlignedMinusOne);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}
	
	private static void solveNQueensWithAStarSearchIncrementalProbabilistic() {
		System.out.println("\n--- NQueensDemo A* (incremental state formulation, graph search 3e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(boardSize);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new TreeSearch<>(), NQueensFunctions::getHeuristicProbabilisticEstimationOfSolution);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}

	private static void solveNQueensWithAStarSearch4e() {
		System.out.println("\n--- NQueensDemo A* (complete state formulation, graph search 4e) ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createCompleteStateFormulationProblem
				(boardSize, Config.QUEENS_IN_FIRST_ROW);
		SearchForActions<NQueensBoard, QueenAction> search = new AStarSearch<>
				(new GraphSearch4e<>(), NQueensFunctions::getNumberOfAttackingPairs);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}

	private static void solveNQueensWithRecursiveDLS() {
		System.out.println("\n--- NQueensDemo recursive DLS ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(boardSize);
		SearchForActions<NQueensBoard, QueenAction> search = new DepthLimitedSearch<>(boardSize);
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}

	private static void solveNQueensWithIterativeDeepeningSearch() {
		System.out.println("\n--- NQueensDemo Iterative DS ---");

		Problem<NQueensBoard, QueenAction> problem = NQueensFunctions.createIncrementalFormulationProblem(boardSize);
		SearchForActions<NQueensBoard, QueenAction> search = new IterativeDeepeningSearch<>();
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
	}

	private static void solveNQueensWithSimulatedAnnealingSearch() {
		System.out.println("\n--- NQueensDemo Simulated Annealing ---");

		Problem<NQueensBoard, QueenAction> problem =
				NQueensFunctions.createCompleteStateFormulationProblem(boardSize, Config.QUEENS_IN_FIRST_ROW);
		SimulatedAnnealingSearch<NQueensBoard, QueenAction> search =
				new SimulatedAnnealingSearch<>(NQueensFunctions::getNumberOfAttackingPairs,
						new Scheduler(20, 0.045, 100));
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
		System.out.println("Final State:\n" + search.getLastState());
	}

	private static void solveNQueensWithHillClimbingSearch() {
		System.out.println("\n--- NQueensDemo HillClimbing ---");

		Problem<NQueensBoard, QueenAction> problem =
				NQueensFunctions.createCompleteStateFormulationProblem(boardSize, Config.QUEENS_IN_FIRST_ROW);
		HillClimbingSearch<NQueensBoard, QueenAction> search = new HillClimbingSearch<>
				(n -> -NQueensFunctions.getNumberOfAttackingPairs(n));
		Optional<List<QueenAction>> actions = search.findActions(problem);

		actions.ifPresent(qActions -> qActions.forEach(System.out::println));
		System.out.println(search.getMetrics());
		System.out.println("Final State:\n" + search.getLastState());
	}

	private static void solveNQueensWithGeneticAlgorithmSearch() {
		System.out.println("\n--- NQueensDemo GeneticAlgorithm ---");

		FitnessFunction<Integer> fitnessFunction = NQueensGenAlgoUtil.getFitnessFunction();
		Predicate<Individual<Integer>> goalTest = NQueensGenAlgoUtil.getGoalTest();
		// Generate an initial population
		Set<Individual<Integer>> population = new HashSet<>();
		for (int i = 0; i < popSize; i++)
			population.add(NQueensGenAlgoUtil.generateRandomIndividual(boardSize));

		GeneticAlgorithm<Integer> ga = new GeneticAlgorithm<>(boardSize,
				NQueensGenAlgoUtil.getFiniteAlphabetForBoardOfSize(boardSize), mutationProbability, crossoverProbability);

		Individual<Integer> bestIndividual = ga.geneticAlgorithm(population, fitnessFunction, numberOfGenerations);
		System.out.println("100 generations, Best Individual:\n"
				+ NQueensGenAlgoUtil.getBoardForIndividual(bestIndividual));
		System.out.println("Board Size      = " + boardSize);
		System.out.println("# Board Layouts = " + (new BigDecimal(boardSize)).pow(boardSize));
		System.out.println("Fitness         = " + fitnessFunction.apply(bestIndividual));
		System.out.println("Is Goal         = " + goalTest.test(bestIndividual));
		System.out.println("Population Size = " + ga.getPopulationSize());
		System.out.println("Iterations      = " + ga.getIterations());
		System.out.println("Took            = " + ga.getTimeInMilliseconds() + "ms.");
	}

	// Here, this trivial algorithm outperforms the genetic search approach as described in the textbook!
	private static void solveNQueensWithRandomWalk() {
		System.out.println("\n--- NQueensDemo RandomWalk ---");
		NQueensBoard board;
		int i = 0;
		long startTime = System.currentTimeMillis();
		do {
			i++;
			board = new NQueensBoard(boardSize, Config.QUEEN_IN_EVERY_COL);
		} while (board.getNumberOfAttackingPairs() > 0);
		long stopTime = System.currentTimeMillis();
		System.out.println("Solution found after generating " + i + " random configurations ("
				+ (stopTime - startTime) + " ms).");
	}
}
